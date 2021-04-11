# DropdownMenu

## DropdownMenu

下拉示選單

### param

| 函數 | 說明 | Type|
| --- | --- | --- |
| expanded | 選單是否顯示 | Boolean |
| onDismissRequest | 選單關閉後的行為 | lambda |
| offset | Menu選單偏移量 | DpOffset，default:DpOffset(0.dp, 0.dp) |
| properties | | PopupProperties |
| content | | lambda |
| modifier | 元素修饰符 | Modifier |

## DropdownMenuItem

menu選單下項目

### param

| 函數 | 說明 | Type|
| --- | --- | --- |
| onClick | 點擊後的行為 | lambda |
| enabled | 是否啟用 | Boolean，default:true |
| contentPadding | | PaddingValues |
| interactionSource | | MutableInteractionSource |
| content | | lambda |
| modifier | 元素修饰符 | Modifier |

## use

```
val showMenu = remember { mutableStateOf(false) }

DropdownMenu(
        expanded = showMenu.value,
        onDismissRequest = {
            showMenu.value = false
            Log.d(TAG, "DropdownMenu: onDismissRequest")
        }) {
        DropdownMenuItem(onClick = {
            alert.value = "Refresh"
        }) {
            Icon(Icons.Filled.Refresh, contentDescription = null)
            Text(text = "Refresh")
        }

        DropdownMenuItem(onClick = {}) {
            Icon(Icons.Filled.Call, contentDescription = null)
            Text(text = "Call")
        }
    })
```
