package com.example.liche.backgrounddetector

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.app.Application
import android.arch.lifecycle.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import dagger.android.AndroidInjection
import javax.*;
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var appLifecycleObserver: AppLifecycleObserver


    var listener = object: BroadcastReceiver(){
        override fun onReceive(context:Context, intent:Intent){
            if (intent.getStringExtra("data")=="FOREGROUND"){
                //var defaultTextView:TextView = findViewById(R.id.randomNumber) as TextView;
                //defaultTextView.setText("Default Text");
                Log.d("we got here", "hello")
            } else if (intent.getStringExtra("data")=="BACKGROUND") {
                var defaultTextView: TextView = findViewById(R.id.randomNumber) as TextView;
                defaultTextView.setText("You Have Left the App");
                Log.d("we  got here", "hello")
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appLifecycleObserver = AppLifecycleObserver(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(appLifecycleObserver)

        LocalBroadcastManager.getInstance(this).registerReceiver(listener, IntentFilter("SEND_BACKGROUND"))
    }

    /**
     * Show a toast
     * @param view - the view that is clicked
     */
    private var TOTAL_COUNT = "total_count";
    public fun toastMe(view: View){
        val myToast: Toast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT);
        myToast.show();
    }

    public fun countMe(view: View){
        var showCountTextView: TextView = findViewById(R.id.randomNumber) as TextView;
        var countString: String = showCountTextView.getText().toString();
        var count:Int = Integer.parseInt(countString);
        count++;
        showCountTextView.setText(count.toString());
    }

    public fun randomMe(view: View){
        var randomIntent = Intent(this, SecondActivity::class.java)
        var showCountTextView:TextView = findViewById(R.id.randomNumber) as TextView;
        var countString:String = showCountTextView.getText().toString();
        var count:Int = Integer.parseInt(countString);
        randomIntent.putExtra(TOTAL_COUNT, count);
        startActivity(randomIntent)
    }
    public fun resetMe(view: View) {
        var defaultTextView:TextView = findViewById(R.id.randomNumber) as TextView;
        defaultTextView.setText("Default Text");

    }

    public fun changeMe(view: View){
        var defaultTextView: TextView = findViewById(R.id.randomNumber) as TextView;
        defaultTextView.setText("You Have Left the App");
    }
}


