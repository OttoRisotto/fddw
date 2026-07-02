package org.lecture_faq_mittmann_fddw.Models.user.poll.Answer

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.lecture_faq_mittmann_fddw.Models.user.poll.Poll
import java.util.UUID

@Entity
class Answer {

    @Id
    val id:UUID = UUID.randomUUID()

    @ManyToOne
    var poll:Poll = Poll()

    var text: String = ""
    var count: Short = 0

}