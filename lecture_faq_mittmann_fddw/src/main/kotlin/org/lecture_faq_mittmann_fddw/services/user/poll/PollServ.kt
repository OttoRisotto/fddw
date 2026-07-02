package org.lecture_faq_mittmann_fddw.services.user.poll

import org.lecture_faq_mittmann_fddw.Models.user.poll.createPollDTO
import org.lecture_faq_mittmann_fddw.Models.user.poll.updatePollDTO
import org.lecture_faq_mittmann_fddw.Models.user.poll.Poll
import java.util.UUID

interface PollServ {

    fun getPoll(uId: UUID, pId: UUID) : Poll
    fun getPollsByUser(uId: UUID): List<Poll>

    fun addPoll(uId: UUID, createPollDTO: createPollDTO )
    fun updatePoll(uId: UUID, pId: UUID, updatePollDTO: updatePollDTO)

    fun deletePollById( uId: UUID, pId: UUID )

}
