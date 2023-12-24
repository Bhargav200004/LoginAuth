package com.example.loginauth.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.loginauth.components.ButtonComponent
import com.example.loginauth.components.CheckBoxComponent
import com.example.loginauth.components.ClickableLoginTextComponent
import com.example.loginauth.components.DividerComponent
import com.example.loginauth.components.HeadingTextComponent
import com.example.loginauth.components.MyTextField
import com.example.loginauth.components.NormalTextComponent
import com.example.loginauth.components.PassWordTextField
import com.example.loginauth.navigation.LoginAuthRouter
import com.example.loginauth.navigation.Screen

@Composable
fun SignUpScreen() {
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
            MyTextField(label = "First Name" , accountBox = Icons.Outlined.AccountBox)
            Spacer(modifier = Modifier.height(10.dp))
            MyTextField(label = "Last Name", accountBox = Icons.Outlined.AccountBox)
            Spacer(modifier = Modifier.height(10.dp))
            MyTextField(label = "Email", accountBox = Icons.Outlined.Email)
            Spacer(modifier = Modifier.height(10.dp))
            PassWordTextField(label = "Password", accountBox = Icons.Outlined.Lock)
            Spacer(modifier = Modifier.height(10.dp))
            CheckBoxComponent(value = "" , onTextSelected = {
                LoginAuthRouter.navigateTo(Screen.TermAndConditionScreen)
            })
            Spacer(modifier = Modifier.height(30.dp))
            ButtonComponent(value = "Registration")
            Spacer(modifier = Modifier.height(20.dp))
            DividerComponent()
            ClickableLoginTextComponent(value = "", onTextSelected = {

            })
        }
        
    }
}
