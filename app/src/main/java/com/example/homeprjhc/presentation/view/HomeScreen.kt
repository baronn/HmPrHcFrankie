package com.example.homeprjhc.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.homeprjhc.R
import com.example.homeprjhc.presentation.viewmodel.WeatherViewModel


@Composable
fun HomeScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val cities = viewModel.cities.collectAsState().value
    val loggin = viewModel.loading.collectAsState().value
    val openAlertDialog = viewModel.error.collectAsState().value

    when{
        openAlertDialog -> {
            AlertDialogExample(
                onDismissRequest = { viewModel.closeAlertDialog() },
                onConfirmation = { viewModel.closeAlertDialog() },
                dialogTitle = stringResource(R.string.dialog_title),
                dialogText = stringResource(R.string.dialog_text),
                icon = Icons.Default.Warning,
                confirmText = stringResource(R.string.confirm_txt_btn),
                dismissText = stringResource(R.string.dismiss_txt_btn),
            )
        }

        loggin -> {
            TripleOrbitLoadingAnimation()
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
            .semantics { isTraversalGroup = true }) {

        SearchField{cityName -> viewModel.searchCityWeather(cityName)}

        LazyColumn(
            contentPadding = PaddingValues(5.dp),
            verticalArrangement = Arrangement.Top) {

            items(cities){ city ->
                WeatherCity(city)
            }
        }

    }
}