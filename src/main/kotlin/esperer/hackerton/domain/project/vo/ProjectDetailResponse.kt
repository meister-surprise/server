package esperer.hackerton.domain.project.vo

data class ProjectDetailResponse(
    val id: Long,
    val title: String,
    val color: String,
    val code: String,
    val username: String
)
