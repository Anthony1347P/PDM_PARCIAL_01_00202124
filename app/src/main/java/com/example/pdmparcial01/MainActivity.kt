package com.example.parcial01_pdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial01_pdm.ui.screen.MenuScreen
import com.example.parcial01_pdm.ui.screen.OrdenScreen
import com.example.parcial01_pdm.ui.theme.Parcial01_PDMTheme
import com.example.parcial01_pdm.ui.viewmodel.OrdenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Parcial01_PDMTheme {
                OrderUpApp()
            }
        }
    }
}

@Composable
fun OrderUpApp() {

    // var    by rememberSaveable { mutableIntStateOf(0) }
    val navController = rememberNavController()
    val viewModel: OrdenViewModel = viewModel()

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            MenuScreen(
                viewModel = viewModel,
                onNavigateToOrden = { navController.navigate("orden") }
            )
        }

        composable("orden") {
            OrdenScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}