package com.example.liche.backgrounddetector

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.os.PowerManager
import android.widget.Toast
import javax.inject.Inject
import android.content.Intent
import android.widget.TextView

class AppLifecycleObserver @Inject constructor(context: Context) : LifecycleObserver {
    private val enterToast = Toast.makeText(context, context.getString(R.string.foreground_message), Toast.LENGTH_LONG)
    private val exitToast = Toast.makeText(context, context.getString(R.string.background_message), Toast.LENGTH_LONG)
    private val pm = context.applicationContext.getSystemService(Context.POWER_SERVICE) as PowerManager
    //private var main:Activity = context as Activity
    //private val view:TextView = main.findViewById(R.id.randomNumber) as TextView;

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onEnterForeground() {
        enterToast.showAfterCancel(exitToast)
        //view.setText("Default Text");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onEnterBackground() {
        if (pm.isInteractive()){
            exitToast.showAfterCancel(enterToast)
            //view.setText("You have left the app!")
        }
    }

    private fun Toast.showAfterCancel(toastToCancel: Toast){
        toastToCancel.cancel()
        this.show()
    }
}