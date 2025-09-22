package com.example.practica1_interfaz


import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practica1_interfaz.ui.theme.azulesB
import com.example.practica1_interfaz.ui.theme.naranja
import com.example.practica1_interfaz.ui.theme.negro

@Composable
fun newP(navController: NavHostController, modifier: Modifier = Modifier) {

    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            hori2(navController,modifier)
        }
        else -> {
            verti2(navController,modifier)
        }
    }
}
@Composable
fun hori2(navController: NavHostController,modifier: Modifier){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(-50.dp),
        modifier = modifier.fillMaxSize().wrapContentHeight()
    ){
        Text(
            text = "Que miras",
            modifier = modifier,
            color = negro,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
    }
}
@Composable
fun verti2(navController: NavHostController,modifier: Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().wrapContentHeight()
    ){
        Row {
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Icono de Perfil",
                tint = Color.DarkGray,
                modifier = Modifier.size(50.dp)
            )
            var estadoTextField by remember { mutableStateOf(" ") }
            TextField(
                value = estadoTextField,
                onValueChange = {
                    estadoTextField = it
                },
                label = { Text(text = "Nombre")
                })
        }
        Spacer(modifier = modifier.size(10.dp))
        Row {
            Spacer(modifier = modifier.size(50.dp))
            var estadoTextField by remember { mutableStateOf(" ") }
            TextField(
                value = estadoTextField,
                onValueChange = {
                    estadoTextField = it
                },
                label = { Text(text = "Apellidos")
                })
        }
//        Spacer(modifier = modifier.size(10.dp))
        Row {
            Spacer(modifier = modifier.size(50.dp))
            var estadoTextField by remember { mutableStateOf(" ") }
            TextField(
                value = estadoTextField,
                onValueChange = {
                    estadoTextField = it
                },
                label = { Text(text = "Nickname")
                })
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.android),
                contentDescription = "Android",
                modifier = Modifier.requiredSize(150.dp)
            )
            Button(onClick = { }, modifier = modifier.width(100.dp),
                colors = ButtonDefaults.buttonColors(containerColor = naranja)
            ) {
                Text("Change")
            }
        }

        Spacer(modifier = modifier.size(10.dp))

        Row {
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = "Icono de Telefono",
                tint = Color.DarkGray,
                modifier = Modifier.size(50.dp)
            )
            var estadoTextField by remember { mutableStateOf(" ") }
            TextField(
                value = estadoTextField,
                onValueChange = {
                    estadoTextField = it
                },
                label = { Text(text = "Telefono")
                })
        }
        Spacer(modifier = modifier.size(10.dp))
        Row {
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = "Icono de Mail",
                tint = Color.DarkGray,
                modifier = Modifier.size(50.dp)
            )
            var estadoTextField by remember { mutableStateOf(" ") }
            TextField(
                value = estadoTextField,
                onValueChange = {
                    estadoTextField = it
                },
                label = { Text(text = "Email")
                })
        }
        Spacer(modifier = modifier.size(10.dp))


    }
}

