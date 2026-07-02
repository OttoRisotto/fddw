package org.lecture_faq_mittmann_fddw.services.lecture

import org.lecture_faq_mittmann_fddw.Models.lecture.CreateLectureDTO
import org.lecture_faq_mittmann_fddw.Models.lecture.Lecture
import org.lecture_faq_mittmann_fddw.Models.lecture.UpdateLectureDTO
import java.util.UUID

interface LectureService {

    fun getLecture( uId: UUID, lId: UUID ): Lecture
    fun getLecturesByUser( uId: UUID ): List<Lecture>

    fun addLecture( uId:UUID, dto:CreateLectureDTO )
    fun updateLecture (uId:UUID, lId:UUID, dto:UpdateLectureDTO)

    fun deleteLecture(uId:UUID, lId:UUID)

}