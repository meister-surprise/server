package esperer.hackerton.domain.gpt.controller

import esperer.hackerton.domain.gpt.service.GPTService
import esperer.hackerton.domain.gpt.vo.ChatRequest
import esperer.hackerton.domain.gpt.vo.ChatResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/gpt")
class GPTController(
    private val gptService: GPTService
) {

    @PostMapping("/chat")
    fun chat(@RequestBody request: ChatRequest): ResponseEntity<ChatResponse> {
        val result = gptService.chat(request)
        return ResponseEntity.ok(result)
    }
}