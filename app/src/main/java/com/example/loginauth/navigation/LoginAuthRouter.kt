package com.example.loginauth.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


sealed class Screen(){

    object SignUpScreen : Screen()

    object TermAndConditionScreen : Screen()

}


object LoginAuthRouter {

    var currentScreen : MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigateTo(destination : Screen){
        currentScreen.value = destination
    }

}