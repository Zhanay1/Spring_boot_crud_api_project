package com.crudproject.Crud.Api.Project.service

import com.crudproject.Crud.Api.Project.model.User

interface UserService {
    fun addUser(user: User): User
    fun getAllUsers(): List<User>
    fun getUser(id: Long): User
    fun deleteUser(id: Long)
    fun updateUser(user: User): User
    fun findPaginated(pageNo: Int, pageSize: Int): List<User>
}