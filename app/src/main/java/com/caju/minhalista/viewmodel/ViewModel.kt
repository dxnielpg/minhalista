package com.caju.minhalista.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caju.minhalista.data.local.Task
import com.caju.minhalista.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {
    val tasks = mutableStateOf<List<Task>>(emptyList())

    fun fetchTasks() {
        viewModelScope.launch {
            tasks.value = repository.getAllTasks()
        }
    }

    fun addTask(title: String, description: String) {
        val task = Task(title = title, description = description)
        viewModelScope.launch {
            repository.insertTask(task)
            fetchTasks() // Atualiza a lista após inserir
        }
    }

    fun getTaskById(taskId: Int): Task? {
        return tasks.value.find { it.id == taskId }
    }
}
