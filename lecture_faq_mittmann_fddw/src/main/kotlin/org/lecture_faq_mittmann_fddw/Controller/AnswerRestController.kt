package org.lecture_faq_mittmann_fddw.Controller

import org.lecture_faq_mittmann_fddw.Models.Answer
import org.lecture_faq_mittmann_fddw.services.user.poll.answer.AnswerServ
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RequestMapping("/api/users/{uId}/polls/{pId}/answers")
@RestController
class AnswerRestController( private val srv:AnswerServ ) {

    @GetMapping("/")
    fun getPollAnswers(
        @PathVariable uId:UUID,
        @PathVariable pId:UUID,
    ): List<Answer> {
        return srv.getPollAnswers(uId, pId)
    }

    @GetMapping("/{aId}")
    fun getAnswerById( uId:UUID, pId:UUID, aId:UUID ):Answer {
        return srv.getAnswerById( uId, pId, aId )
    }

    @PostMapping("/")
    fun addNewAnswer(uId:UUID, pId:UUID, @RequestParam text:String ){
        srv.addNewAnswer( uId, pId, text )
    }

    @PatchMapping("/{aId}")
    fun updateAnswer(uId:UUID, pId:UUID, aId:UUID, text:String?, count:Short?){
        srv.updateAnswer( text, count, uId, pId, aId )
    }

    @DeleteMapping("/{aId}")
    fun deleteAnswer( uId:UUID, pId:UUID, aId:UUID ){
        srv.deleteAnswer( uId, pId, aId )
    }

}