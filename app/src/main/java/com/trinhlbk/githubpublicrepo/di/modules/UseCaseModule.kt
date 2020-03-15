package com.trinhlbk.githubpublicrepo.di.modules

import com.trinhlbk.core.data.RepoRepository
import com.trinhlbk.core.usecases.GetPublicGithubReposUseCase
import com.trinhlbk.core.usecases.GetPublicGithubReposUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory { getPublicGithubRepos(get()) }
}

fun getPublicGithubRepos(repoRepository: RepoRepository): GetPublicGithubReposUseCase {
    return GetPublicGithubReposUseCaseImpl(repoRepository)
}
