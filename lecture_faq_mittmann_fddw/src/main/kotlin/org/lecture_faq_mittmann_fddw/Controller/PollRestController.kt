package org.lecture_faq_mittmann_fddw.Controller

import jakarta.validation.Valid
import org.lecture_faq_mittmann_fddw.Models.DTOs.PollDTO
import org.lecture_faq_mittmann_fddw.Models.Poll
import org.lecture_faq_mittmann_fddw.services.user.poll.PollServ
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/users/{uId}/polls")
class PollRestController(private val srv: PollServ) {

    @GetMapping("/{pId}")
    fun getPollById(uId: UUID, pId: UUID): Poll {
        return srv.getPoll( uId, pId )
    }

    @GetMapping("/")
    fun getPollsByUser(@PathVariable uId: UUID): List<Poll>{
        return srv.getPollsByUser(uId)
    }

    @PostMapping("/")
    fun addPoll(
        @PathVariable uId: UUID,
        @Valid @RequestBody pollDTO: PollDTO
    ) {
        srv.addPoll(uId, pollDTO)
    }

    @PatchMapping("/{pId}")
    fun updatePoll(
        @PathVariable uId: UUID,
        @PathVariable pId: UUID,
        @Valid @RequestBody pollDTO: PollDTO
    ){
        srv.updatePoll(uId, pId, pollDTO)
    }

    @DeleteMapping("/{pId}")
    fun deletePollById(@PathVariable uId: UUID, @PathVariable pId: UUID){
        srv.deletePollById(uId, pId)
    }

}