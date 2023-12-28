package com.example.loginauth.data.rules

object Validator {
    fun validateFirstName(fName : String) : Validate{
        return Validate(
            (!fName.isNullOrEmpty() && fName.length > 2)
        )
    }

    fun validateLastName(lName : String) : Validate{
        return Validate(
        (!lName.isNullOrEmpty() && lName.length > 2)
        )
    }

    fun validateEmail(email : String) : Validate{
        return Validate(
        (!email.isNullOrEmpty())
        )
    }

    fun validatePassword(password : String) : Validate{
        return Validate(
            (!password.isNullOrEmpty() && password.length  >= 4)
        )
    }

    fun validatePrivacyPolicyAcceptance(statusValue: Boolean) : Validate{
        return Validate(
            statusValue
        )
    }
}

data class Validate(
    val status : Boolean = false
)