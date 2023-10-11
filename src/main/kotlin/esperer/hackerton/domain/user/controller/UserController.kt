package esperer.hackerton.domain.user.controller

import esperer.hackerton.domain.user.service.UserService
import esperer.hackerton.domain.user.vo.CreateUserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {

    fun saveUser(@RequestBody request: CreateUserRequest): ResponseEntity<Void> {
        userService.saveUser(request)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

}