package com.trinhlbk.githubpublicrepo.di.modules

import com.trinhlbk.githubpublicrepo.frameworks.network.GithubApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { retrofit() }
    single { githubApi(get()) }
}

fun retrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun githubApi(retrofit: Retrofit): GithubApi {
    return retrofit.create(GithubApi::class.java)
}