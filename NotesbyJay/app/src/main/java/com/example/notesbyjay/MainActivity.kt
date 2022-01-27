package com.example.notesbyjay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //linking the views
    private var texts: EditText? = null
    private lateinit var list: TextView
    private var count = 0
    private lateinit var coun: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialising the views
        var add: Button = findViewById<Button>(R.id.add)
        texts = findViewById(R.id.texts)
        list = findViewById(R.id.list)
        coun =  findViewById(R.id.coun)
        var completed: Button = findViewById(R.id.completed)
        coun.text = ""
        list.text = ""

        //creating the to do list function
        var clearing = View.OnClickListener { a ->
            var b = a as Button
            list.text = ""
            count = 0
            coun.text = ""
            coun.append("You have now completed all your pending tasks")
        }
        var append = View.OnClickListener { a ->
            var b = a as Button
            coun.text = ""
            count +=1
            list.append("*--> ${texts?.text}\n")
            var e = ""
            coun.append("**You now have $count task$e")
            if (count > 1){
                coun.append("s**\n")
            }
            texts?.text!!.clear()
        }

        add.setOnClickListener(append)
        completed.setOnClickListener(clearing)

    }
}

