package com.trinhlbk.githubpublicrepo.frameworks.network

import com.trinhlbk.githubpublicrepo.frameworks.network.response.RepoResponse
import retrofit2.Call
import retrofit2.http.GET

interface GithubApi {

    @GET("repositories")
    fun getRepos(): Call<List<RepoResponse>>

}