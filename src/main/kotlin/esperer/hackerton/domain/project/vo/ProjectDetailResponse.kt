package esperer.hackerton.domain.project.vo

import esperer.hackerton.domain.project.Scope

data class ProjectDetailResponse(
    val id: Long,
    val title: String,
    val color: String,
    val code: String,
    val username: String,
    val scope: Scope
)
