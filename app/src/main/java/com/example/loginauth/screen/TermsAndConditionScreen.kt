package com.example.loginauth.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.loginauth.components.HeadingTextComponent
import com.example.loginauth.navigation.LoginAuthRouter
import com.example.loginauth.navigation.Screen
import com.example.loginauth.navigation.SystemBAckButtonHandler


@Composable
fun TermsAndConditionScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {
        HeadingTextComponent(text = "Terms Of use")
    }

    SystemBAckButtonHandler {
        LoginAuthRouter.navigateTo(Screen.SignUpScreen)
    }
}