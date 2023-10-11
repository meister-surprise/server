package esperer.hackerton.domain.project.controller

import esperer.hackerton.domain.project.service.ProjectService
import esperer.hackerton.domain.project.vo.CreateProjectRequest
import esperer.hackerton.domain.project.vo.ProjectDetailResponse
import esperer.hackerton.domain.project.vo.ProjectResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProjectController(
    private val projectService: ProjectService
) {

    private val log = LoggerFactory.getLogger("Project Controller")

    @PostMapping
    fun createProject(@RequestBody request: CreateProjectRequest): ResponseEntity<Void> {
        projectService.createProject(request)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @GetMapping
    fun queryAllProjects(): ResponseEntity<List<ProjectResponse>> {
        val result = projectService.queryAllProjects()
        return ResponseEntity.ok(result)
    }

    @GetMapping("/{id}")
    fun queryProjectDetail(@PathVariable id: Long): ResponseEntity<ProjectDetailResponse>{
        val result = projectService.queryProjectDetail(id)
        return ResponseEntity.ok(result)
    }

}