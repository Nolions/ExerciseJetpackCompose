# Snackbar

## layout

-------------------
| conten | action |
---------|---------

SnackbarHost

## param

***SnackbarHost***

| 函數 | 說明 | Type|
| --- | --- | --- |
| hostState | Snackbar狀態| SnackbarHostState |
| snackbar | Snackbar | Composable lambda |
| modifier | 元素修饰符 | Modifier |

***Snackbar***

| 函數 | 說明 | Type|
| --- | --- | --- |
| action | Snackbar action 內容| Composable lambda |
| actionOnNewLine | Snackbar action是否顯示在新的一行 | Boolean |
| shape | 形狀 | Composable lambda |
| backgroundColor | 背景顏色 | Color |
| contentColor | 內容物顏色 | Color |
| elevation | 背景顏色 | DB |
| modifier | 元素修饰符 | Modifier |


## Use

```
val snackbarHostState = remember { mutableStateOf(SnackbarHostState()) }
val coroutineScope = rememberCoroutineScope()

coroutineScope.launch {
    snackbarHostState.value.showSnackbar(
        message = "Hey look a snackbar",
        actionLabel = "Hide",
        duration = SnackbarDuration.Long
    )
}

SnackbarHost(
    hostState = snackbarHostState.value,
    snackbar = {
        Snackbar(
            action = {
                TextButton(onClick = { snackbarHostState.value.currentSnackbarData?.dismiss() }
            ) {
                Text(text = "Hide")
            }
        }) {
           Text("hey look a snackbar")
        }
    }
)
```

## Other

不使用SnackbarHost，指使用Snackbar

### Use

```
val snackbarVisibleState = remember { mutableStateOf(false) }

Button(onClick = { snackbarVisibleState.value = !snackbarVisibleState.value }) {
    if (snackbarVisibleState.value) {
        Text("Hide Snackbar")
    } else {
        Text("Show Snackbar")
    }
}

if (snackbarVisibleState.value) {
    Snackbar(
        action = {
            Button(onClick = {}) {
                Text("MyAction")
            }
        },
        modifier = Modifier.padding(8.dp)
    ) { Text(text = "This is a snackbar!") }
}
```