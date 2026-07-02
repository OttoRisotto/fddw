package org.lecture_faq_mittmann_fddw.Models.user.poll.Answer

import jakarta.validation.constraints.NotEmpty

class AnswerDTO (

    @NotEmpty
    val text: String?,
    val count: Short?

    )