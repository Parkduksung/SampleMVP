package com.example.samplemvp.data.source

class TasksRepository(
    val tasksRemoteDataSource: TasksDataSource,
    val tasksLocalDataSource: TasksDataSource
) {


    companion object {

        private var INSTANCE: TasksRepository? = null


        @JvmStatic
        fun getInstance(
            tasksRemoteDataSource: TasksDataSource,
            tasksLocalDataSource: TasksDataSource
        ): TasksRepository {
            return INSTANCE ?: TasksRepository(tasksRemoteDataSource, tasksLocalDataSource).apply {
                INSTANCE = this
            }
        }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }

    }

}