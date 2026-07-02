package org.lecture_faq_mittmann_fddw.Models.lecture

import jakarta.persistence.Enumerated
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.URL
import org.lecture_faq_mittmann_fddw.Models.Type

data class CreateLectureDTO (

    @field:Size(min = 3, max = 50)
    @field:NotBlank
    val title: String,

    @field:Size(min = 3, max = 100)
    val description: String,

    @Enumerated
    val type: Type = Type.OnSite,

    @field:URL(message = "Die Eingabe muss im URL-Format vorliegen")
    val link: String,

    val code: Short

)


data class UpdateLectureDTO (

    @field:Size(min = 3, max = 50)
    val title: String?,

    @field:Size(min = 3, max = 100)
    val description:String?,

    @Enumerated
    val type:Type?,

    @field:URL(message = "Die Eingabe muss im URL-Format vorliegen")
    val link:String?,

    val code: Short?

)


