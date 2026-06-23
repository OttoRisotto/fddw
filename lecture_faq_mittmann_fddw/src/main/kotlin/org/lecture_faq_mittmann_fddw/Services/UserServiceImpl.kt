package org.lecture_faq_mittmann_fddw.Services

import org.lecture_faq_mittmann_fddw.Models.Role
import org.lecture_faq_mittmann_fddw.Models.MyUser
import org.lecture_faq_mittmann_fddw.Repository.UserRepo
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID

@Service
class UserServiceImpl(private val repo: UserRepo): UserService {

    override fun getUser(id: UUID): MyUser{
        return repo.getUserById(id)
    }

    override fun getUsers(
        firstName: String?,
        lastName: String?,
        role: Role?
    ): List<MyUser> {
        return repo.getUsers(firstName, lastName, role)
    }

    override fun addUser(firstName: String, lastName: String, email: String, role: Role) {
        val user = MyUser()
        user.firstName = firstName
        user.lastName = lastName
        user.email = email
        user.role = role

        repo.save( user )
    }

    override fun editUser(id: UUID, firstName: String?, lastName: String?, email: String?, role: Role?) {

        var user = repo.getUserById(id)

        if (firstName != null)  { user.firstName = firstName }
        if (lastName != null)   { user.lastName = lastName }
        if (email != null)      { user.email = email }
        if (role != null)       { user.role = role }

        repo.save(user)
    }

    override fun deleteUser(@PathVariable id: UUID) {
        repo.deleteMyUserById(id)
    }
}