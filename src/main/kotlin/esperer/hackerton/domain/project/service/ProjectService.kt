package esperer.hackerton.domain.project.service

import esperer.hackerton.domain.project.Project
import esperer.hackerton.domain.project.repository.ProjectRepository
import esperer.hackerton.domain.project.vo.*
import esperer.hackerton.domain.user.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
@Transactional
class ProjectService(
    private val projectRepository: ProjectRepository,
    private val userRepository: UserRepository
) {
    private val log = LoggerFactory.getLogger("project service")

    fun createProject(request: CreateProjectRequest) {

        log.info("project 생성 시도 username = {}", request.username)

        val user = userRepository.findByName(request.username)
            ?: throw RuntimeException("user not found exception in Create Project Service")

        val project = Project(
            title = request.title,
            color = request.color,
            code = request.code,
            scope = request.scope,
            user = user
        )

        projectRepository.save(project)
        log.info("project 생성 성공 - project info = {} ", project.toString())
    }

    fun queryAllProjects(request: ScopeRequest): List<ProjectResponse> {
        log.info("Run :: project 전체 조회")

        val projects = projectRepository.findAllByScope(request.scope)

        return projects.map {
            ProjectResponse(
                id = it.id,
                title = it.title,
                color = it.color,
                username = it.user.name
            )
        }
    }

    fun queryProjectDetail(id: Long): ProjectDetailResponse {
        log.info("project 상세 조회 시도, project ID = {}", id)

        val project = projectRepository.findByIdOrNull(id)
            ?: throw RuntimeException("project not found exception")

        log.info("project find 성공 info = {}", project)

        return ProjectDetailResponse(
            id = project.id,
            title = project.title,
            color = project.color,
            code = project.code,
            username = project.user.name,
            scope = project.scope
        )
    }

    fun updateProject(id: Long, request: UpdateProjectRequest) {
        val project = projectRepository.findByIdOrNull(id)
            ?: throw RuntimeException("Not found project")

        val user = userRepository.findByName(request.username)
            ?: throw RuntimeException("Not Found User")

        projectRepository.save(
            Project(
                id = project.id,
                title = request.title,
                color = request.color,
                code = request.code,
                scope = request.scope,
                user = user
            )
        )
    }

    fun deleteProject(id: Long) {
        projectRepository.deleteById(id)
    }

}