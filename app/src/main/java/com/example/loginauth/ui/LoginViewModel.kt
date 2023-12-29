package com.example.loginauth.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.loginauth.data.LoginUIEvent
import com.example.loginauth.data.LoginUiState
import com.example.loginauth.data.rules.Validator
import com.example.loginauth.navigation.LoginAuthRouter
import com.example.loginauth.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {

    var loginUIState = mutableStateOf(LoginUiState())

    var allValidationsPassed = mutableStateOf(false )

//    var loginInProgress = mutableStateOf(false)

    fun onEvent(event : LoginUIEvent){
        validLoginUIDataWithRule()
         when(event){
            is LoginUIEvent.EmailChange -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }
             is LoginUIEvent.PasswordChange -> {
                 loginUIState.value = loginUIState.value.copy(
                     password = event.password
                 )
             }
             LoginUIEvent.LoginButtonClicked -> {
                 login()
             }
        }
    }

    private fun login() {

        val email = loginUIState.value.email
        val password = loginUIState.value.password

        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                Log.d("success", "login: ${it.isSuccessful}")

                if (it.isSuccessful){
                    LoginAuthRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener{
                Log.d("success", "login: ${it.message}")
            }

    }

    private fun validLoginUIDataWithRule(){
        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )

        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )

        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationsPassed.value = emailResult.status && passwordResult.status
    }
}