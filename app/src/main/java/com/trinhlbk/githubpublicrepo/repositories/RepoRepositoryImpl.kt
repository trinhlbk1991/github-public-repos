package com.trinhlbk.githubpublicrepo.repositories

import com.trinhlbk.core.data.RepoRepository
import com.trinhlbk.core.entities.Repo
import com.trinhlbk.githubpublicrepo.frameworks.network.GithubApi
import com.trinhlbk.githubpublicrepo.frameworks.network.response.RepoResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoRepositoryImpl(
    private val githubApi: GithubApi
) : RepoRepository {

    override fun getAll(): Single<List<Repo>> {
        return Single.create { emitter ->
            githubApi.getRepos().enqueue(object : Callback<List<RepoResponse>> {
                override fun onFailure(call: Call<List<RepoResponse>>, t: Throwable) {
                    emitter.onError(t)
                }

                override fun onResponse(
                    call: Call<List<RepoResponse>>,
                    response: Response<List<RepoResponse>>
                ) {
                    if (response.isSuccessful) {
                        emitter.onSuccess(response.body()?.map { it.toEntity() } ?: emptyList())
                    } else {
                        emitter.onError(Exception(response.message()))
                    }
                }

            })
        }
    }

}

private fun RepoResponse.toEntity(): Repo {
    return Repo(
        name = this.name,
        description = this.description ?: "",
        author = this.owner.login,
        language = this.language ?: ""
    )
}