package org.lecture_faq_mittmann_fddw.services.user.poll.answer

import org.lecture_faq_mittmann_fddw.Models.user.poll.Answer.Answer
import org.lecture_faq_mittmann_fddw.Models.user.poll.Answer.AnswerDTO
import java.util.UUID

interface AnswerServ {

    fun getAnswerById( uId:UUID, pId:UUID, aId:UUID ): Answer
    fun getPollAnswers( uId:UUID, pId:UUID ): List<Answer>

    fun addNewAnswer( uId:UUID, pId:UUID, answerDto: AnswerDTO ): Answer
    fun addNewAnswers( uId:UUID, pId:UUID, answerDTOs: List<AnswerDTO>): MutableList<Answer>

    fun updateAnswer(answerDto: AnswerDTO, uId:UUID, pId:UUID, aId:UUID )

    fun deleteAnswer( uId:UUID, pId:UUID, aId:UUID )

}
