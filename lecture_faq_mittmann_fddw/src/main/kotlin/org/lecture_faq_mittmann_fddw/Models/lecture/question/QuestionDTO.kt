package org.lecture_faq_mittmann_fddw.Models.lecture.question

import jakarta.validation.constraints.Size

data class CreateQuestionDTO(

    @field:Size(min= 3, max = 50)
    var text: String

)

data class UpdateQuestionDTO(

    @field:Size(min=3, max=50)
    val text: String?

)
