package com.example.samplemvp.di

import android.content.Context
import com.example.samplemvp.data.source.TasksRepository
import com.example.samplemvp.data.source.local.TasksLocalDataSource
import com.example.samplemvp.data.source.local.ToDoDatabase
import com.example.samplemvp.data.source.remote.TasksRemoteDataSource

object Injection {

    fun provideTasksRepository(context: Context): TasksRepository {
        val database = ToDoDatabase.getInstance(context)

        return TasksRepository.getInstance(
            TasksRemoteDataSource, TasksLocalDataSource.getInstance(database.taskDao())
        )

    }
}