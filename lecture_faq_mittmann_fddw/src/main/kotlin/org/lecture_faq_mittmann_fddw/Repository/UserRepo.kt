package org.lecture_faq_mittmann_fddw.Repository

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
                WHERE (:firstName IS NULL or :firstName = u.firstName) 
                AND (:lastName IS NULL or :lastName = u.lastName)"""
    )
    fun getUsers(firstName: String?, lastName: String?): List<myUser>

    fun deleteUserById(id: UUID)
}
