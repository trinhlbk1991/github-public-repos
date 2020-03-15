package com.trinhlbk.githubpublicrepo.di.modules

import com.trinhlbk.githubpublicrepo.components.repolist.RepoListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RepoListViewModel(get(), get()) }
}