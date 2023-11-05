package com.example.homework2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.homework2.ui.theme.Homework2Theme
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "first_screen_route"
            ) {
                composable("first_screen_route") {
                    FirstScreen(navController)
                }
                composable("second_screen_route") {
                    SecondScreen()
                }
            }
        }
    }
}


@Composable
fun FirstScreen(navController: NavController) {
    val navController = rememberNavController()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello!"
        )
    }
    Button(
        onClick = {

            navController.navigate("second_screen_route")

        }
    ) {
        Text("Go to Second Screen")
    }
}
    @Preview
    @Composable
    fun GreetingPreview() {
        Homework2Theme {
            FirstScreen(navController = rememberNavController())
        }
    }
