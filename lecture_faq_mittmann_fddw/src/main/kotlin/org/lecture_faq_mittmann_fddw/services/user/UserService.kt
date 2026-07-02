package org.lecture_faq_mittmann_fddw.services.user

import org.lecture_faq_mittmann_fddw.Models.Role
import org.lecture_faq_mittmann_fddw.Models.User
import java.util.UUID

interface UserService {
    fun getUser(id: UUID): User
    fun getUsers(firstName: String?, lastName: String?, role: Role?): List<User>
    fun addUser(firstName: String, lastName: String, email: String, role: Role)
    fun editUser(id: UUID, firstName: String?, lastName: String?, email: String?, role: Role?)
    fun deleteUser(id: UUID)
}
