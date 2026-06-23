package org.lecture_faq_mittmann_fddw.Services

import org.lecture_faq_mittmann_fddw.Models.Role
import org.lecture_faq_mittmann_fddw.Models.MyUser
import java.util.UUID

interface UserService {
    fun getUser(id: UUID): MyUser
    fun getUsers(firstName: String?, lastName: String?, role: Role?): List<MyUser>
    fun addUser(firstName: String, lastName: String, email: String, role: Role)
    fun editUser(id: UUID, firstName: String?, lastName: String?, email: String?, role: Role?)
    fun deleteUser(id: UUID)
}
