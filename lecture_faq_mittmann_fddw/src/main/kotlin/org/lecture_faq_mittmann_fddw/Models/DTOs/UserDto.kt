package org.lecture_faq_mittmann_fddw.Models.DTOs

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Size
import org.lecture_faq_mittmann_fddw.Models.Role

class UserDto{

    var firstName: String? = null
    var lastName: String? = null

    @Size(min = 5, max = 50)
    @Email
    var email: String? = null

    var role: Role? = null


}