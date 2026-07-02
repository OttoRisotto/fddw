package org.lecture_faq_mittmann_fddw.Controller

import org.lecture_faq_mittmann_fddw.Models.Role
import org.lecture_faq_mittmann_fddw.Models.User
import org.lecture_faq_mittmann_fddw.services.user.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api")
class UserRestController(private val srv: UserService) {

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: UUID): User{
        return srv.getUser(id)
    }

    @GetMapping("/users")
    fun getUsers(
        @RequestParam firstName: String?,
        @RequestParam lastName: String?,
        @RequestParam role: Role?
    ): List<User>{
        return srv.getUsers(firstName, lastName, role)
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(
        @RequestParam firstName: String,
        @RequestParam lastName: String,
        @RequestParam email: String,
        @RequestParam role: Role){
        srv.addUser(firstName, lastName, email, role)
    }

    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun editUser(
        @PathVariable id: UUID,
        firstName: String?,
        lastName: String?,
        email: String?,
        role: Role?
    ){
        srv.editUser(id, firstName, lastName, email, role)
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: UUID){
        srv.deleteUser(id)
    }
}
