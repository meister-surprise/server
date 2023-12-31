package esperer.hackerton.domain.project

import esperer.hackerton.domain.user.User
import javax.persistence.*

@Entity
class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,

    @Column(name = "project_name", columnDefinition = "VARCHAR(30)", nullable = false)
    val title: String,

    @Lob
    val code: String, // view로 렌더링될 코드

    @Column(name = "color", columnDefinition = "VARCHAR(10)", nullable = false)
    val color: String, // 헥스코드로 색깔을 저장합니다.

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(10) default 'PUBLIC'")
    val scope: Scope,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User
) {
    override fun toString(): String {
        return "Project(id=$id, title='$title', code='$code', color='$color', user=$user)"
    }
}

enum class Scope {
    PUBLIC, PRIVATE
}