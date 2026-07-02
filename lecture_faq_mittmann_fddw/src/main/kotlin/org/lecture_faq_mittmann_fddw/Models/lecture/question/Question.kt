package org.lecture_faq_mittmann_fddw.Models.lecture.question

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.lecture_faq_mittmann_fddw.Models.lecture.Lecture
import org.lecture_faq_mittmann_fddw.Models.user.User
import java.util.UUID

@Entity
class Question {

    @Id
    val id = UUID.randomUUID()

    @ManyToOne
    var lecture:Lecture = Lecture()

    @ManyToOne
    var user = User()

    var text = ""

}