package com.caju.minhalista

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.caju.minhalista.ui.theme.MinhalistaTheme
import com.caju.minhalista.view.DetalhesTarefa
import com.caju.minhalista.view.ListaTarefas
import com.caju.minhalista.view.SalvarTarefa

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MinhalistaTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "listaTarefas") {
                    composable(route = "listaTarefas") {
                        ListaTarefas(navController)
                    }
                    composable(route = "salvarTarefa") {
                        SalvarTarefa(navController)
                    }
                    composable(
                        route = "detalhesTarefa/{taskTitle}",
                        arguments = listOf(navArgument("taskTitle") { type = NavType.StringType })
                    ) {
                        val taskTitle = it.arguments?.getString("taskTitle") ?: "Tarefa Desconhecida"
                        DetalhesTarefa(navController, taskTitle)
                    }
                }
            }
        }
    }
}
