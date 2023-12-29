package com.example.loginauth.data

sealed class SignUpUIEvent {

    data class FirstNameChange(val firstName : String) : SignUpUIEvent()

    data class LastNameChange(val lastName : String) : SignUpUIEvent()

    data class EmailChange(val email : String) : SignUpUIEvent()

    data class PasswordChange(val password : String) : SignUpUIEvent()
    
    data object RegisterButtonClick : SignUpUIEvent()

    data class PrivacyPolicyCheckBoxClicked(val status : Boolean) : SignUpUIEvent()
}