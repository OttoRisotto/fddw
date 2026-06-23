package org.lecture_faq_mittmann_fddw.Models

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import java.util.UUID

@Entity
class MyUser(){
    @Id
    val id: UUID = UUID.randomUUID()
    var firstName: String = ""
    var lastName: String = ""
    var email: String = ""

    @Enumerated(EnumType.STRING)
    var role: Role = Role.Student

    override fun toString(): String{
        return "$firstName $lastName($role, $email, $id)"
    }
}
