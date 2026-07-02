package org.lecture_faq_mittmann_fddw.Models.user.poll

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.lecture_faq_mittmann_fddw.Models.user.poll.Answer.AnswerDTO

data class createPollDTO(

    @field:Size(min = 3, max = 50)
    @NotBlank
    val title: String,

    @field:Size(min = 3, max = 100)
    val description: String,

    @field:Size(min = 2, message = "Ein Poll muss mind. 2 Antwortmöglichkeiten haben")
    var answers: MutableList<@Valid AnswerDTO>

)

data class updatePollDTO(
    @field:Size(min = 5, max = 50)
    val title: String?,

    @field:Size(min = 3, max = 100)
    val description:String?,

)
