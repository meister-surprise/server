package esperer.hackerton.domain.user

import javax.persistence.*

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,

    @Column(name = "name", nullable = false, unique = true)
    val name: String
) {

    override fun toString(): String {
        return "User(id=$id, name='$name')"
    }
}