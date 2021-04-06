package tw.nolions.exercisejetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("TopAppBar") },
                backgroundColor = Color(0xFF1976D2)
            )
        },
        bottomBar = {
            BottomBar()
        },
        content = { Content() },
        drawerContent = { Text(text = "drawerContent") },
        drawerBackgroundColor = Color.White,
        drawerContentColor = Color.Red,
        drawerScrimColor = Color.Gray,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Toast.makeText(context, "test", Toast.LENGTH_LONG).show()
            }) {
                Text("X")
            }
        },
    )
}

@Composable
fun Content() {
    Column(Modifier.padding(8.dp, 4.dp)) {
        Text("BodyContent")
    }
}

@Composable
fun BottomBar() {
    BottomAppBar(backgroundColor = Color(0xFF1976D2)) { Text("BottomAppBar") }
}

@Preview()
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}