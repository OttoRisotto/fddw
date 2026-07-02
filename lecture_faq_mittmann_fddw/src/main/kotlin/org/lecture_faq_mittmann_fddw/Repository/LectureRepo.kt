package org.lecture_faq_mittmann_fddw.Repository

import org.lecture_faq_mittmann_fddw.Models.lecture.Lecture
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface LectureRepo: CrudRepository<Lecture, UUID> {

    @Query("SELECT l FROM Lecture l WHERE l.id = :lId")
    fun getLectureById(lId: UUID): Lecture?

    @Query("SELECT l FROM Lecture l WHERE l.id = :lId AND l.user.id = :uId")
    fun getLecture(uId: UUID, lId: UUID): Lecture?

    @Query("SELECT ls from Lecture ls WHERE ls.user.id = :uId")
    fun getLecturesByUser( uId: UUID ): List<Lecture>

}