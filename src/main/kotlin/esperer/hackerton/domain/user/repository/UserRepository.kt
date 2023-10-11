package esperer.hackerton.domain.user.repository

import esperer.hackerton.domain.user.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByName(name: String): User?
}