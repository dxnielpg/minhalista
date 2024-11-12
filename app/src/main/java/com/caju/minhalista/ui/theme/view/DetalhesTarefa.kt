package com.caju.minhalista.ui.theme.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.caju.minhalista.data.local.Task
import com.caju.minhalista.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesTarefa(navController: NavController, taskId: Int, viewModel: TaskViewModel) {
    val task = remember { mutableStateOf<Task?>(null) }

    LaunchedEffect(taskId) {
        task.value = viewModel.getTaskById(taskId)
    }

    task.value?.let { taskDetails ->
        Scaffold(
            // TopAppBar permanece
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Text("Nome da Tarefa: ${taskDetails.title}")
                Text("Descrição: ${taskDetails.description}")
                // Botão voltar permanece
            }
        }
    }
}
