package esperer.hackerton.domain.project

import javax.persistence.*

@Entity
class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long,

    @Column(name = "project_name", columnDefinition = "VARCHAR(30)", nullable = false)
    val projectName: String,

    @Lob
    val projectCode: String, // view로 렌더링될 코드

    @Column(name = "color", columnDefinition = "VARCHAR(10)", nullable = false)
    val color: String // 헥스코드로 색깔을 저장합니다/
)