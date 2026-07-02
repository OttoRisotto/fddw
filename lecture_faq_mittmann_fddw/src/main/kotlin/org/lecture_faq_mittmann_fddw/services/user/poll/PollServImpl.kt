package org.lecture_faq_mittmann_fddw.services.user.poll

import org.lecture_faq_mittmann_fddw.Models.user.poll.createPollDTO
import org.lecture_faq_mittmann_fddw.Models.user.poll.updatePollDTO
import org.lecture_faq_mittmann_fddw.Models.user.poll.Poll
import org.lecture_faq_mittmann_fddw.Repository.PollRepo
import org.lecture_faq_mittmann_fddw.services.user.UserService
import org.lecture_faq_mittmann_fddw.services.user.poll.answer.AnswerServ
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class PollServImpl(val repo: PollRepo, val uServ: UserService, val aServ: AnswerServ): PollServ {

    override fun getPoll(uId:UUID, pId:UUID): Poll {
        val poll = repo.getPoll( uId, pId ) ?: run {
                // Fehlerbehandlung
                uServ.getUser(uId) // wirft Http-Exception, wenn user nicht existiert
                repo.getPollById(uId) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Poll ${pId} existiert nicht")
                throw ResponseStatusException(HttpStatus.NOT_FOUND) //Poll pId gehört nicht zu User uId
        }
        return poll
    }

    override fun getPollsByUser(uId: UUID):List<Poll> {
        val polls = repo.getPollsByUserId(uId)
        if (polls.isEmpty()){
            /* es existieren 2 Fälle, wenn Liste polls leer
            *   1. es existieren für User keine Polls
            *   2. User existiert nicht -> uServ.getUser(uId)*/
            /* uServ
                -> throw RequestException 404 "User existiert nicht",
                   falls userRepo.getUserById() null zurück gibt */
            uServ.getUser(uId)
        }
        return polls
    }

    override fun addPoll(uId: UUID, createPollDTO: createPollDTO) {

        val poll = Poll()

        poll.title = createPollDTO.title
        val user = uServ.getUser(uId)
        poll.user = user
        poll.description = createPollDTO.description

        val answerDTOs = createPollDTO.answers //check: mindestens 2 answers
        poll.answers = aServ.addNewAnswers( uId, poll.id, answerDTOs )

        repo.save(poll)
    }

    override fun updatePoll(
        uId: UUID,
        pId: UUID,
        updatePollDTO:updatePollDTO
    ) {
       val poll = getPoll(uId, pId)
        if (updatePollDTO.title       != null) { poll.title       = updatePollDTO.title }
        if (updatePollDTO.description != null) { poll.description = updatePollDTO.description }
        repo.save(poll)
    }



    override fun deletePollById(uId: UUID, pId: UUID) {
        val poll = getPoll(uId, pId)
        val answers = aServ.getPollAnswers(uId, pId)

        for(answer in answers){
            aServ.deleteAnswer(uId, pId, answer.id)
        }

        repo.delete(poll)
    }

}
