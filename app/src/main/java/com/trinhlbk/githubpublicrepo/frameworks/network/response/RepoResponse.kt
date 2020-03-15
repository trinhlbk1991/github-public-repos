package com.trinhlbk.githubpublicrepo.frameworks.network.response

data class RepoResponse(
    val id: Long,
    val name: String,
    val description: String?,
    val language: String?,
    val owner: UserResponse
)