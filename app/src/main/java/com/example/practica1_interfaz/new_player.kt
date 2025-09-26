package com.example.practica1_interfaz


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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practica1_interfaz.ui.theme.azulesB
import com.example.practica1_interfaz.ui.theme.naranja


@Composable
fun NewP(navController: NavHostController, modifier: Modifier = Modifier){

    var comprobarNombre by remember { mutableStateOf(false) }
    var comprobarNickname by remember { mutableStateOf(false) }
    var estadoNombre by remember { mutableStateOf(" ") }
    var estadoNickname by remember { mutableStateOf(" ") }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().wrapContentHeight().verticalScroll(rememberScrollState()),
    ){
        Row {
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Icono de Perfil",
                tint = Color.DarkGray,
                modifier = Modifier.size(50.dp)
            )
            Column {
                TextField(
                    value = estadoNombre,
                    onValueChange = {
                        estadoNombre = it
                    },
                    label = { Text(text = "Nombre")
                    })
                if (comprobarNombre) {
                    Text("Este campo no puede estar vacío", color = Color.Red, style = MaterialTheme.typography.bodySmall)
                }
            }

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
            Column {
                TextField(
                    value = estadoNickname,
                    onValueChange = {
                        estadoNickname = it
                    },
                    label = { Text(text = "Nickname")
                    })
                if (comprobarNickname) {
                    Text("Este campo no puede estar vacío", color = Color.Red, style = MaterialTheme.typography.bodySmall)
                }
            }
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
                }
            )
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

        Button(onClick = {
//            navController.navigate("Portada")
            comprobarNombre=estadoNombre.isBlank()
            comprobarNickname=estadoNickname.isBlank()
        },
            modifier = modifier.width(200.dp),
            colors = ButtonDefaults
                .buttonColors(containerColor = azulesB)
        ) {
            Text("Crear New Player")
        }
    }
}

