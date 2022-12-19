package com.sambrown.dokkanbefrienderapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.dokkanbefrienderapp.R
import com.sambrown.dokkanbefrienderapp.view.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun LoginScreen(navigator: DestinationsNavigator) {

    val username = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    )
    {
        Image(modifier= Modifier.padding(bottom = 15.dp)
            ,painter = painterResource(id = R.drawable.dragon_ball)
            , contentDescription = "Dragon ball")

        TextField(modifier = Modifier.padding(bottom = 12.dp),
            label = { Text(text = "Username") },
            value = username.value,
            onValueChange = { username.value = it })

        TextField(
            label = { Text(text = "Password") },
            value = password.value,
            onValueChange = { username.value = it })
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp)
                , horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    navigator.navigate(
                        HomeScreenDestination()
                    )
                },
                modifier = Modifier
                    .align(CenterVertically)
                    .height(55.dp)
                    .width(120.dp)
                    .padding(end = 15.dp)
            )
            {
                Text(text = stringResource(id = R.string.login_text_button))
            }

            Button(
                onClick = {
                    navigator.navigate(
                        HomeScreenDestination()
                    )
                },
                modifier = Modifier
                    .align(CenterVertically)
                    .height(55.dp)
                    .width(120.dp)
            )
            {
                Text(text = stringResource(id = R.string.register_text_button))
            }
        }

    }
}