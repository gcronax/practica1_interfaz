package com.example.practica1_interfaz

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle


@Composable
fun preferences(navController: NavHostController, modifier: Modifier = Modifier){
    var estadoRadio by rememberSaveable { mutableStateOf("") }
    var estadoRating by rememberSaveable { mutableFloatStateOf(0f) }
    var selection by remember { mutableStateOf(5f) }
    var seleccionChip by remember { mutableStateOf("") }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()),
    ){
        Column {
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
            RatingBar( onStarselected = {estadoRating = it},10,estadoRating)

            chips(seleccionChip, onChange = {seleccionChip=it})
        }

        Column (
        ){
            SmallExample(estadoRating,estadoRadio)
            FAV(estadoRadio,selection.toString(),modifier)
        }
    }




}
@Composable
fun chips(seleccionChip: String, onChange:(String)->Unit) {
    var context = LocalContext.current
    val nombres =listOf<String>("PS4","XBOX","3DS","WII","WIIU")
    Row {
        for (i in nombres){
            FilterChip(
                onClick = { onChange(i)
                    Toast.makeText(context, "has seleccionado $i", Toast.LENGTH_LONG).show()
                },
                label = {
                    Text(i)
                },
                selected = seleccionChip==i,
                leadingIcon = if (seleccionChip==i) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Done icon",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else {
                    null
                }
            )
        }
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
//    Text(text=estadoRadio)
}
@Composable
fun RatingBar(
    onStarselected: (Float) -> Unit,
    stars: Int ,
    rating: Float
){
        Row{
            for (i in 1..stars){
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .weight(1f)
                        .clickable{onStarselected(i.toFloat())}
                        .padding(4.dp),
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = if (i <= rating) Color.Red else Color.Gray
                )
            }
        }
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
fun SmallExample(onClick: Float,selection: String) {
    var context = LocalContext.current
    SmallFloatingActionButton(
        onClick = {
            if (selection.isEmpty()){
                Toast.makeText(context, "No has pulsado ninguna opcion", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(context, "Has seleccionado $selection con una puntuacion de $onClick", Toast.LENGTH_LONG).show()
            }
        },
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(Icons.Filled.Star, "Small floating action button.")
    }
}
