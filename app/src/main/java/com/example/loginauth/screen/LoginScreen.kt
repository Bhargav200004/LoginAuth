package com.example.loginauth.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.loginauth.components.ButtonComponent
import com.example.loginauth.components.ClickableLoginTextComponent
import com.example.loginauth.components.DividerComponent
import com.example.loginauth.components.HeadingTextComponent
import com.example.loginauth.components.MyTextField
import com.example.loginauth.components.NormalTextComponent
import com.example.loginauth.components.PassWordTextField
import com.example.loginauth.components.UnderLineTextComponent
import com.example.loginauth.navigation.LoginAuthRouter
import com.example.loginauth.navigation.Screen
import com.example.loginauth.navigation.SystemBAckButtonHandler


@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            NormalTextComponent(text = "Hey There ,")
            HeadingTextComponent(text = "Welcome back")
            Spacer(modifier = Modifier.height(40.dp))
            MyTextField(
                label = "Email",
                accountBox = Icons.Outlined.Email,
                onTextChange = {

                }
            )
            Spacer(modifier = Modifier.height(15.dp))
            PassWordTextField(
                label = "Password",
                accountBox = Icons.Outlined.Lock,
                onTextChange = {

                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            UnderLineTextComponent(text = "Forget Password")
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(
                value = "Login",
                onButtonClicked = {

                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            DividerComponent()
            ClickableLoginTextComponent(tryingToLogin = false ,onTextSelected = {
                LoginAuthRouter.navigateTo(Screen.SignUpScreen)
            })

        }
    }

    SystemBAckButtonHandler {
        LoginAuthRouter.navigateTo(Screen.SignUpScreen)
    }
}