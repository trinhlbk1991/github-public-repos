package com.trinhlbk.githubpublicrepo.di.modules

import com.trinhlbk.githubpublicrepo.utils.SchedulerProvider
import com.trinhlbk.githubpublicrepo.utils.SchedulerProviderImpl
import org.koin.dsl.module

val appModule = module {
    single<SchedulerProvider> { SchedulerProviderImpl() }
}
