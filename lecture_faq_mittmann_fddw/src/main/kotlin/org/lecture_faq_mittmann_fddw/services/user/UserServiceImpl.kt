package org.lecture_faq_mittmann_fddw.services.user

import org.lecture_faq_mittmann_fddw.Models.DTOs.UserDto
import org.lecture_faq_mittmann_fddw.Models.Role
import org.lecture_faq_mittmann_fddw.Models.User
import org.lecture_faq_mittmann_fddw.Repository.UserRepo
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class UserServiceImpl(private val repo: UserRepo): UserService {

    override fun getUser(id: UUID): User {
        return repo.getUserById(id)?:throw ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "User nicht gefunden"
        )
    }

    override fun getUsers(
        firstName: String?,
        lastName: String?,
        role: Role?
    ): List<User> {
        return repo.getUsers(firstName, lastName, role)
    }

    override fun addUser(userDto: UserDto) {
        val user = User()
        val exception = ResponseStatusException(HttpStatus.BAD_REQUEST, "User konnte nicht erstellt werden, es sind nicht alle Eigenschaften vorhanden")
        user.firstName = userDto.firstName?: throw exception
        user.lastName = userDto.lastName?: throw exception
        user.email = userDto.email?: throw exception
        user.role = userDto.role?: throw exception

        repo.save( user )
    }

    override fun editUser(id: UUID, userDto: UserDto) {

        val user = getUser(id)

        userDto.firstName?.let { user.firstName = it }
        userDto.lastName?.let { user.lastName = it }
        userDto.email?.let { user.email = it }
        userDto.role?.let { user.role = it }

        repo.save(user)
    }

    override fun deleteUser(@PathVariable id: UUID) {
        repo.delete(getUser(id))
    }
}
