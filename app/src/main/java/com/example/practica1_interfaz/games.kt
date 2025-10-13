package com.example.practica1_interfaz

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@Composable
fun games(navController: NavHostController, modifier: Modifier = Modifier) {
    var seleccionChip by remember { mutableStateOf("") }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()),
    ){
        chips2(seleccionChip,onChange = {seleccionChip=it})
        Text(text = seleccionChip)

    }

}
@Composable
fun chips2(seleccionChip: String, onChange:(String)->Unit) {
    var context = LocalContext.current
    val nombres =listOf<String>("PS4","XBOX","3DS","WII","WIIU")

    R.drawable.games_aircontrol
    Column {
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
