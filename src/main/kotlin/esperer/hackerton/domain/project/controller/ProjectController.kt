package esperer.hackerton.domain.project.controller

import esperer.hackerton.domain.project.service.ProjectService
import esperer.hackerton.domain.project.vo.CreateProjectRequest
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException

@RestController
class ProjectController(
    private val projectService: ProjectService
) {

    private val log = LoggerFactory.getLogger("Project Controller")

    @PostMapping
    fun createProject(@RequestBody request: CreateProjectRequest): ResponseEntity<Void> {
        try {
            projectService.createProject(request)
        } catch(e: RuntimeException) {
            log.error("RuntimeException 발생 usernotfound일 가능성이 높음")
        }
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}