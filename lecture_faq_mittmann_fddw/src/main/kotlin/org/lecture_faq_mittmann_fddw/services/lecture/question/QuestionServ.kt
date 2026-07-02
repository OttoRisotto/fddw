package org.lecture_faq_mittmann_fddw.services.lecture.question

import org.lecture_faq_mittmann_fddw.Models.lecture.question.CreateQuestionDTO
import org.lecture_faq_mittmann_fddw.Models.lecture.question.Question
import org.lecture_faq_mittmann_fddw.Models.lecture.question.UpdateQuestionDTO
import org.lecture_faq_mittmann_fddw.Models.user.UserDTO
import java.util.UUID

interface QuestionServ {

    fun getQuestion(uId:UUID, lId: UUID, qId: UUID): Question
    fun getQuestionsByLecture(uId:UUID, lId:UUID): List<Question>

    fun addQuestion( uId:UUID, lId:UUID, dto:CreateQuestionDTO)
    fun updateQuestion( uId:UUID, lId:UUID, qId:UUID, dto:UpdateQuestionDTO)

    fun deleteQuestion( uId:UUID, lId:UUID, qId:UUID )

}