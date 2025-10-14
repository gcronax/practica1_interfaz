package com.example.practica1_interfaz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun splash(navController: NavHostController, modifier: Modifier = Modifier) {

    Box(
        modifier.fillMaxSize()
    ){

        Image(
            painter = painterResource(id = R.drawable.screen),
            contentDescription = "Logotipo de la Aplicación",
            modifier = Modifier.requiredSize(300.dp).align(Alignment.Center)
        )
        Text(text = "prueba",
        textAlign = TextAlign.Center,
        modifier = modifier.align(Alignment.BottomCenter)
        )
    }

    val delaySeconds: Long = 2
    LaunchedEffect(true) {
        delay(delaySeconds * 1000)
        navController.navigate("Portada")
    }
}