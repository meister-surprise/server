package esperer.hackerton.domain.project.repository

import esperer.hackerton.domain.project.Project
import org.springframework.data.repository.CrudRepository

interface ProjectRepository : CrudRepository<Project, Long> {
}