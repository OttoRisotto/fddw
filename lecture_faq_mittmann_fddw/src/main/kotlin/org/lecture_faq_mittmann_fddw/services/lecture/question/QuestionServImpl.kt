package org.lecture_faq_mittmann_fddw.services.lecture.question

import org.lecture_faq_mittmann_fddw.Models.lecture.question.CreateQuestionDTO
import org.lecture_faq_mittmann_fddw.Models.lecture.question.Question
import org.lecture_faq_mittmann_fddw.Models.lecture.question.UpdateQuestionDTO
import org.lecture_faq_mittmann_fddw.Models.user.UserDTO
import org.lecture_faq_mittmann_fddw.Repository.QuestionRepo
import org.lecture_faq_mittmann_fddw.services.lecture.LectureService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class QuestionServImpl(val repo:QuestionRepo, val lServ: LectureService) : QuestionServ {
    override fun getQuestion( uId:UUID, lId:UUID, qId:UUID ):Question {
        val question = repo.getQuestion( uId, lId, qId ) ?: run{
            lServ.getLecture(uId, lId) // fängt, bei Fehler, alle not_found bis zur Ebene Poll ab
            repo.getQuestionById(qId) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Question mit $qId existiert nicht")
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        return question
    }

    override fun getQuestionsByLecture( uId:UUID, lId:UUID ):List<Question>{
        return repo.getQuestionsByLecture( uId, lId )
    }

    override fun addQuestion( uId:UUID, lId:UUID, dto:CreateQuestionDTO ) {
        val question = Question()

        val lecture = lServ.getLecture(uId, lId)
        val user = lecture.user

        question.lecture = lecture
        question.user = user
        question.text = dto.text

        repo.save(question)
    }

    override fun updateQuestion(uId:UUID, lId:UUID, qId:UUID, dto:UpdateQuestionDTO ) {

        val question = getQuestion(uId, lId, qId)
        if( dto.text != null ){ question.text = dto.text }

        repo.save(question)
    }

    override fun deleteQuestion( uId:UUID, lId:UUID, qId:UUID ) {
        val question = this.getQuestion(uId, lId, qId)
        repo.delete(question)
    }

}