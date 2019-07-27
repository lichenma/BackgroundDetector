package com.example.liche.backgrounddetector

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class SecondActivity : AppCompatActivity() {
    private var TOTAL_COUNT = "total_count";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showRandomNumber()
    }
    public fun showRandomNumber(){
        var randomView:TextView = findViewById(R.id.textView3) as TextView
        var headingView:TextView = findViewById(R.id.textView) as TextView
        var count:Int = getIntent().getIntExtra(TOTAL_COUNT,0)
        var random:Random = Random();
        var randomInt:Int = 0;
        if (count>0){
            randomInt = random.nextInt(count);
        }

        randomView.setText(Integer.toString(randomInt));
        headingView.setText(getString(R.string.random_heading,count))
    }

}
