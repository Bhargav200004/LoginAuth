package com.example.loginauth.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var registrationUIState = mutableStateOf(RegistrationUiState())

    fun onEvent(event: UIEvent) {
        when (event) {
            is UIEvent.FirstNameChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )
                printState()
            }

            is UIEvent.LastNameChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName
                )
                printState()
            }

            is UIEvent.EmailChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
                printState()
            }

            is UIEvent.PasswordChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
                printState()
            }

            UIEvent.RegisterButtonClick -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        Log.d(TAG, "SignUp")
        printState()
    }

    private fun printState() {
        Log.d(TAG, "UIState")
        Log.d(TAG, registrationUIState.value.toString())
        }
    }

    private fun printState() {
        Log.d("TAG", "UIState")
        Log.d("TAG", registrationUIState.value.toString()
    }

}