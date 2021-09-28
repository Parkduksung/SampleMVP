package com.example.samplemvp.ui

import com.example.samplemvp.data.source.TasksRepository

class TasksPresenter(val tasksRepository: TasksRepository, val tasksView: TasksContract.View) :
    TasksContract.Presenter {

    override var currentFiltering: TasksFilterType = TasksFilterType.ALL_TASKS


    override fun start() {

    }
}