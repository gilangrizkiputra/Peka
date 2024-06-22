package com.sukasrana.peka.model

data class UserResponse(
    val success: Boolean,
    val data: List<User>
)