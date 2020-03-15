package com.trinhlbk.githubpublicrepo.frameworks.network.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    val id: Long,
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String?
)