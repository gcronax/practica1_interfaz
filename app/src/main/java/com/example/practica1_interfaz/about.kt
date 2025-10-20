package com.example.practica1_interfaz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

data class imgenes(
    val nombre: String,
    val puntuacion: Int,
    val direccion: Int
    )

@Composable
fun about(navController: NavHostController, modifier: Modifier = Modifier) {

    val personaSeleccionada by remember {
        mutableStateOf(listOf(
            imgenes(
                "María Mata",
                2014,
                R.drawable.image1
            ),
            imgenes(
                "Antonio Sanz",
                2056,
                R.drawable.image2
            ),
            imgenes(
                "Carlos Perez",
                5231,
                R.drawable.image3
            ),
            imgenes(
                "Beatriz Martos",
                1892,
                R.drawable.image4
            ),
            imgenes(
                "Sandra Alegre",
                3400,
                R.drawable.image5
            ),
            imgenes(
                "Alex Serrat",
                5874,
                R.drawable.image6
            ),
            imgenes(
                "Ana Peris",
                2238,
                R.drawable.image7
            ),
            imgenes(
                "Pablo Morralla",
                6969,
                R.drawable.image8
            )
        ))
    }


    Box(
        modifier.fillMaxSize()
    ){


    }
}