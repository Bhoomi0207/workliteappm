package com.example.workliteapp



data class ProfileItem(
    val name: String,
    val phoneNumber: String,
    val imageResourceId: Int // Resource ID for local images, or String for URLs
)
