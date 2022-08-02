package com.example.groceriesapp.composable.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.window.PopupProperties
import com.example.groceriesapp.R
import com.example.groceriesapp.ui.theme.textFieldTextStyle
import kotlin.math.exp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GrocerySpinner(
    items: List<String> = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5"),
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItemText by remember { mutableStateOf(items[0]) }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BasicTextField(
                value = selectedItemText,
                onValueChange = { },
                decorationBox = { innerTextField ->
                    TextFieldDefaults.TextFieldDecorationBox(
                        value = selectedItemText,
                        innerTextField = { innerTextField() },
                        enabled = true,
                        singleLine = true,
                        visualTransformation = VisualTransformation.None,
                        interactionSource = MutableInteractionSource(),
                        contentPadding = PaddingValues(0.dp),
                    )
                },
                textStyle = textFieldTextStyle,
                cursorBrush = SolidColor(Color(0xFF7C7C7C)),
                singleLine = true,
                readOnly = true,
                modifier = Modifier
                    .weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_navigation_arrow),
                contentDescription = null,
                tint = Color(0xFF7C7C7C),
                modifier = Modifier
                    .size(7.dp, 13.dp)
                    .rotate(if (expanded) 270f else 450f)
                    .clickable {
                        expanded = !expanded
                        Log.d("expanded", expanded.toString())
                    }
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            items.forEach {
                DropdownMenuItem(
                    onClick = {
                        selectedItemText = it
                        expanded = false
                    }
                ) {
                    Text(text = it)
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            color = Color(0xFFE2E2E2),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GrocerySpinnerPreview() {
    GrocerySpinner(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}