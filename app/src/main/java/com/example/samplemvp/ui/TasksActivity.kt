package com.example.samplemvp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.samplemvp.R
import com.example.samplemvp.util.setupActionBar

class TasksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tasks_act)

        setupActionBar(R.id.toolbar) {
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayHomeAsUpEnabled(true)
        }

    }
}