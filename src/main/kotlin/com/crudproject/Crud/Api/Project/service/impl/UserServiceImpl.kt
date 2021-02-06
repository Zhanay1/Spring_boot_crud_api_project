package com.crudproject.Crud.Api.Project.service.impl

import com.crudproject.Crud.Api.Project.model.User
import com.crudproject.Crud.Api.Project.repository.UserRepository
import com.crudproject.Crud.Api.Project.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable
import java.util.*

@Service
class UserServiceImpl: UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun addUser(user: User): User {
        return userRepository.save(user)
    }

    override fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    override fun getUser(id: Long): User {
        return userRepository.getOne(id)
    }

    override fun deleteUser(id: Long) {
        return userRepository.deleteById(id)
    }

    override fun updateUser(user: User): User {
        var existingUser: User = userRepository.getOne(user.id)
        existingUser.fullName = user.fullName
        existingUser.email = user.email
        existingUser.date = user.date
        return userRepository.save(existingUser)
    }

    override fun findPaginated(pageNo: Int, pageSize: Int): List<User> {
        var page: Pageable = PageRequest.of(pageNo, pageSize)
        var pagedResult: Page<User> = userRepository.findAll(page)
        return pagedResult.toList()
    }
}