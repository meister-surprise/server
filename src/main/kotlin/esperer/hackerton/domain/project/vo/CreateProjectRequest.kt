package esperer.hackerton.domain.project.vo

data class CreateProjectRequest(
    val title: String,
    val color: String,
    val code: String,
    val username: String
)
