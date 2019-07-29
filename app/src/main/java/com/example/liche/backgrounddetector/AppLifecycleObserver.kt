package com.example.liche.backgrounddetector

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.widget.Toast
import javax.inject.Inject

class AppLifecycleObserver @Inject constructor(context: Context) : LifecycleObserver {
    private val enterToast = Toast.makeText(context, context.getString(R.string.foreground_message), Toast.LENGTH_LONG)
    private val exitToast = Toast.makeText(context, context.getString(R.string.background_message), Toast.LENGTH_LONG)
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onEnterForeground() {
        enterToast.showAfterCancel(exitToast)


    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onEnterBackground() {
        exitToast.showAfterCancel(enterToast)
    }

    private fun Toast.showAfterCancel(toastToCancel: Toast){
        toastToCancel.cancel()
        this.show()
    }
}