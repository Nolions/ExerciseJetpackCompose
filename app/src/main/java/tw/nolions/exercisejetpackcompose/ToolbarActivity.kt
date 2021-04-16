package tw.nolions.exercisejetpackcompose

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

class ToolbarActivity : ComponentActivity() {
    val TAG = "ToolbarActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Toolbar()
        }
    }
}

@Composable
fun Toolbar() {
    Column {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                }
            },
            title = {
                Text(
                    text = stringResource(R.string.app_name),
                )
            },
            actions = { ActionMenu() },
            backgroundColor = Color.Green,
            contentColor = Color.White,
            elevation = 0.dp
        )

        Spacer(Modifier.height(30.dp))

        progress()

        Card(
            border = BorderStroke(10.dp, Color.Red),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(R.drawable.power),
                    contentDescription = null,
                    modifier = Modifier
                        .height(180.dp)
                        .width(180.dp),
                    contentScale = ContentScale.Crop
                )

                Text(
                    buildAnnotatedString {
                        append("welcome to ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.W900,
                                color = Color(0xFF4552B8)
                            )
                        ) {
                            append("Jetpack Compose Playground")
                        }
                    }
                )
            }
        }
    }
}

lateinit var sliderPosition: MutableState<Float>

@Composable
fun progress() {
    sliderPosition = remember { mutableStateOf(0f) }
    LinearProgress()
    Slider()

    Text(text = sliderPosition.value.toInt().toString())
}

@Composable
private fun Slider() {
    Slider(
        value = sliderPosition.value,
        onValueChange = {
            sliderPosition.value = it
        },
        valueRange = 0F..10F,
        steps = 10,
        colors = SliderDefaults.colors()
    )
}

@Composable
private fun LinearProgress() {
    val animatedProgress = animateFloatAsState(
        targetValue = sliderPosition.value / 10,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    LinearProgressIndicator(
        modifier = Modifier.padding(8.dp),
        color = Color.Green,
        backgroundColor = Color.Red
    )

    Row(modifier = Modifier.padding(10.dp, 0.dp)) {
        OutlinedButton(
            onClick = {
                if (sliderPosition.value > 0f) sliderPosition.value -= 0.1f * 10
            }
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null
            )
        }

        LinearProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier.padding(10.dp, 20.dp),
        )

        OutlinedButton(
            onClick = {
                if (sliderPosition.value < 1f) sliderPosition.value += 0.1f * 10
            }
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun ActionMenu() {
    val showMenu = remember { mutableStateOf(false) }

    IconButton(onClick = { showMenu.value = true }) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null
        )
    }
    DropdownMenu(
        expanded = showMenu.value,
        onDismissRequest = {
            showMenu.value = false
            Log.d(TAG, "DropdownMenu: onDismissRequest")
        },
        offset = DpOffset(0.dp, 0.dp)
    ) {
        DropdownMenuItems()
    }
}

@Composable
private fun DropdownMenuItems() {
    val alert = remember { mutableStateOf("") }
    val context = LocalContext.current

    DropdownMenuItem(
        onClick = {
            alert.value = "Refresh"
            alert(context, alert.value)
        },
        modifier = Modifier.width(150.dp)
    ) {
        Icon(Icons.Filled.Refresh, contentDescription = null)
        Text(text = "Refresh")
    }

    DropdownMenuItem(
        onClick = {
            alert.value = "Call"
            alert(context, alert.value)
        },
        enabled = false
    ) {
        Icon(Icons.Filled.Call, contentDescription = null)
        Text(text = "Call")
    }

    DropdownMenuItem(onClick = {
        alert.value = "ThumbUp"
        alert(context, alert.value)
    }) {
        Icon(Icons.Filled.ThumbUp, contentDescription = null)
        Text(text = "ThumbUp")
    }

    DropdownMenuItem(onClick = {
        alert.value = "ExitToApp"
        alert(context, alert.value)
    }) {
        Icon(Icons.Filled.ExitToApp, contentDescription = null)
        Text(text = "ExitToApp")
    }
}

fun alert(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    Toolbar()
}