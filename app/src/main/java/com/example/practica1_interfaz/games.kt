package com.example.practica1_interfaz

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class CheckInfo(var title:String, var selected:Boolean, var
onCheckedChange:(Boolean)->Unit)

@Composable
fun games(navController: NavHostController, modifier: Modifier = Modifier ) {
    Box(
        modifier = modifier.fillMaxSize()
    ){
        val context = LocalContext.current

        val checkInfos = getCheckInfo(titles = listOf(
            "Angry Birds",
            "Dragon Fly",
            "Hill Climbing Racing",
            "Radiant Defense",
            "Pocket Soccer",
            "Ninja Jump",
            "Air Control"
        ))

        val images = listOf(
            R.drawable.games_angrybirds,
            R.drawable.games_dragonfly,
            R.drawable.games_hillclimbingracing,
            R.drawable.games_radiantdefense,
            R.drawable.games_pocketsoccer,
            R.drawable.games_ninjump,
            R.drawable.games_aircontrol
        )

        FloatingActionButton(
            onClick = {
                var string = "";
                for (i in checkInfos) {
                    if (i.selected) string += i.title + ", "
                }
                if (string.isEmpty()) string = "No ha seleccionado ninguna opción."
                else {
                    string = "Has seleccionado $string"
                    //string.removeSuffix(", ")
                    string += "."
                }

                Toast.makeText(
                    context,
                    string,
                    Toast.LENGTH_LONG
                ).show()
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Column (
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            for (i in 0..6) {
                val checkInfo = checkInfos[i]
                val image = images[i]

                Row {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = checkInfos[i].title,
                        modifier = Modifier.requiredSize(75.dp)
                    )
                    Checkbox (
                        checked = checkInfo.selected,
                        onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) }
                    )
                    Text(checkInfo.title)
                }
            }

        }
    }
}

@Composable
fun getCheckInfo(titles: List<String>): List<CheckInfo> {
    return titles.map { x ->
        var estadoCheck by rememberSaveable { mutableStateOf(false) }

        CheckInfo(
            title = x,
            selected = estadoCheck,
            onCheckedChange = { y -> estadoCheck = y }
        )
    }
}

