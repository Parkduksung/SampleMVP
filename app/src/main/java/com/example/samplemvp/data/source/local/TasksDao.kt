package com.example.samplemvp.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.android.architecture.blueprints.todoapp.data.Task

/**
 * Task 테이블의 데이터 액세스 개체
 */
@Dao interface TasksDao {

    /**
     * 데이터베이스 안에 Task 를 추가한다.
     *
     * 만일 Task 가 이미 존재하면 replace 한다.
     *
     * @param task 추가되는 Task
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertTask(task : Task)
}