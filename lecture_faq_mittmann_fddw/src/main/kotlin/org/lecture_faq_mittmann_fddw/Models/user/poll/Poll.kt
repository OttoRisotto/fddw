package org.lecture_faq_mittmann_fddw.Models.user.poll

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import org.lecture_faq_mittmann_fddw.Models.user.poll.Answer.Answer
import org.lecture_faq_mittmann_fddw.Models.user.User
import java.util.UUID

@Entity
class Poll{
    @Id
    val id:UUID = UUID.randomUUID()
    var title = ""
    var description= ""

    @ManyToOne
    var user:User = User()

    @OneToMany
    var answers: MutableList<Answer> = mutableListOf()

}