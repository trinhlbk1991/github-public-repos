package com.trinhlbk.githubpublicrepo.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface SchedulerProvider {
    fun io(): Scheduler

    fun ui(): Scheduler

    fun computation(): Scheduler
}

class SchedulerProviderImpl : SchedulerProvider {
    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }
}
