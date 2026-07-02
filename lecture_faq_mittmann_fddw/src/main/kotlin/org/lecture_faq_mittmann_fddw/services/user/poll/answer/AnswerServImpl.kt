package org.lecture_faq_mittmann_fddw.services.user.poll.answer

import org.lecture_faq_mittmann_fddw.Models.Answer
import org.lecture_faq_mittmann_fddw.Repository.AnswerRepo
import org.lecture_faq_mittmann_fddw.services.user.poll.PollServ
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class AnswerServImpl(val repo:AnswerRepo, val pSrv:PollServ ): AnswerServ {

    override fun getAnswerById( uId:UUID, pId:UUID, aId:UUID ): Answer{
        return repo.getAnswer(uId, pId, aId) ?: run {
            // Error catching
            pSrv.getPoll(uId, pId) // fängt, bei Fehler, alles bis zur Ebene Poll ab
            repo.getAnswerById(aId) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Answer ${aId} existiert nicht")
            throw ResponseStatusException(HttpStatus.NOT_FOUND) //
        }
    }

    override fun getPollAnswers( uId:UUID, pId:UUID ): List<Answer> {
        return repo.getAnswersByPollId( uId, pId )
    }

    override fun addNewAnswer( uId:UUID, pId:UUID, text:String ) {
        val answer = Answer()
        answer.text = text
        answer.poll = pSrv.getPoll(uId, pId)

        repo.save(answer)
    }

    override fun updateAnswer( text:String?, count:Short?, uId:UUID, pId:UUID, aId:UUID ) {
        val answer = this.getAnswerById(uId, pId, aId)
        if( text != null ) {answer.text = text}
        if ( count != null ) {answer.count = count}
        repo.save( answer )
    }

    override fun deleteAnswer( uId:UUID, pId:UUID, aId:UUID ) {
        val pollAnswers = this.getPollAnswers( uId , pId )
        if (pollAnswers.count()<2){
            throw ResponseStatusException(HttpStatus.CONFLICT, "Löschvorgang abgebrochen: ein Poll muss mindestens 2 Answers haben ")
        }
        repo.deleteAnswerById(aId)
    }

}
