package esperer.hackerton.domain

import javax.persistence.*

@Entity
class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long,

    @Column(name = "project_name", columnDefinition = "VARCHAR(30)" ,nullable = false)
    val projectName: String,

    @Lob
    val projectCode: String // view로 렌더링될 코드
)