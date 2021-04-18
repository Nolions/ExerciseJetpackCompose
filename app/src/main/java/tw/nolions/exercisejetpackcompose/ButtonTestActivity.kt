package tw.nolions.exercisejetpackcompose

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val TAG = "ButtonTest"

class ButtonTestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Button()
        }
    }
}

lateinit var openDialog: MutableState<Boolean>

@Composable
fun Button() {
    val iconBtnModifier = Modifier.width(90.dp)
    val text = remember { mutableStateOf("") }
    val context = LocalContext.current
    openDialog = remember { mutableStateOf(false)  }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.weight(1f)) {
                Button(
                    onClick = { text.value = "btn clicked." },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                        contentColor = Color.Red,
                    ),
                    enabled = true,
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "Btn")
                }
            }

            Box(modifier = Modifier.weight(2f)) {
                ClickableText(
                    text = AnnotatedString("Click Me"),
                    modifier = Modifier.padding(10.dp),
                    onClick = {
                        text.value = "text clicked."
                    }
                )
            }

            val checkedState = remember { mutableStateOf(true) }
            Switch(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                modifier = Modifier.size(30.dp, 10.dp),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Blue,
                    checkedTrackColor = Color.Gray,
                    uncheckedThumbColor = Color.Magenta,
                    uncheckedTrackColor = Color.Transparent
                )
            )

            Text(text = checkedState.value.toString())
        }

        Spacer(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = MaterialTheme.shapes.small
            ) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = null
                )
            }

            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = MaterialTheme.shapes.medium,
            ) {
                Text("Clear")
            }

            ExtendedFloatingActionButton(
                icon = { Icon(Icons.Filled.Favorite, "") },
                text = { Text("Clear") },
                onClick = { openDialog.value = true },
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                shape = MaterialTheme.shapes.large,
            )
        }

        Spacer(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconBtn(Icons.Filled.Favorite, iconBtnModifier, Color.Black) {
                text.value = "Favorite clicked."
                toastAlert(context, text.value)
            }

            IconBtn(Icons.Filled.Lock, iconBtnModifier, Color.Red) {
                text.value = "Lock clicked."
                toastAlert(context, text.value)
            }

            IconBtn(Icons.Filled.Refresh, iconBtnModifier, Color.Blue) {
                text.value = "Refresh clicked."
                toastAlert(context, text.value)
            }

            IconBtn(Icons.Filled.Search, iconBtnModifier, Color.Green) {
                text.value = "Search clicked."
                toastAlert(context, text.value)
            }
        }

        Spacer(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        )

        Text(
            text = text.value,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        )

        RadioButtonDemo()

        CheckBoxDemo()

        Dialog()
    }
}

@Composable
fun Dialog() {
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            text = {  Text(text = "Dialog Content") },
            title = {
                Text(text = "Dialog Title")
            },
            shape = RoundedCornerShape(20.dp),
            confirmButton = {
                Button(
                    onClick = { openDialog.value = false }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                Button(
                    onClick = { openDialog.value = false }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun RadioButtonDemo() {
    val radioOptions = listOf("A", "B", "C")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    Column {
        Row {
            radioOptions.forEach { text ->
                Row(
                    Modifier
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = {
                                onOptionSelected(text)
                            }
                        )
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Cyan,
                            unselectedColor = Color.Magenta
                        )
                    )

                    Text(
                        text = text,
                        style = MaterialTheme.typography.body1.merge(),
                        modifier = Modifier.padding(start = 4.dp, end = 8.dp)
                    )
                }

            }
        }

        Text(
            text = selectedOption
        )
    }
}

@Composable
fun CheckBoxDemo() {
    val checkOptions = listOf("A", "B", "C")
    val checked = ArrayList<Boolean>()
    checked.add(false)
    checked.add(false)
    checked.add(false)

    val optionsChecked = remember { mutableStateOf(checked) }

    Column {
        Row {
            checkOptions.forEachIndexed { index, text ->
                val checkedState = remember { mutableStateOf(optionsChecked.value[index]) }
                Row(
                    Modifier
                        .selectable(
                            selected = checkedState.value,
                            onClick = {
                                checkedState.value = !checkedState.value
                                optionsChecked.value[index] = checkedState.value
                            }
                        )
                ) {
                    Checkbox(
                        checked = checkedState.value,
                        onCheckedChange = {
                            checkedState.value = it
                            optionsChecked.value[index] = it
                        },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color.White,
                            checkedColor = Color.Red,
                            uncheckedColor = Color.Blue,
                        )
                    )

                    Text(
                        text = text,
                        style = MaterialTheme.typography.body1.merge(),
                        modifier = Modifier.padding(start = 4.dp, end = 8.dp)
                    )
                }
            }
        }

        Text(
            text = "Checked:${optionsChecked.value.toString()}"
        )
    }
}

fun toastAlert(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

@Composable
private fun IconBtn(icon: ImageVector, modifier: Modifier, color: Color, f: () -> Unit) {
    IconButton(
        onClick = { f.invoke() },
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Button()
}
