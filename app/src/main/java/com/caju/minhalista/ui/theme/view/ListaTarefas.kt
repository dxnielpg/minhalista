package com.caju.minhalista.ui.theme.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.caju.minhalista.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaTarefas(navController: NavController, viewModel: TaskViewModel) {
    val taskList = viewModel.tasks.value

    // Chamando fetchTasks quando a tela for exibida
    LaunchedEffect(Unit) {
        viewModel.fetchTasks() // Carregar as tarefas do repositório
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Tarefometro",
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onPrimary // Cor do texto no TopAppBar
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary, // Cor de fundo do TopAppBar
                    titleContentColor = MaterialTheme.colorScheme.onPrimary // Cor do título
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("salvarTarefa") }) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar Tarefa")
            }

        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(taskList) { task ->
                // Usando o TarefaCard para exibir cada tarefa
                TarefaCard(task = task, navController = navController)
            }
        }
    }
}

