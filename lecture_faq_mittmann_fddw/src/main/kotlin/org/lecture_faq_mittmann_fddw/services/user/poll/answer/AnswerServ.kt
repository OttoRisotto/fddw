package org.lecture_faq_mittmann_fddw.services.user.poll.answer

import org.lecture_faq_mittmann_fddw.Models.Answer
import org.lecture_faq_mittmann_fddw.Models.DTOs.AnswerDTO
import java.util.UUID

interface AnswerServ {

    fun getAnswerById( uId:UUID, pId:UUID, aId:UUID ): Answer
    fun getPollAnswers( uId:UUID, pId:UUID ): List<Answer>

    fun addNewAnswer( uId:UUID, pId:UUID, answerDto: AnswerDTO ): Answer
    fun addNewAnswers( uId:UUID, pId:UUID, answerDTOs: List<AnswerDTO>): MutableList<Answer>

    fun updateAnswer(answerDto: AnswerDTO, uId:UUID, pId:UUID, aId:UUID )

    fun deleteAnswer( uId:UUID, pId:UUID, aId:UUID )

}
