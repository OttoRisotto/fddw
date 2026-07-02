package org.lecture_faq_mittmann_fddw.services.user.poll

import org.lecture_faq_mittmann_fddw.Models.DTOs.UserDto
import org.lecture_faq_mittmann_fddw.Models.Poll
import org.lecture_faq_mittmann_fddw.Repository.PollRepo
import org.lecture_faq_mittmann_fddw.services.user.UserService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class PollServImpl(val repo: PollRepo, val uServ: UserService): PollServ {

    override fun getPoll(uId:UserDto, pId:UUID): Poll {
        return repo.getPoll( uId, pId ) ?: run {
                // Fehlerbehandlung
                uServ.getUser(uId) // wirft Http-Exception, wenn user nicht existiert
                repo.getPollById(uId) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Poll ${pId} existiert nicht")
                throw ResponseStatusException(HttpStatus.NOT_FOUND) //Poll pId gehört nicht zu User uId
            }
    }

    override fun getPollsByUser(uId: UUID):List<Poll> {
        val polls = repo.getPollsByUserId(uId)
        if (polls.isEmpty()){
            /* es existieren 2 Fälle, wenn Liste polls leer
            *   1. es existieren für User keine Polls
            *   2. User existiert nicht -> uServ.getUser(uId)*/
            /* uServ
                -> throw RequestException 404 "User existiert nicht",
                   falls userRepo.getUserById() null zurück gibt */
            uServ.getUser(uId)
        }
        return polls
    }

    override fun addPoll(uId: UUID, title: String, description: String) {
        val poll = Poll()
        val user = uServ.getUser(uId)
        poll.title = title
        poll.user = user
        poll.description = description
        repo.save(poll)
    }

    override fun updatePoll(
        uId: UUID,
        pId: UUID,
        title: String?,
        description: String?
    ) {
       val poll = getPoll(uId, pId)
        if (title != null)      {poll.title = title}
        if (description != null){poll.description = description}
        repo.save(poll)
    }

    override fun deletePollById(uId: UUID, pId: UUID) {
        val poll = getPoll(uId, pId)
        repo.delete(poll)
    }
}
