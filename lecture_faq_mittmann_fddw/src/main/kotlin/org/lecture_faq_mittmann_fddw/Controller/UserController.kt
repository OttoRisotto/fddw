package org.lecture_faq_mittmann_fddw.Controller

import org.lecture_faq_mittmann_fddw.Models.Role
import org.lecture_faq_mittmann_fddw.Models.MyUser
import org.lecture_faq_mittmann_fddw.Services.UserService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

@Controller
class UserController(private val srv: UserService) {

    @GetMapping("/users/{id}")
    @ResponseBody
    fun getUser(@PathVariable id: UUID): String{
        val user = srv.getUser(id)
        return user.toString()
    }

    @GetMapping("/users")
    @ResponseBody
    fun getUsers(
        @RequestParam firstName: String?,
        @RequestParam lastName: String?,
        @RequestParam role: Role?
    ): String{
        val users: List<MyUser> = srv.getUsers(firstName, lastName, role)
        return "Users: \n${users.joinToString(",\n")}"
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
