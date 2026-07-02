package org.lecture_faq_mittmann_fddw.Models.DTOs

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.lecture_faq_mittmann_fddw.Models.User

data class PollDTO(

    @Size(min = 5, max = 50)
    @NotBlank
    val title: String?,

    @Size(min = 3, max = 100)
    val description: String?

)
