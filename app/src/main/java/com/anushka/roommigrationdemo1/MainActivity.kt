package com.anushka.roommigrationdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = StudentDatabase.getInstance(application).subscriberDAO

        val etCourse = findViewById<EditText>(R.id.etCourse)
        val nameEditText = findViewById<EditText>(R.id.etName)
        val button = findViewById<Button>(R.id.btnSubmit)

        button.setOnClickListener {
            lifecycleScope.launch {
                nameEditText.text.let {
                    dao.insertStudent(Student(0,it.toString(), etCourse.text.toString()))
                    nameEditText.setText("")
                    etCourse.setText("")
                }
            }
        }


    }
}