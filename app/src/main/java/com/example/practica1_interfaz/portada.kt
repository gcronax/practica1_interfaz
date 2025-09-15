package com.example.practica1_interfaz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(-50.dp),
        modifier = modifier.fillMaxSize().wrapContentHeight()
        ){
        Text(
            text = "Play Juegos",
            modifier = modifier,
            color = Color.Green,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = modifier.size(50.dp))


        Button(onClick = { }, modifier = modifier.width(200.dp)) {
            Text("Play")
        }
        Button(onClick = { }, modifier = modifier.width(200.dp)) {
            Text("New Player")
        }
        Button(onClick = {  }, modifier = modifier.width(200.dp)) {
            Text("Preferences")
        }
        Button(onClick = {  }, modifier = modifier.width(200.dp)) {
            Text("About")
        }




    }
}


