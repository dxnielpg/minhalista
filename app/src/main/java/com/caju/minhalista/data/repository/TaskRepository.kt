package com.caju.minhalista.data.repository

import com.caju.minhalista.data.local.Task
import com.caju.minhalista.data.local.TaskDao

class TaskRepository(private val taskDao: TaskDao) {

    suspend fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun getAllTasks(): List<Task> {
        return taskDao.getAllTasks()
    }

    suspend fun getTaskById(taskId: Int): Task? {
        return taskDao.getTaskById(taskId)
    }
}
