package org.lecture_faq_mittmann_fddw.Models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class User(){
    @Id
    val id: UUID = UUID.randomUUID()
    var email= ""
    var firstName = ""
    var lastName = ""
    
    override fun toString(): String{
        return "$firstName $lastName($email, $id)"
    }

}
