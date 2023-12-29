package com.example.loginauth.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.loginauth.navigation.LoginAuthRouter
import com.example.loginauth.navigation.Screen
import com.example.loginauth.screen.HomeScreen
import com.example.loginauth.screen.LoginScreen
import com.example.loginauth.screen.SignUpScreen
import com.example.loginauth.screen.TermsAndConditionScreen

@Composable
fun LoginAuthApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Crossfade(targetState = LoginAuthRouter.currentScreen, label = "") { currentScreen ->
            when(currentScreen.value){
                Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                Screen.TermAndConditionScreen -> {
                    TermsAndConditionScreen()
                }

                Screen.LoginScreen -> {
                    LoginScreen()
                }

                Screen.HomeScreen -> {
                    HomeScreen()
                }
            }

        }
    }
}