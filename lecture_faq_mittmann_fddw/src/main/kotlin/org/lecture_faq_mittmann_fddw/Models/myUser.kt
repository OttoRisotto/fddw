package org.lecture_faq_mittmann_fddw.Models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class myUser(){
    @Id
    val id: UUID = UUID.randomUUID()
    var firstName: String = ""
    var lastName: String = ""
    var email: String = ""

    override fun toString(): String{
        return "$firstName $lastName($email, $id)"
    }
}
