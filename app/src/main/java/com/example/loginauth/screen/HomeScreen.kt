package com.example.loginauth.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginauth.components.ButtonComponent
import com.example.loginauth.components.HeadingTextComponent
import com.example.loginauth.data.SignUpViewModel

@Composable
fun HomeScreen(signUpViewModel: SignUpViewModel = viewModel()) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            HeadingTextComponent(text = "Home")

            ButtonComponent(
                value = "LogOut",
                onButtonClicked = {
                    signUpViewModel.logOut()
                },
                isEnable = true
            )
        }
    }
}