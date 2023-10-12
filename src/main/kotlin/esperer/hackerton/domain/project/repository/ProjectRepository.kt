package esperer.hackerton.domain.project.repository

import esperer.hackerton.domain.project.Project
import esperer.hackerton.domain.project.Scope
import org.springframework.data.repository.CrudRepository

interface ProjectRepository : CrudRepository<Project, Long> {
    fun findAllByScope(scope: Scope): List<Project>
}