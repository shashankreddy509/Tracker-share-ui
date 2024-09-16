package com.shashank.expense.tracker


import com.shashank.expense.tracker.cache.AndroidDatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<TrackerSDK> {
        TrackerSDK(
            databaseDriverFactory = AndroidDatabaseDriverFactory(
                androidContext()
            )
        )
    }
    viewModel { MainViewModel(sdk = get())}
}