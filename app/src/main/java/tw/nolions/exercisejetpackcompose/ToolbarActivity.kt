package tw.nolions.exercisejetpackcompose

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties

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
        actions = { ActionMenu() }
    )
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