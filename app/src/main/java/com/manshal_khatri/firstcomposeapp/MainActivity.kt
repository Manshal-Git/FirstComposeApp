package com.manshal_khatri.firstcomposeapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.manshal_khatri.firstcomposeapp.ui.theme.FirstComposeAppTheme

class MainActivity : androidx.activity.ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme  {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = androidx.compose.ui.Modifier.padding(all = 8.dp).fillMaxSize(),
                    color = MaterialTheme.colors.background,
                    shape = MaterialTheme.shapes.medium,
                    elevation = 2.dp,

                ) {
                    ChatList(list = listOf("Manshal","Mixa","Meet","Pappa","Mummy","firends","Relatives","Well Wishers"))
                }
            }
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun Greeting(name: String) {
    var isSmall by remember {
        mutableStateOf(false)
    }
    Row (modifier = Modifier.padding(all = 16.dp)){
       Image(painter = painterResource(id = R.drawable.ic_launcher_foreground)
           , modifier = if(!isSmall){
               Modifier
                   .background(Color.Cyan, shape = RoundedCornerShape(16.dp))
                   .border(
                       width = 2.dp,
                       color = MaterialTheme.colors.primary,
                       shape = RoundedCornerShape(14.dp)
                   ).size(60.dp)

           }else {
               Modifier
                   .background(Color.Gray, shape = CircleShape)
                   .border(
                       width = 2.dp,
                       color = MaterialTheme.colors.primary,
                       shape = CircleShape
                   ).size(120.dp)
                 },
           contentDescription ="just image")
        Spacer(modifier = Modifier.width(24.dp))
        Column {
            Text(text = "Hello $name!", style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.height(16.dp))
            var clicked by remember {
                mutableStateOf(false)
            }
            Text(text = if(!clicked) "wanna Click me?" else "you clicked me :D",
            modifier = Modifier.clickable { clicked = !clicked;isSmall=!isSmall })
        }
    }

}

@Composable
fun ChatList(list : List<String>) {
    LazyColumn {
        list.map { 
            item { Greeting(name = it) }
        }
    }
}

