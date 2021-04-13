# ModalDrawerLayout

抽屜佈局(螢幕左側滑出): ModalDrawer

## param

| 參數 | 說明 | 型態 |
| --- | --- | --- |
| content | 內容| @Composable lambda｜
| drawerContent | drawerContent | @Composable ColumnScope.() |
| drawerState | ModalDrawer狀態(開啟/關閉) | DrawerState |
| gesturesEnabled | 是否啟用手勢 | Boolean |
| drawerShape | 形狀 | Shape |
| drawerElevation | 陰影 | Dp |
| drawerBackgroundColor | 背景顏色 | Color |
| drawerContentColor | 內容物顏色| Color |
| scrimColor | | Color |
| modifier | 元素修飾符 | Modifier |

## Use

Example1:

```
@Composable
fun BuildModalDrawerLayout() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

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
    Column {
        Text("Text in Bodycontext")
        Button(onClick = {

            scope.launch {
                drawerState.open()
            }

        }) {
            Text("Click to open")
        }
    }
}

```

Example2: 結合TopAppBar

```
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
```
