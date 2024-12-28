package com.example.homeprjhc.presentation.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.homeprjhc.R

@Composable
fun SearchField(
    searchCityWeather: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    var text by rememberSaveable { mutableStateOf("") }
    var textIsShort by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 45.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
            .semantics { traversalIndex = 0f },
        value = text,
        singleLine = true,
        onValueChange = { text = it },
        shape = RoundedCornerShape(40.dp),
        placeholder = { Text(stringResource(R.string.search_hint)) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = if(textIsShort) Color.Red else Color.DarkGray,
            unfocusedBorderColor = Color.Gray,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        ),
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(onSearch = {
            if (text.length > 3) {
                searchCityWeather(text)
                text = ""
                textIsShort = false
                focusManager.clearFocus()
            } else {
                textIsShort = true
            }
        }),
    )
}