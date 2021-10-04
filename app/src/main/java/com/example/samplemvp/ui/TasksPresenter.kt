package com.example.samplemvp.ui

import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.samplemvp.data.source.TasksRepository

class TasksPresenter(val tasksRepository: TasksRepository, val tasksView: TasksContract.View) :
    TasksContract.Presenter {

    override var currentFiltering: TasksFilterType = TasksFilterType.ALL_TASKS

    private var firstLoad = true

    init {
        tasksView.presenter = this
    }

    override fun start() {

    }

    override fun addNewTask() {
        tasksView.showAddTask()
    }

    override fun result(requestCode: Int, resultCode: Int) {

    }

    override fun loadTasks(forceUpdate: Boolean) {
    }

    override fun completeTask(completedTask: Task) {
    }

    override fun activateTask(activeTask: Task) {
    }

    override fun clearCompletedTasks() {
    }
}