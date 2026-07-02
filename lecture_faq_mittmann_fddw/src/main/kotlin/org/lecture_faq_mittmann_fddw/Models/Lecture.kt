package org.lecture_faq_mittmann_fddw.Models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.UUID

@Entity
class Lecture {

    @Id
    val id = UUID.randomUUID()

    var title = ""
    var description = ""
    var type = Type.OnSite
    var link: String = ""

    @ManyToOne
    var user: User = User()
    var code: Short = 0

}
