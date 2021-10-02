package com.example.samplemvp.data.source.local

import androidx.annotation.VisibleForTesting
import com.example.samplemvp.data.source.TasksDataSource

class TasksLocalDataSource private constructor(
    val tasksDao: TasksDao
) : TasksDataSource {


    companion object {
        private var INSTANCE: TasksLocalDataSource? = null


        @JvmStatic
        fun getInstance(tasksDao: TasksDao): TasksLocalDataSource {
            if (INSTANCE == null) {
                synchronized(TasksLocalDataSource::javaClass) {
                    INSTANCE = TasksLocalDataSource(tasksDao)
                }
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }
}