package com.example.loginauth.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginauth.components.ButtonComponent
import com.example.loginauth.components.CheckBoxComponent
import com.example.loginauth.components.ClickableLoginTextComponent
import com.example.loginauth.components.DividerComponent
import com.example.loginauth.components.HeadingTextComponent
import com.example.loginauth.components.MyTextField
import com.example.loginauth.components.NormalTextComponent
import com.example.loginauth.components.PassWordTextField
import com.example.loginauth.data.SignUpViewModel
import com.example.loginauth.data.SignUpUIEvent
import com.example.loginauth.navigation.LoginAuthRouter
import com.example.loginauth.navigation.Screen

@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel = viewModel()) {

    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                NormalTextComponent(text = "Hey there,")
                HeadingTextComponent(text = "Create an Account")
                Spacer(modifier = Modifier.height(20.dp))
                MyTextField(
                    label = "First Name",
                    accountBox = Icons.Outlined.AccountBox,
                    onTextChange = {
                        signUpViewModel.onEvent(SignUpUIEvent.FirstNameChange(firstName = it))
                    },
                    errorState = signUpViewModel.registrationUIState.value.firstNameError
                )
                Spacer(modifier = Modifier.height(10.dp))
                MyTextField(
                    label = "Last Name",
                    accountBox = Icons.Outlined.AccountBox,
                    onTextChange = {
                        signUpViewModel.onEvent(SignUpUIEvent.LastNameChange(lastName = it))
                    },
                    errorState = signUpViewModel.registrationUIState.value.lastNameError
                )
                Spacer(modifier = Modifier.height(10.dp))
                MyTextField(
                    label = "Email",
                    accountBox = Icons.Outlined.Email,
                    onTextChange = {
                        signUpViewModel.onEvent(SignUpUIEvent.EmailChange(email = it))
                    },
                    errorState = signUpViewModel.registrationUIState.value.emailError
                )
                Spacer(modifier = Modifier.height(10.dp))
                PassWordTextField(
                    label = "Password",
                    accountBox = Icons.Outlined.Lock,
                    onTextChange = {
                        signUpViewModel.onEvent(SignUpUIEvent.PasswordChange(password = it))
                    },
                    errorState = signUpViewModel.registrationUIState.value.passwordError
                )
                Spacer(modifier = Modifier.height(10.dp))
                CheckBoxComponent(
                    value = "", onTextSelected = {
                        LoginAuthRouter.navigateTo(Screen.TermAndConditionScreen)
                    },
                    onCheckChange = {
                        signUpViewModel.onEvent(SignUpUIEvent.PrivacyPolicyCheckBoxClicked(it))
                    }
                )
                Spacer(modifier = Modifier.height(30.dp))
                ButtonComponent(
                    value = "Registration",
                    onButtonClicked = {
                        signUpViewModel.onEvent(SignUpUIEvent.RegisterButtonClick)
                    },
                    isEnable = signUpViewModel.allValidationPass.value
                )
                Spacer(modifier = Modifier.height(20.dp))
                DividerComponent()
                ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                    LoginAuthRouter.navigateTo(Screen.LoginScreen)
                })
            }

        }

        if (signUpViewModel.signUpInProgress.value) {
            CircularProgressIndicator()
        }
    }
}
