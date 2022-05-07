package com.puteriyudani.threadrunnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            Thread(Runnable {
                killSomeTime()
            }).start()
        }
    }

    private fun killSomeTime() {
        for (i in 1..20) {
            runOnUiThread(Runnable{
                textView.text = i.toString()
            })
            println("i:$i")
            Thread.sleep(2000)
        }
    }
}