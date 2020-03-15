package com.trinhlbk.core.data

import com.trinhlbk.core.entities.Repo
import io.reactivex.Single

interface RepoRepository {
    fun getAll(): Single<List<Repo>>
}