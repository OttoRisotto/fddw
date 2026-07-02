package org.lecture_faq_mittmann_fddw.Repository

import org.lecture_faq_mittmann_fddw.Models.Role
import org.lecture_faq_mittmann_fddw.Models.user.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepo: CrudRepository<User, UUID> {

    fun getUserById(id: UUID): User?

    @Query(
        """ SELECT u FROM User u 
                WHERE (:firstName IS NULL OR :firstName = u.firstName) 
                AND (:lastName IS NULL OR :lastName = u.lastName)
                AND (:role IS NULL OR :role = u.role)"""
    )
    fun getUsers(firstName: String?, lastName: String?, role: Role?): List<User>

}
