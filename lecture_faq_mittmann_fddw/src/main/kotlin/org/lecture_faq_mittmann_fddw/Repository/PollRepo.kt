package org.lecture_faq_mittmann_fddw.Repository

import org.lecture_faq_mittmann_fddw.Models.user.poll.Poll
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PollRepo: CrudRepository<Poll, UUID> {

    @Query("SELECT p FROM Poll p WHERE p.id = :pId")
    fun getPollById(pId: UUID): Poll?

    @Query("""
            SELECT p FROM Poll p WHERE
            p.id = :pId AND
            p.user.id = :uId
            """)
    fun getPoll(uId: UUID, pId: UUID): Poll?

    fun getPollsByUserId(uId:UUID): List<Poll>

}
