package com.example.kotlingeneratingprocessor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlingeneratingprocessor.extension.getGenString

@MyAnnotation
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (findViewById(R.id.text_view) as TextView).text = this.getGenString()
    }
}
