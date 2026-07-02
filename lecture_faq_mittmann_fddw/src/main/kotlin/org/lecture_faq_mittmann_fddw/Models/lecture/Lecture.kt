package org.lecture_faq_mittmann_fddw.Models.lecture

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.lecture_faq_mittmann_fddw.Models.Type
import org.lecture_faq_mittmann_fddw.Models.user.User
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
    var user:User = User()

    var code: Short = 0

}