package org.lecture_faq_mittmann_fddw.Models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.util.UUID

@Entity
class Poll{
    @Id
    val id: UUID = UUID.randomUUID()
    var title = ""
    var description= ""

    @ManyToOne
    var user: User = User()

    @OneToMany
    var answers: MutableList<Answer> = mutableListOf()

}
