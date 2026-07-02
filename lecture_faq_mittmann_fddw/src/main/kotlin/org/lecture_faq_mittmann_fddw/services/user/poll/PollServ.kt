package org.lecture_faq_mittmann_fddw.services.user.poll

import org.lecture_faq_mittmann_fddw.Models.DTOs.UserDto
import org.lecture_faq_mittmann_fddw.Models.Poll
import java.util.UUID

interface PollServ {

    fun getPoll(uId:UserDto) : Poll
    fun getPollsByUser(uId: UUID): List<Poll>

    fun addPoll(uId: UUID, title: String, description: String)
    fun updatePoll(uId: UUID, pId: UUID, title:String?, description: String?)

    fun deletePollById(uId: UUID, pId: UUID)

}