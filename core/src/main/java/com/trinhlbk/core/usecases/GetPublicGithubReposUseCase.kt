package com.trinhlbk.core.usecases

import com.trinhlbk.core.data.RepoRepository
import com.trinhlbk.core.entities.Repo
import io.reactivex.Single

interface GetPublicGithubReposUseCase {
    fun execute(): Single<List<Repo>>
}

class GetPublicGithubReposUseCaseImpl(
    private val repoRepository: RepoRepository
) : GetPublicGithubReposUseCase {
    override fun execute(): Single<List<Repo>> {
        return repoRepository.getAll()
    }
}