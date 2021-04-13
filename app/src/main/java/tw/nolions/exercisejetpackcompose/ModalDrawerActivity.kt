package tw.nolions.exercisejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import tw.nolions.exercisejetpackcompose.ui.theme.ExercisejetpackComposeTheme

class ModalDrawerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuildModalDrawerLayout()
        }
    }
}

@Composable
fun BuildModalDrawerLayout() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val icon = remember { mutableStateOf(Icons.Default.Menu) }

    Column {
        BuildAppTopBar(drawerState, scope, icon)
        BuildModalDrawer(drawerState, scope)
    }

    setTopBatIcon(drawerState, icon)
}

private fun setTopBatIcon(
    drawerState: DrawerState,
    icon: MutableState<ImageVector>
) {
    if (drawerState.currentValue == DrawerValue.Closed) icon.value = Icons.Default.Menu
    else icon.value = Icons.Default.Clear
}

@Composable
fun BuildAppTopBar(
    drawerState: DrawerState,
    scope: CoroutineScope,
    icon: MutableState<ImageVector>
) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    if (drawerState.isClosed) {
                        drawerState.open()
                        icon.value = Icons.Default.Clear
                    } else {
                        drawerState.close()
                        icon.value = Icons.Default.Menu
                    }
                }
            }) {
                Icon(
                    imageVector = icon.value,
                    contentDescription = null
                )
            }
        },
        title = {
            Text(
                text = stringResource(R.string.app_name),
            )
        },
        elevation = 10.dp
    )
}

@Composable
fun BuildModalDrawer(
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            BuildDrawerContent(drawerState, scope)
        },
        content = { BuildContent(drawerState, scope) }
    )
}

@Composable
fun BuildDrawerContent(drawerState: DrawerState, scope: CoroutineScope) {
    Column {
        Text("Text in Drawer")
        Button(onClick = {
            scope.launch {
                drawerState.close()
            }
        }) {
            Text("Close Drawer")
        }
    }
}

@Composable
fun BuildContent(drawerState: DrawerState, scope: CoroutineScope) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Text in Bodycontext", fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ExercisejetpackComposeTheme {
        BuildModalDrawerLayout()
    }
}