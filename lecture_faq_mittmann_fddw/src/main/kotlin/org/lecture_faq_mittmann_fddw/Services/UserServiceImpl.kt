package org.lecture_faq_mittmann_fddw.Services

import org.lecture_faq_mittmann_fddw.Models.myUser
import org.lecture_faq_mittmann_fddw.Repository.UserRepo
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID

@Service
class UserServiceImpl(private val repo: UserRepo): UserService {

    override fun getUser(id: UUID): myUser{
        return repo.getUserById(id)
    }

    override fun getUsers(
        firstName: String?,
        lastName: String?
    ): List<myUser> {
        return repo.getUsers(firstName, lastName)
    }

    override fun addUser(firstName: String, lastName: String, email: String) {
        var user = myUser()
        user.firstName = firstName
        user.lastName = lastName
        user.email = email
        repo.save( user )
    }

    override fun editUser(id: UUID, firstName: String?, lastName: String?, email: String?) {

        var user = repo.getUserById(id)

        if (firstName != null)  { user.firstName = firstName }
        if (lastName != null)   { user.lastName = lastName }
        if (email != null)      { user.email = email }

        repo.save(user)
    }

    override fun deleteUser(@PathVariable id: UUID) {
        repo.deleteUserById(id)
    }
}
