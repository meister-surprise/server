package esperer.hackerton.domain

import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController(
    private val env: Environment
) {

    @GetMapping("/spring/health")
    fun healthCheck() = "OK Spring Server Port=${env.getProperty("server.port")}"
}