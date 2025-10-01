package com.example.practica1_interfaz

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practica1_interfaz.ui.theme.fuentePortada

@Composable
fun preferences(navController: NavHostController, modifier: Modifier = Modifier){
    var estadoRadio by rememberSaveable { mutableStateOf("") }
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().wrapContentHeight().verticalScroll(rememberScrollState()),
    ){
        botones( estadoRadio,{estadoRadio = it})
    }
}

@Composable
fun botones(estadoRadio: String, onItemselected:(String)->Unit){
    val array_juegos = arrayListOf("Angri Birds","Dragon Fly","Hill Climbing Racing",
        "Pocket Socket", "Radiant Defense","Ninja Jump","Air Control"
    )
    array_juegos.forEach { nom ->
        Row{
            RadioButton(
                selected =  estadoRadio==nom,
                onClick = {onItemselected(nom)}
            )
                Text(text=nom,Modifier.padding(top=12.dp))

        }
    }
    Text(text=estadoRadio)
}
