package com.puteriyudani.threadrunnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            doAsync {
                for(i in 1..15) {
                    Thread.sleep(2000)
                    activityUiThread {
                        textView.text = i.toString()
                    }
                }
            }
        }
    }
}