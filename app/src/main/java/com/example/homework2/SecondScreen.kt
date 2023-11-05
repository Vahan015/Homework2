package com.example.homework2
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image



class SecondScreen {
    data class City(
        val name: String,
        val description: String,
        val imageResource: Int,
    ) {

    }



    @Composable

    fun SecondScreenview() {
        val cities = listOf(
            City("Yerevan",
                "Capital of Armenia",
                R.drawable.Yerevan),
            City("Washington",
                "Capital of the United States",
                R.drawable.Washington),
            City("Madrid",
                "Capital of Spain",
                R.drawable.Madrid),
            City("Paris",
                "Capital of France",
                R.drawable.Paris),
        )
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "welcome_screen"
        ) {
            composable("welcome_screen") {
                SecondScreenview()
            }
            composable("list_screen") {
                CityList(cities)
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "This is the Second Screen")
        }

    }

    @Preview
    @Composable
    fun SecondScreenPreview() {
        SecondScreenview()
    }
    @Composable
    fun CityList(cities: List<City>) {
        LazyColumn {
            items(cities) { city ->
                CityItem(city)
            }
        }
    }

    @Composable
    fun CityItem(city: City) {
        Column(
            modifier = Modifier

        ) {
            Image(
                painter = painterResource(id = city.imageResource),
                modifier = Modifier,
                contentScale = ContentScale.Crop
            )
            Text(text = city.name)
            Text(text = city.description)
        }
    }

}

