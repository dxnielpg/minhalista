/*package com.caju.minhalista.ui.theme.view

import androidx.compose.animation.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

// Marcando o uso da API Experimental de Animação
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedNavigation(navController: NavHostController) {
    // Usando AnimatedContent com transições animadas
    AnimatedContent(
        targetState = navController.currentBackStackEntry,
        transitionSpec = {
            slideInHorizontally() with slideOutHorizontally()
        }
    ) { targetState ->
        // Aqui você pode adicionar a navegação entre as telas ou qualquer outro comportamento desejado.
        // Exemplo:
        // Quando a navegação acontecer, você pode renderizar a tela correspondente.
    }
}
*/