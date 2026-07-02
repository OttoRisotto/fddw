package org.lecture_faq_mittmann_fddw.Models.DTOs

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class PollDTO(

    @Size(min = 5, max = 50)
    @NotBlank
    val title: String?,

    @Size(min = 3, max = 100)
    val description: String?,

    @NotNull
    @Size(min = 2, message = "Ein Poll muss mind. 2 Antwortmöglichkeiten haben")
    val answers: MutableList<AnswerDTO>

)
