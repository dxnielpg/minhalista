package com.caju.minhalista.ui.theme.view

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
fun SalvarTarefa(navController: NavController, viewModel: TaskViewModel) {
    val taskTitle = remember { mutableStateOf("") }
    val taskDescription = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Salvar Tarefa",
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
                    // Salvar tarefa no banco de dados
                    viewModel.addTask(title = taskTitle.value, description = taskDescription.value)
                    // Voltar para a lista de tarefas
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Salvar")
            }
        }
    }
}