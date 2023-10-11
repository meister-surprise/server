package esperer.hackerton.domain.user.service

import esperer.hackerton.domain.user.User
import esperer.hackerton.domain.user.repository.UserRepository
import esperer.hackerton.domain.user.vo.CreateUserRequest
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun saveUser(request: CreateUserRequest) {
        userRepository.save(User(name = request.name))
    }
}