package com.example.loginauth.data


import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.loginauth.data.rules.Validator
import com.example.loginauth.navigation.LoginAuthRouter
import com.example.loginauth.navigation.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener

class SignUpViewModel : ViewModel() {

    var registrationUIState = mutableStateOf(RegistrationUiState())

    var allValidationPass = mutableStateOf(false)

    var signUpInProgress = mutableStateOf(false)
    fun onEvent(event: SignUpUIEvent) {
        validatorWithRule()
        when (event) {
            is SignUpUIEvent.FirstNameChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )
                printState()
            }

            is SignUpUIEvent.LastNameChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName
                )
                printState()
            }

            is SignUpUIEvent.EmailChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
                printState()
            }

            is SignUpUIEvent.PasswordChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
                printState()
            }

            SignUpUIEvent.RegisterButtonClick -> {
                signUp()
            }

            is SignUpUIEvent.PrivacyPolicyCheckBoxClicked -> {
                registrationUIState.value = registrationUIState.value.copy(
                    privacyPolicyAccepted = event.status
                )
            }
        }
    }

    private fun signUp() {
        Log.d(TAG, "SignUp")
        printState()

        createUserInFireBase(
            email = registrationUIState.value.email,
            password = registrationUIState.value.password
        )

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

        val privacyPolicyResult = Validator.validatePrivacyPolicyAcceptance(
            statusValue = registrationUIState.value.privacyPolicyAccepted
        )

        Log.d(TAG, "fNameResult = $fNameResult")
        Log.d(TAG, "lNameResult = $lNameResult")
        Log.d(TAG, "emailResult = $emailResult")
        Log.d(TAG, "passwordResult = $passwordResult")

        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            privacyError = privacyPolicyResult.status
        )

        allValidationPass.value =
            fNameResult.status && lNameResult.status && emailResult.status && passwordResult.status && !privacyPolicyResult.status


    }


    private fun printState() {
        Log.d(TAG, "UIState")
        Log.d(TAG, registrationUIState.value.toString())
    }

    private fun createUserInFireBase(email: String, password: String) {
        signUpInProgress.value = true

        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "Inside_OnCompleteListener")
                Log.d(TAG, "${it.isSuccessful}")

                signUpInProgress.value = false

                if (it.isSuccessful) {
                    LoginAuthRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener {
                Log.d(TAG, "Inside_OnFailureListener")
                Log.d(TAG, "${it.message}")
                signUpInProgress.value = false
            }
    }

    fun logOut() {
        val firebaseAuth = FirebaseAuth.getInstance()

        firebaseAuth.signOut()

        val authStateListener = AuthStateListener {
            if (it.currentUser == null) {
                Log.d(TAG, "Inside sign outSuccess")
                LoginAuthRouter.navigateTo(Screen.LoginScreen)
            } else {
                Log.d(TAG, "Inside signOut is not complete")
            }
        }

        firebaseAuth.addAuthStateListener(authStateListener)
    }
}