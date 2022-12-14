package com.example.groceriesapp.composable.component

import android.content.Intent.getIntent
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.groceriesapp.R
import com.example.groceriesapp.ui.theme.textFieldTextStyle


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GroceryTextField(
    icon: Int? = null,
    value: String,
    onValueChange: (String) -> Unit,
    startValue: String? = "+880",
    modifier: Modifier = Modifier.fillMaxWidth(),
    isPassword: Boolean = false,
    focusRequester: FocusRequester? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions()
) {
    val focusManager = LocalFocusManager.current
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon is Int) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "country flag",
                    modifier = Modifier.size(34.dp, 24.dp),
                )
                Spacer(modifier = Modifier.width(12.dp))
                if (startValue is String) {
                    Text(
                        text = startValue,
                        style = textFieldTextStyle
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                }
            }
            BasicTextField(
                value = value,
                onValueChange = { onValueChange(it) },
                decorationBox = { innerTextField ->
                    TextFieldDefaults.TextFieldDecorationBox(
                        value = value,
                        innerTextField = { innerTextField() },
                        enabled = true,
                        singleLine = true,
                        visualTransformation = if (isPassword) PasswordVisualTransformation()
                        else VisualTransformation.None,
                        interactionSource = MutableInteractionSource(),
                        contentPadding = PaddingValues(0.dp)
                    )
                },
                textStyle = textFieldTextStyle,
                cursorBrush = SolidColor(Color(0xFF7C7C7C)),
                modifier = if (focusRequester is FocusRequester) Modifier
                    .weight(1f)
                    .focusRequester(focusRequester)
                else Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }),
                keyboardOptions = keyboardOptions,
                visualTransformation = if (isPassword) PasswordVisualTransformation()
                else VisualTransformation.None
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFE2E2E2)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GroceryTextFieldPreview() {
    var value by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        GroceryTextField(
            value = value,
            onValueChange = {
                value = it
            },
            icon = R.drawable.phone_country_image,
            modifier = Modifier.fillMaxWidth()
        )
    }
}