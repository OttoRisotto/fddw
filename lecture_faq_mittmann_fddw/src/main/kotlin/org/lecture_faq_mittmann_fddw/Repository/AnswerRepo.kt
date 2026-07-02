package org.lecture_faq_mittmann_fddw.Repository

import org.lecture_faq_mittmann_fddw.Models.Answer
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface AnswerRepo: CrudRepository<Answer, UUID> {

    fun getAnswerById(aId:UUID): Answer?

    @Query("""
        SELECT a FROM Answer a WHERE
        a.id = :aId AND
        a.poll.id = :pId AND
        a.poll.user.id = :uId
    """)
    fun getAnswer(uId:UUID, pId:UUID, aId:UUID ): Answer?

    @Query("""
        SELECT a FROM Answer a WHERE
        a.poll.id = :pId AND
        a.poll.user.id = :uId
    """)
    fun getAnswersByPollId( uId:UUID, pId:UUID ): List<Answer>

    fun deleteAnswerById(id:UUID)

}
