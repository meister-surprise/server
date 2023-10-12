package esperer.hackerton.domain.project.vo

import esperer.hackerton.domain.project.Scope

data class UpdateProjectRequest(
    val username: String,
    val title: String,
    val code: String,
    val color: String,
    val scope: Scope
)
