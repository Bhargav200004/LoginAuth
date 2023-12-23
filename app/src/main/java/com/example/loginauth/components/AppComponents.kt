package com.example.loginauth.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NormalTextComponent(
    text : String
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        text = text,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun HeadingTextComponent(
    text : String
) {
    Text(
        modifier = Modifier
            .fillMaxWidth(),
        text = text,
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun MyTextField(label: String, accountBox: ImageVector) {
    
    var textValue by remember { mutableStateOf("") }
    
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        value = textValue,
        onValueChange = { textValue = it },
        label = { Text(text =  label)},
        leadingIcon = {
            Icon(imageVector = accountBox, contentDescription = "")
        }
    )
}

@Composable
fun PassWordTextField(label: String, accountBox: ImageVector) {

    var passWord by remember { mutableStateOf("") }

    var passWordVisible by remember { mutableStateOf(false)}

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        value = passWord,
        onValueChange = { passWord = it },
        label = { Text(text =  label)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            Icon(
                imageVector = accountBox,
                contentDescription = ""
            )
        },
        trailingIcon = {
            IconButton(onClick = { passWordVisible = !passWordVisible }) {
                if (passWordVisible) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = ""
                    )
                }
                else{
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = ""
                    )
                }
            }
        },
        visualTransformation = if (passWordVisible) VisualTransformation.None
                                else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(value : String) {

    var checkedState by remember { mutableStateOf(false)}

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(
            checked = checkedState,
            onCheckedChange ={
                checkedState = !checkedState
            }
        )


    }
}


@Composable
fun ClickableTextComponent() {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = "and"
    val termsAndConditionsText = "Term of use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)){
            pushStringAnnotation(tag = privacyPolicyText , annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)){
            pushStringAnnotation(tag = termsAndConditionsText , annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }
    }

    ClickableText(text =annotatedString , onClick = {offset ->

    })
}
































