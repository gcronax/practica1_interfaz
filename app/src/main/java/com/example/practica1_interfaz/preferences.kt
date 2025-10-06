package com.example.practica1_interfaz

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlin.math.ceil
import kotlin.math.floor

@Composable
fun preferences(navController: NavHostController, modifier: Modifier = Modifier){
    var estadoRadio by rememberSaveable { mutableStateOf("") }
    var estadoRating by rememberSaveable { mutableFloatStateOf(0f) }
    var selection by remember { mutableStateOf(5f) }
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()),
    ){
        Text("Elige una opción:",modifier.align(Alignment.CenterHorizontally))

        botones( estadoRadio,{estadoRadio = it})
        val range = 0.0f..10.0f
        val steps = 9

        Slider(
            value = selection,
            valueRange = range,
            steps = steps,
            onValueChange = { selection = it },
            modifier = Modifier.padding(start = 20.dp,end = 20.dp)
        )
        RatingBar(estadoRating=estadoRating,  onStarselected = {estadoRating = it})


    }
//    SmallExample(estadoRating)
    FAV(estadoRadio,selection.toString(),modifier)

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
@Composable
fun RatingBar(
    estadoRating: Float,
    modifier: Modifier = Modifier,
    stars: Int = 10,
    rating: Double = 0.0,
    onStarselected: (Float) -> Unit
    ){
    val filledStars = floor(rating).toInt()
    val unfilledStars = (stars - ceil(rating)).toInt()
    Row{
        repeat(filledStars) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = modifier.clickable{onStarselected(estadoRating)}
            )
        }

        repeat(unfilledStars) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null
            )
        }
    }
    Text(text = estadoRating.toString())


}
@Composable
fun FAV(estado: String,selection: String,modifier: Modifier) {
    var context = LocalContext.current
    FloatingActionButton(
        onClick = {
            if (estado.isEmpty()){
                Toast.makeText(context, "No has pulsado ninguna opcion", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(context, "Has seleccionado $estado con una puntuacion de $selection", Toast.LENGTH_LONG).show()
            }
        }
    ) {
        Icon(Icons.Filled.Done, "Floating action button.")
    }
}

@Composable
fun SmallExample(onClick: String) {
    var context = LocalContext.current
    SmallFloatingActionButton(
        onClick = {
            if (onClick.isEmpty()){
                Toast.makeText(context, "No has pulsado ninguna opcion", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(context, "Has seleccionado $onClick con una puntuacion de ", Toast.LENGTH_LONG).show()
            }
        },
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(Icons.Filled.Star, "Small floating action button.")
    }
}
