package com.caju.minhalista.ui.theme.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.caju.minhalista.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarTarefa(navController: NavController, taskId: Int, viewModel: TaskViewModel) {
    val taskTitle = remember { mutableStateOf("") }
    val taskDescription = remember { mutableStateOf("") }

    LaunchedEffect(taskId) {
        val task = viewModel.getTaskById(taskId) ?: return@LaunchedEffect // Sai se não encontrar a tarefa
        taskTitle.value = task.title
        taskDescription.value = task.description
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Editar Tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            TextField(
                value = taskTitle.value,
                onValueChange = { taskTitle.value = it },
                label = { Text("Nome da Tarefa") }
            )
            TextField(
                value = taskDescription.value,
                onValueChange = { taskDescription.value = it },
                label = { Text("Descrição da Tarefa") }
            )
            Button(
                onClick = {
                    try {
                        // Verifica se os valores estão preenchidos
                        if (taskTitle.value.isNotEmpty() && taskDescription.value.isNotEmpty()) {
                            viewModel.editTask(taskId, newTitle = taskTitle.value, newDescription = taskDescription.value)
                            navController.popBackStack() // Volta para a lista de tarefas
                        } else {
                            throw IllegalArgumentException("Título e descrição não podem estar vazios")
                        }
                    } catch (e: Exception) {
                        // Log para capturar o erro
                        Log.e("EditarTarefa", "Erro ao editar tarefa: ${e.message}")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Salvar")
            }
        }
    }
}

