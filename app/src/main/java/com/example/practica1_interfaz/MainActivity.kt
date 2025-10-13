package com.example.practica1_interfaz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practica1_interfaz.ui.theme.Practica1_interfazTheme
import com.example.practica1_interfaz.ui.theme.verdes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica1_interfazTheme {
                Scaffold(modifier = Modifier.fillMaxSize()
//                    , containerColor = verdes
                ) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Splash") {
                        composable("Splash") {splash(navController,
                            Modifier.padding(innerPadding))  }
                        composable("Portada") {portada(navController,
                            Modifier.padding(innerPadding))  }
                        composable("NewPlayer") {NewP(navController,
                            Modifier.padding(innerPadding))  }
                        composable("Preferences") {preferences(navController,
                            Modifier.padding(innerPadding))  }
                        composable("Games") {games(navController,
                            Modifier.padding(innerPadding))  }

                    }
                }
            }
        }
    }
}



