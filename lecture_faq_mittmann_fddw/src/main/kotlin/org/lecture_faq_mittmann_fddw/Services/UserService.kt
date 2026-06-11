package org.lecture_faq_mittmann_fddw.Services

import org.lecture_faq_mittmann_fddw.Models.myUser
import java.util.UUID

interface UserService {
    fun getUser(id: UUID): myUser
    fun getUsers(firstName: String?, lastName: String?): List<myUser>
    fun addUser(firstName: String, lastName: String, email: String)
    fun editUser(id: UUID, firstName: String?, lastName: String?, email: String?)
    fun deleteUser(id: UUID)
}
