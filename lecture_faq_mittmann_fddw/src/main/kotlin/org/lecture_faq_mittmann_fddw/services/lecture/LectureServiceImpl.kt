package org.lecture_faq_mittmann_fddw.services.lecture

import org.lecture_faq_mittmann_fddw.Models.lecture.question.Question
import org.lecture_faq_mittmann_fddw.Models.lecture.CreateLectureDTO
import org.lecture_faq_mittmann_fddw.Models.lecture.Lecture
import org.lecture_faq_mittmann_fddw.Models.lecture.UpdateLectureDTO
import org.lecture_faq_mittmann_fddw.Repository.LectureRepo
import org.lecture_faq_mittmann_fddw.services.lecture.question.QuestionServ
import org.lecture_faq_mittmann_fddw.services.user.UserService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class LectureServiceImpl(
    private val repo:LectureRepo,
    val uServ:UserService,
    val qServ:QuestionServ
): LectureService {

    override fun getLecture(uId:UUID, lId:UUID) :Lecture {
        val lecture = repo.getLecture(uId, lId) ?: run {
            // Fehlerbehandlung
            uServ.getUser(uId) //wirft Http-Exception, wenn user mit id nicht existiert
            repo.getLectureById(lId) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Lecture mit $lId wurde nicht gefunden")
            throw ResponseStatusException(HttpStatus.NOT_FOUND) // Lecture lId gehört nicht zu User
        }
        return lecture
    }

    override fun getLecturesByUser( uId:UUID ) :List<Lecture> {
       return repo.getLecturesByUser( uId )
    }

    override fun addLecture(uId:UUID, dto:CreateLectureDTO ) {

        val lecture = Lecture()

        lecture.user        = uServ.getUser(uId)
        lecture.title       = dto.title
        lecture.description = dto.description
        lecture.type        = dto.type
        lecture.link        = dto.link
        lecture.code        = dto.code

    }

    override fun updateLecture(uId:UUID, lId: UUID, dto:UpdateLectureDTO) {
        val lecture = this.getLecture(uId, lId)

        if (dto.title       != null){ lecture.title       = dto.title       }
        if (dto.description != null){ lecture.description = dto.description }
        if (dto.type        != null){ lecture.type        = dto.type        }
        if (dto.link        != null){ lecture.link        = dto.link        }
        if (dto.code        != null){ lecture.code        = dto.code        }

        repo.save(lecture)
    }

    override fun deleteLecture(uId:UUID, lId:UUID) {
        val lecture = this.getLecture(uId, lId) // Fehlerhandling in Funktion
        val questions = qServ.getQuestionsByLecture(uId, lId)

        for (question in questions){
            qServ.deleteQuestion(uId, lId, question.id)
        }

        repo.delete(lecture)
    }

}
