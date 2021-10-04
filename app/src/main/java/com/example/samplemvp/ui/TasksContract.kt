package com.example.samplemvp.ui

import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.samplemvp.BasePresenter
import com.example.samplemvp.BaseView

interface TasksContract {

    interface View : BaseView<Presenter> {

        var isActive: Boolean

        fun showAddTask()

        fun showFilteringPopUpMenu()
    }


    interface Presenter : BasePresenter {

        var currentFiltering: TasksFilterType

        fun result(requestCode: Int, resultCode: Int)

        fun loadTasks(forceUpdate: Boolean)

        fun addNewTask()

        fun completeTask(completedTask: Task)

        fun activateTask(activeTask: Task)

        fun clearCompletedTasks()

    }
}