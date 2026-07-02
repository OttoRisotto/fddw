package org.lecture_faq_mittmann_fddw.services.user

import org.lecture_faq_mittmann_fddw.Models.DTOs.UserDto
import org.lecture_faq_mittmann_fddw.Models.Role
import org.lecture_faq_mittmann_fddw.Models.User
import java.util.UUID

interface UserService {
    fun getUser(id: UUID): User
    fun getUsers( firstName: String?, lastName: String?, role: Role? ): List<User>
    fun addUser(userDto: UserDto)
    fun editUser(id: UUID, userDto: UserDto)
    fun deleteUser(id: UUID)
}
