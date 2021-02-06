package com.crudproject.Crud.Api.Project.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "users")
@ApiModel(description = "All details about the user")
class User(
        @ApiModelProperty(notes = "User id")
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Long,

        @ApiModelProperty(notes = "User full name")
        @Column(name = "fullName")
        var fullName: String,

        @ApiModelProperty(notes = "User email")
        @Column(name = "email")
        var email: String,
        @ApiModelProperty(notes = "Date of user registration")
        @Column(name = "date_registration")
        var date: Date) {

}