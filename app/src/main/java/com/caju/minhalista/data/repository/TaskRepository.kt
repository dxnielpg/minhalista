package com.caju.minhalista.data.repository

import com.caju.minhalista.data.local.Task
import com.caju.minhalista.data.local.TaskDao

class TaskRepository(private val taskDao: TaskDao) {

    //atualizar a tarefa no banco de dados
    suspend fun updateTask(taskId: Int, newTitle: String, newDescription: String) {
        //atualizar a tarefa no banco de dados
        val task = taskDao.getTaskById(taskId) // Buscar a tarefa atual
        task?.let {
            it.title = newTitle
            it.description = newDescription
            taskDao.updateTask(it) // Atualizar a tarefa no banco
        }
    }

    suspend fun getAllTasks(): List<Task> {
        return taskDao.getAllTasks()
    }

    suspend fun getTaskById(id: Int): Task? {
        return taskDao.getTaskById(id)
    }

    suspend fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun deleteTaskById(taskId: Int) {
        taskDao.deleteTaskById(taskId)
    }
}

