package com.example.practica1_interfaz

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practica1_interfaz.ui.theme.azulesB
import com.example.practica1_interfaz.ui.theme.fuentePortada
import com.example.practica1_interfaz.ui.theme.negro

@Composable
fun portada(navController: NavHostController, modifier: Modifier = Modifier) {

    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Hori(navController,modifier)
        }
        else -> {
            Verti(navController,modifier)
        }
    }
}
@Composable
fun Hori(navController: NavHostController,modifier: Modifier){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(-50.dp),
        modifier = modifier.fillMaxSize().wrapContentHeight()
    ){
        Text(
            text = "Play Juegos",
            modifier = modifier,
//            color = negro,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontFamily = fuentePortada
        )
        Spacer(modifier = modifier.size(50.dp))

        Row {
            Button(onClick = { navController.navigate("Games") },
                modifier = modifier.width(200.dp)
//                , colors = ButtonDefaults.buttonColors(containerColor = azulesB)
            ) {
                Text("Play")
            }
            Spacer(modifier = modifier.size(10.dp))

            Button(onClick = { navController.navigate("NewPlayer")},
                modifier = modifier.width(200.dp)
//                , colors = ButtonDefaults.buttonColors(containerColor = azulesB)
            ) {
                Text("New Player")
            }
        }

        Row {
            Button(onClick = { navController.navigate("Preferences") }, modifier = modifier.width(200.dp)
//                , colors = ButtonDefaults.buttonColors(containerColor = azulesB)
            ) {
                Text("Preferences")
            }
            Spacer(modifier = modifier.size(10.dp))

            Button(onClick = { navController.navigate("About") }, modifier = modifier.width(200.dp)
//                , colors = ButtonDefaults.buttonColors(containerColor = azulesB)
            ) {
                Text("About")
            }
        }


    }
}
@Composable
fun Verti(navController: NavHostController,modifier: Modifier){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(-50.dp),
        modifier = modifier.fillMaxSize().wrapContentHeight()
    ){
        Text(
            text = "Play Juegos",
            modifier = modifier,
//            color = negro,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontFamily = fuentePortada
        )
        Spacer(modifier = modifier.size(50.dp))


        Button(onClick = { navController.navigate("Games")}, modifier = modifier.width(200.dp)
//            , colors = ButtonDefaults.buttonColors(containerColor = azulesB)
        ) {
            Text("Play")
        }
        Button(onClick = {navController.navigate("NewPlayer") }
            , modifier = modifier.width(200.dp)
//            , colors = ButtonDefaults.buttonColors(containerColor = azulesB)
        ) {
            Text("New Player")
        }
        Button(onClick = { navController.navigate("Preferences") }, modifier = modifier.width(200.dp)
//            , colors = ButtonDefaults.buttonColors(containerColor = azulesB)
        ) {
            Text("Preferences")
        }
        Button(onClick = { navController.navigate("About") }, modifier = modifier.width(200.dp)
//            , colors = ButtonDefaults.buttonColors(containerColor = azulesB)
        ) {
            Text("About")
        }
    }
}


