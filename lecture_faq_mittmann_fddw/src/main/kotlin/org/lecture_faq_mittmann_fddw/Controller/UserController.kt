package org.lecture_faq_mittmann_fddw.Controller

import org.lecture_faq_mittmann_fddw.Models.myUser
import org.lecture_faq_mittmann_fddw.Services.UserService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

@Controller
class UserController(private val service: UserService) {

    @GetMapping("/users/{id}")
    @ResponseBody
    fun getUser(@PathVariable id: UUID): String{
        val user = service.getUser(id)
        return user.toString()
    }

    @GetMapping("/users")
    @ResponseBody
    fun getUsers(
        @RequestParam firstName: String?,
        @RequestParam lastName: String?
    ): String{
        val users: List<myUser> = service.getUsers(firstName, lastName)
        return "Users: \n${users.joinToString(",\n")}"
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(
        @RequestParam firstName: String,
        @RequestParam lastName: String,
        @RequestParam email: String){
        service.addUser(firstName, lastName, email)
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun editUser(
        @PathVariable id: UUID,
        firstName: String?,
        lastName: String?,
        email: String?
    ){
        service.editUser(id, firstName, lastName, email)
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: UUID){
        service.deleteUser(id)
    }
}
