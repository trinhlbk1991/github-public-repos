package com.trinhlbk.githubpublicrepo.components.repolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trinhlbk.core.entities.Repo
import com.trinhlbk.core.usecases.GetPublicGithubReposUseCase
import com.trinhlbk.githubpublicrepo.utils.Resource
import com.trinhlbk.githubpublicrepo.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class RepoListViewModel(
    private val getPublicGithubRepos: GetPublicGithubReposUseCase,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val repoList: MutableLiveData<Resource<List<Repo>>> = MutableLiveData()

    fun loadRepoList() {
        getPublicGithubRepos.execute()
            .subscribeOn(schedulerProvider.io())
            .doOnSubscribe {
                repoList.postValue(Resource.loading())
            }
            .subscribe({
                repoList.postValue(Resource.success(it))
            }, {
                repoList.postValue(Resource.error(msg = it.message ?: ""))
            })
            .let { disposables.add(it) }
    }

    fun getRepoList(): LiveData<Resource<List<Repo>>> = repoList

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}