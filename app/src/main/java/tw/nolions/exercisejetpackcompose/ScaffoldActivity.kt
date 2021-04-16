package tw.nolions.exercisejetpackcompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

lateinit var snackbarHostState: MutableState<SnackbarHostState>
lateinit var coroutineScope: CoroutineScope

fun onClick() {
    coroutineScope.launch {
        snackbarHostState.value.showSnackbar(
            message = "Hey look a snackbar",
            actionLabel = "Hide",
            duration = SnackbarDuration.Long
        )
    }
}

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    snackbarHostState = remember { mutableStateOf(SnackbarHostState()) }
    coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { BuildTopBar() },
        bottomBar = { BuildBottomBar() },
        content = { Content() },
        drawerContent = { Text(text = "drawerContent") },
        drawerBackgroundColor = Color.White,
        drawerContentColor = Color.Red,
        drawerScrimColor = Color.Gray,
        floatingActionButton = { BuildBloatingActionButton(context) },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        snackbarHost = { SnackBar() }
    )
}

@Composable
fun SnackBar() {
    SnackbarHost(
        hostState = snackbarHostState.value,
        snackbar = {
            Snackbar(
                action = {
//                    TextButton(
//                        onClick = { snackbarHostState.value.currentSnackbarData?.dismiss() }
//                    ) {
//                        Text(text = "Hide")
//                    }
                    Text(text = "Hide")
                }, actionOnNewLine = true,

            ) {
                Text("hey look a snackbar")
            }
        }
    )
}

@Composable
fun Content() {
    Column(Modifier.padding(8.dp, 4.dp)) {
        Text("BodyContent")
    }
}

@Composable
fun BuildTopBar() {
    TopAppBar(
        title = { Text("TopAppBar") },
        backgroundColor = Color(0xFF1976D2)
    )
}

@Composable
fun BuildBloatingActionButton(context: Context) {
    FloatingActionButton(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = MaterialTheme.colors.primary,
        onClick = {
            Toast.makeText(context, "test", Toast.LENGTH_LONG).show()
            onClick()
        }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
fun BuildBottomBar() {
    BottomAppBar(
        backgroundColor = Color(0xFF1976D2),
        cutoutShape = RoundedCornerShape(10.dp),
    ) {
        Row(modifier = Modifier.weight(1f)) {
            Box(modifier = Modifier.width(8.dp))
            BuildBottomBarItem(icon = Icons.Default.Home, text = "Home", click = {})

            BuildBottomBarItem(icon = Icons.Default.Favorite, text = "Favorite", click = {})

            Box(modifier = Modifier.weight(1f)) {
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(modifier = Modifier.width(8.dp))
                    BuildBottomBarItem(
                        icon = Icons.Filled.List,
                        text = "List",
                        click = {})
                    BuildBottomBarItem(
                        icon = Icons.Filled.Notifications,
                        text = "Notify",
                        click = {})
                }
            }
        }
    }
}

@Composable
fun BuildBottomBarItem(icon: ImageVector, text: String, click: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .absolutePadding(left = 8.dp, right = 8.dp)
            .width(50.dp)
    ) {
        IconButton(click, modifier = Modifier.size(24.dp)) {
            Icon(
                imageVector = icon, contentDescription = null,
                tint = Color.White
            )
        }
        Text(text = text, color = Color.White)
    }
}

@Preview()
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}