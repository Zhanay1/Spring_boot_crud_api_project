package com.crudproject.Crud.Api.Project.controller

import com.crudproject.Crud.Api.Project.model.User
import com.crudproject.Crud.Api.Project.service.UserService
import io.swagger.annotations.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*
import kotlin.reflect.KClass
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/")
@Api(value = "User registration")
class UserController{

    @Autowired
    lateinit var userService: UserService

    @ApiOperation(value = "Add an user")
    @PostMapping("/addUser")
    fun addUser(@ApiParam(value = "User adding in db", required = true) @RequestBody user: User): User {
        return userService.addUser(user)
    }

    @ApiOperation(value = "View a list of registered users", response = KClass::class)
    @ApiResponses(
            ApiResponse(code = 200, message = "..."),
            ApiResponse(code = 404, message = "..."),
            ApiResponse(code = 500, message = "..."),
            ApiResponse(code = 400, message = "..."),
            ApiResponse(code = 412, message = "...")
    )
    @GetMapping("/users")
    fun getAllUsers(): List<User>{
        return userService.getAllUsers()
    }

    @ApiOperation(value = "View a list of registered users with pagination")
    @GetMapping("/users/{pageNo}/{pageSize}")
    fun getPaginated(@PathVariable pageNo: Int, @PathVariable pageSize: Int): List<User>{
        return userService.findPaginated(pageNo, pageSize)
    }

    @ApiOperation(value = "Get a user by id")
    @GetMapping("/user/{id}")
    fun getUser(@ApiParam(value = "User getting by id in db", required = true) @PathVariable id: Long): User{
        return userService.getUser(id)
    }

    @ApiOperation(value = "Update a user")
    @PutMapping("/updateUser")
    fun updateUser(@ApiParam(value = "User getting in db", required = true) @RequestBody user: User): User {
        return userService.updateUser(user)
    }

    @ApiOperation(value = "Delete a user")
    @DeleteMapping("/deleteUser/{id}")
    fun deleteUser(@ApiParam(value = "User deleting by id in db", required = true) @PathVariable id: Long) {
        return userService.deleteUser(id)
    }





}