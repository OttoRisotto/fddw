package org.lecture_faq_mittmann_fddw.Repository

import org.lecture_faq_mittmann_fddw.Models.Role
import org.lecture_faq_mittmann_fddw.Models.myUser
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepo: CrudRepository<myUser, UUID> {

    fun getUserById(id: UUID): myUser

    @Query(
        """ SELECT u FROM myUser u 
                WHERE (:firstName IS NULL OR :firstName = u.firstName) 
                AND (:lastName IS NULL OR :lastName = u.lastName)
                AND (:role IS NULL OR :role = u.role)"""
    )
    fun getUsers(firstName: String?, lastName: String?, role: Role?): List<myUser>

    fun deleteUserById(id: UUID)
}
