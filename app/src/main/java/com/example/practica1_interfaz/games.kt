package com.example.practica1_interfaz

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
onCheckedChange:(Boolean)->Unit,var id: Int)
@Composable
fun games(navController: NavHostController, modifier: Modifier = Modifier) {

    var listCheckInfo =getOptions(listOf(
        "Angry Birds",
        "Dragon Fly",
        "Hill Climbing Racing",
        "Radiant Defense",
        "Pocket Soccer",
        "Ninja Jump",
        "Air Control"
    ))

    Box(
        modifier=modifier.fillMaxSize()
    ){
        Column {
            for (obj in listCheckInfo){
                Row(Modifier.padding(8.dp)) {
                    Image(
                        painter = painterResource(id = obj.id),
                        contentDescription = obj.title,
                        modifier = Modifier.requiredSize(50.dp)
                    )
                    Checkbox(
                        checked = obj.selected,
                        onCheckedChange = {
                            obj.onCheckedChange(!obj.selected) })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = obj.title)
                }
            }
        }
        var context = LocalContext.current
        FloatingActionButton(
            onClick = {
                var nombres=""
                for (obj in listCheckInfo){

                }

                if (nombres.isEmpty()){
                    Toast.makeText(context, "No has pulsado ninguna opcion", Toast.LENGTH_LONG).show()

                }else{
                    Toast.makeText(context, "Has seleccionado $nombres", Toast.LENGTH_LONG).show()
                }
            },
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(16.dp)
        ) {
            Icon(Icons.Filled.Done, "Floating action button.")
        }


    }

}


@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    var imagenes = listOf(
        R.drawable.games_angrybirds,
        R.drawable.games_dragonfly,
        R.drawable.games_hillclimbingracing,
        R.drawable.games_radiantdefense,
        R.drawable.games_pocketsoccer,
        R.drawable.games_ninjump,
        R.drawable.games_aircontrol
    )
    var i =0
    return titles.map {
        var estadoCheck by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            selected = estadoCheck,
            onCheckedChange = { estadoCheck = it },
            id = imagenes[i++]
        )
    }

}
