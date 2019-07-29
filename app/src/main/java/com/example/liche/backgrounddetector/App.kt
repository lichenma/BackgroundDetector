package com.example.liche.backgrounddetector

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.ProcessLifecycleOwner
import dagger.android.*
import javax.inject.Inject

class App : Application(), HasActivityInjector {
    @Inject
    lateinit var appLifecycleObserver: AppLifecycleObserver

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder().application(this).build().inject(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(appLifecycleObserver)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector
}