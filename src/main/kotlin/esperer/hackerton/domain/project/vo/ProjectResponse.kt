package esperer.hackerton.domain.project.vo

data class ProjectResponse(
    val id: Long,
    val title: String,
    val color: String,
    val username: String
)


data class AllProjectResponse(
    val projects: List<ProjectResponse>
)