package com.example.samplemvp.ui

import androidx.fragment.app.Fragment

class TasksFragment : Fragment(), TasksContract.View {

    override lateinit var presenter: TasksContract.Presenter

}