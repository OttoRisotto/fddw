package org.lecture_faq_mittmann_fddw.Models.DTOs

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Size
import org.lecture_faq_mittmann_fddw.Models.Role

data class UserDTO(

    val firstName: String?,
    val lastName: String?,

    @Size(min = 5, max = 50)
    @Email
    var email: String?,

    var role: Role?
)
