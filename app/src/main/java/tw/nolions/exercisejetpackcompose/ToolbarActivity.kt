package tw.nolions.exercisejetpackcompose

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
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

        LinearProgress()
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

@Composable
private fun LinearProgress() {
    var progress = remember { mutableStateOf(0f) }
    val animatedProgress = animateFloatAsState(
        targetValue = progress.value,
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
                if (progress.value > 0f) progress.value -= 0.1f
            }
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null
            )
        }

        LinearProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier.padding(10.dp, 20.dp)
        )

        OutlinedButton(
            onClick = {
                if (progress.value < 1f) progress.value += 0.1f
            }
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }

    Spacer(Modifier.height(30.dp))

    Text(
        text = "${progress.value.toString()}%",
        modifier = Modifier.padding(10.dp, 0.dp)
    )
}

fun alert(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    Toolbar()
}