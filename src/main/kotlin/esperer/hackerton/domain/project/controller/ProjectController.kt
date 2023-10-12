package esperer.hackerton.domain.project.controller

import esperer.hackerton.domain.project.service.ProjectService
import esperer.hackerton.domain.project.vo.*
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/project")
class ProjectController(
    private val projectService: ProjectService
) {

    @PostMapping
    fun createProject(@RequestBody request: CreateProjectRequest): ResponseEntity<Void> {
        projectService.createProject(request)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @GetMapping
    fun queryAllProjects(request: ScopeRequest): ResponseEntity<AllProjectResponse> {
        val result = projectService.queryAllProjects(request)
        return ResponseEntity.ok(AllProjectResponse(result))
    }

    @GetMapping("/{id}")
    fun queryProjectDetail(@PathVariable id: Long): ResponseEntity<ProjectDetailResponse> {
        val result = projectService.queryProjectDetail(id)
        return ResponseEntity.ok(result)
    }

    @PatchMapping("/{id}")
    fun updateProject(@PathVariable id: Long, @RequestBody request: UpdateProjectRequest): ResponseEntity<Void> {
        projectService.updateProject(id, request)
        return ResponseEntity.noContent().build()
    }

}