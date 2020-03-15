package com.trinhlbk.githubpublicrepo.di.modules

import com.trinhlbk.core.data.RepoRepository
import com.trinhlbk.githubpublicrepo.frameworks.network.GithubApi
import com.trinhlbk.githubpublicrepo.repositories.RepoRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { repoRepository(get()) }
}

fun repoRepository(githubApi: GithubApi): RepoRepository {
    return RepoRepositoryImpl(githubApi)
}