package org.lecture_faq_mittmann_fddw.Controller

import jakarta.validation.Valid
import org.lecture_faq_mittmann_fddw.Models.user.UserDTO
import org.lecture_faq_mittmann_fddw.Models.Role
import org.lecture_faq_mittmann_fddw.Models.user.User
import org.lecture_faq_mittmann_fddw.services.user.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
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
    fun getUsers( firstName:String?, lastName:String?, role:Role? ): List<User>{
        return srv.getUsers( firstName, lastName, role )
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser( userDTO: UserDTO ){
        srv.addUser(userDTO)
    }

    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun editUser(
        @PathVariable id: UUID,
        @Valid @RequestBody userDTO: UserDTO
    ){
        srv.editUser(id, userDTO)
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: UUID){
        srv.deleteUser(id)
    }
}
