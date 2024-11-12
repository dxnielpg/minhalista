package com.caju.minhalista.ui.theme.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.caju.minhalista.viewmodel.TaskViewModel
import com.caju.minhalista.data.local.Task
import com.caju.minhalista.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaTarefas(navController: NavController, viewModel: TaskViewModel) {
    val taskList = viewModel.tasks.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Tarefas", fontSize = 18.sp) }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("salvarTarefa")  // Navega para a tela de salvar tarefa
                }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),  // ícone de adicionar
                    contentDescription = "Adicionar Tarefa"
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            if (taskList.isEmpty()) {
                item {
                    Text(
                        text = "Nenhuma tarefa encontrada.",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        fontSize = 16.sp
                    )
                }
            } else {
                items(taskList) { task ->
                    Button(
                        onClick = {
                            navController.navigate("detalhesTarefa/${task.id}")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text(task.title)
                    }
                }
            }
        }
    }
}

