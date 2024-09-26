package com.caju.minhalista.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesTarefa(navController: NavController, taskTitle: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detalhes da Tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Nome da Tarefa:",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = taskTitle,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Descrição:",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "descrição de exemplo",
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(
                onClick = { navController.navigate("listaTarefas") },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Voltar para Lista")
            }
        }
    }
}
