package com.example.homeprjhc.presentation.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homeprjhc.data.model.entity.City

@Composable
fun WeatherCity(
    city: City
) {

    Card(
        modifier = Modifier.padding(8.dp),
    ) {

        Row(Modifier.fillMaxWidth()) {

            Column(
                Modifier
                    .width(130.dp)
                    .padding(5.dp),
            ) {

                Text(
                    text = city.name,
                    modifier = Modifier.padding(4.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = city.weather,
                    modifier = Modifier.padding(4.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "${city.temperature}°",
                modifier = Modifier.padding(4.dp),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 45.sp
            )
        }
    }
}