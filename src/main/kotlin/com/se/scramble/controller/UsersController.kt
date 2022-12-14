package com.se.scramble.controller

import com.se.scramble.domain.RestAPIMessages
import com.se.scramble.domain.dto.users.UsersLoginRequestDto
import com.se.scramble.domain.dto.users.UsersSaveRequestDto
import com.se.scramble.service.UsersService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.nio.charset.Charset

@RestController
class UsersController(
    private final val usersService: UsersService
) : BaseController() {
    @PostMapping("api/users/save")
    fun save(@RequestBody usersSaveRequestDto: UsersSaveRequestDto): ResponseEntity<RestAPIMessages> =
        sendResponseHttpByJson("User is saved well", usersService.save(usersSaveRequestDto))

    @GetMapping("api/users/findById/{users_id}")
    fun findById(@PathVariable users_id: String): ResponseEntity<RestAPIMessages> =
        sendResponseHttpByJson("Get user's information with id : $users_id", usersService.findById(users_id))

    @GetMapping("api/users/idCanUsable/{users_id}")
    fun idCanUsable(@PathVariable users_id: String): ResponseEntity<RestAPIMessages> =
        sendResponseHttpByJson("Check if $users_id can usable for id", usersService.idCanUsable(users_id))

    @PostMapping("api/users/login")
    fun login(@RequestBody usersLoginRequestDto: UsersLoginRequestDto): ResponseEntity<RestAPIMessages> =
        sendResponseHttpByJson("Login success", usersService.login(usersLoginRequestDto))

    @GetMapping("api/users/getProjectsList/{users_id}")
    fun getProjectsList(@PathVariable users_id: String): ResponseEntity<RestAPIMessages> =
        sendResponseHttpByJson("Get projectsList in users $users_id", usersService.getProjectsList(users_id))
}