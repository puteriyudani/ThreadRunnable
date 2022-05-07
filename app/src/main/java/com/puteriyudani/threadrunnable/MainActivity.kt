package com.puteriyudani.threadrunnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mhandler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mhandler = object : Handler() {
            override fun handleMessage(msg: Message) {
                textView.text = msg?.data?.getString("counter")
            }
        }
        button.setOnClickListener {
            Thread(Runnable {
                killSomeTime()
            }).start()
        }
    }
    private fun killSomeTime() {
        for (i in 1..20) {
            var msg = Message.obtain()
            msg.data.putString("counter", i.toString())
            mhandler.sendMessage(msg)
            Thread.sleep(2000)
        }
    }
}