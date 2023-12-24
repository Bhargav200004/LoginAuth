package com.example.loginauth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.loginauth.app.LoginAuthApp
import com.example.loginauth.ui.theme.LoginAuthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAuthTheme {
                // A surface container using the 'background' color from the theme
                LoginAuthApp()
            }
        }
    }
}
