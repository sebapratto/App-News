package com.sebapp.naranjaxchallenge.domain.model

import java.util.*

data class NewsSuper(
    val id: UUID = UUID.randomUUID(),
    val bio: String,
    val createdby: String,
    val firstappearance: String,
    val imageurl: String,
    val name: String,
    val publisher: String,
    val realname: String,
    val team: String
)
