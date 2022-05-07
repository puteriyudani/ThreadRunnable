package com.puteriyudani.threadrunnable

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            Worker().execute()
        }
    }
    inner class Worker : AsyncTask<Void, String, Boolean>() {
        override fun doInBackground(vararg p0: Void?): Boolean {
            for (i in 1..20) {
                publishProgress(i.toString())
                Thread.sleep(2000)
            }
            return true
        }
        override fun onProgressUpdate(vararg values: String?) {
            textView.text = values[0]
        }
        override fun onPostExecute(result: Boolean?) {
            println(result)
        }
    }
}