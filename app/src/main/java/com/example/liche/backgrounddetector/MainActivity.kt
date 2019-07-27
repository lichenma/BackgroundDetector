package com.example.liche.backgrounddetector

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}
