package com.example.loginauth.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


sealed class Screen(){

    data object SignUpScreen : Screen()

    data object TermAndConditionScreen : Screen()

    data object LoginScreen : Screen()

    data object HomeScreen : Screen()

}


object LoginAuthRouter {

    var currentScreen : MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigateTo(destination : Screen){
        currentScreen.value = destination
    }

}