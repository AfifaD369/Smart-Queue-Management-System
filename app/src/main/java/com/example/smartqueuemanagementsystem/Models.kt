package com.example.smartqueuemanagementsystem

data class Department(
    val id: Int,
    val name: String,
    val icon: String,
    val currentToken: Int,
    val waitingPeople: Int,
    val userToken: Int
)