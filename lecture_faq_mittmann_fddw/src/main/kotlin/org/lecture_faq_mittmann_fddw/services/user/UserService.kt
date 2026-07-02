package org.lecture_faq_mittmann_fddw.services.user

import org.lecture_faq_mittmann_fddw.Models.user.UserDTO
import org.lecture_faq_mittmann_fddw.Models.Role
import org.lecture_faq_mittmann_fddw.Models.user.User
import java.util.UUID

interface UserService {
    fun getUser(id: UUID): User
    fun getUsers( firstName: String?, lastName: String?, role: Role? ): List<User>
    fun addUser(userDto: UserDTO)
    fun editUser(id: UUID, userDto: UserDTO)
    fun deleteUser(uId: UUID)
}
