package com.caju.minhalista

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.caju.minhalista.data.local.TaskDatabase
import com.caju.minhalista.data.repository.TaskRepository
import com.caju.minhalista.ui.theme.MinhalistaTheme
import com.caju.minhalista.ui.theme.view.DetalhesTarefa
import com.caju.minhalista.ui.theme.view.EditarTarefa
import com.caju.minhalista.ui.theme.view.ListaTarefas
import com.caju.minhalista.ui.theme.view.SalvarTarefa
import com.caju.minhalista.viewmodel.TaskViewModel
import com.caju.minhalista.viewmodel.TaskViewModelFactory

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicializar o banco de dados e o repositório
        val taskDatabase = TaskDatabase.getDatabase(applicationContext)
        val taskDao = taskDatabase.taskDao()
        val taskRepository = TaskRepository(taskDao)

        // Inicializar o ViewModel com a fábrica
        val taskViewModel = ViewModelProvider(
            this, TaskViewModelFactory(taskRepository)
        ).get(TaskViewModel::class.java)

        setContent {
            MinhalistaTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "listaTarefas") {
                    composable(route = "listaTarefas") {
                        ListaTarefas(navController, taskViewModel)
                    }
                    composable(route = "salvarTarefa") {
                        SalvarTarefa(navController, taskViewModel)
                    }
                    composable(
                        route = "detalhesTarefa/{taskId}",
                        arguments = listOf(navArgument("taskId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val taskId = backStackEntry.arguments?.getInt("taskId") ?: 0
                        DetalhesTarefa(navController, taskId, taskViewModel)
                    }
                    // Rota para editar tarefa
                    composable(
                        route = "editarTarefa/{taskId}",
                        arguments = listOf(navArgument("taskId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val taskId = backStackEntry.arguments?.getInt("taskId") ?: 0
                        EditarTarefa(navController, taskId, taskViewModel)
                    }
                }
            }
        }
    }
}
