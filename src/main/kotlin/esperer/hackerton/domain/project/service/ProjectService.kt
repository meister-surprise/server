package esperer.hackerton.domain.project.service

import esperer.hackerton.domain.project.Project
import esperer.hackerton.domain.project.repository.ProjectRepository
import esperer.hackerton.domain.project.vo.CreateProjectRequest
import esperer.hackerton.domain.user.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
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
            user = user
        )

        projectRepository.save(project)
        log.info("project 생성 성공 - project info = {} ", project.toString())
    }

}