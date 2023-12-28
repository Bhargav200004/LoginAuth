package com.example.loginauth.data


import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.loginauth.data.rules.Validator

class LoginViewModel : ViewModel() {

    var registrationUIState = mutableStateOf(RegistrationUiState())

    fun onEvent(event: UIEvent) {
        validatorWithRule()
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

        validatorWithRule()
    }

    private fun validatorWithRule() {
        val fNameResult = Validator.validateFirstName(
            fName = registrationUIState.value.firstName
        )

        val lNameResult = Validator.validateLastName(
            lName = registrationUIState.value.lastName
        )

        val emailResult = Validator.validateEmail(
            email = registrationUIState.value.email
        )

        val passwordResult = Validator.validatePassword(
            password = registrationUIState.value.password
        )

        Log.d(TAG, "fNameResult = $fNameResult")
        Log.d(TAG, "lNameResult = $lNameResult")
        Log.d(TAG, "emailResult = $emailResult")
        Log.d(TAG, "passwordResult = $passwordResult")

        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status ,
            emailError = emailResult.status ,
            passwordError = passwordResult.status
        )


    }


    private fun printState() {
        Log.d(TAG, "UIState")
        Log.d(TAG, registrationUIState.value.toString ())
    }
}