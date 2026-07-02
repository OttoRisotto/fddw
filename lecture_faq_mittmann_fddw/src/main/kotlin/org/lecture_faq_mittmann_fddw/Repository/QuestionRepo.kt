package org.lecture_faq_mittmann_fddw.Repository

import org.lecture_faq_mittmann_fddw.Models.lecture.question.Question
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface QuestionRepo: CrudRepository<Question, UUID> {

    @Query("SELECT q FROM Question q WHERE q.id = :qId")
    fun getQuestionById( qId:UUID ): Question?

    @Query("""
        SELECT q FROM Question q WHERE
        q.id = :qId AND
        q.lecture.id = :lId AND
        q.lecture.user = :uId
    """)
    fun getQuestion( uId:UUID, lId:UUID, qId:UUID ): Question?

    @Query("""
    SELECT qs FROM Question qs WHERE
    qs.lecture.id = :lId AND
    qs.lecture.user.id = :uId
    """)
    fun getQuestionsByLecture( uId:UUID, lId:UUID ): List<Question>

}