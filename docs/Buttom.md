# Button

## param

| 函數 | 說明 | Type|
| --- | --- | --- |
| onClick | 點擊後的行為 | lambda，default:null |
| enabled | 啟用 | Boolean，default:true |
| border | 邊框  | BorderStroke，default:null |
| interactionSource |  | MutableInteractionSource |
| shape | 倒角樣式 | Shape |
| colors | 背景＆內文顏色 | ButtonColors |
| contentPadding | Padding | PaddingValues |
| elevation | 陰影高度 | ButtonElevation |
| content |  | @Composable lambda | 
| modifier | 元素修饰符 | Modifier |

## use

```
Button(
    onClick = {
        coroutineScope.launch { /* Todo */ }
    }
) {
    Text(text = "Top")
}
```

## Icon

IconButton: 含有圖片Button

```
IconButton(onClick = { /*TODO*/ }) {
    Icon(
        imageVector = Icons.Default.Home,
        contentDescription = null
    )
}
```

## Floating Action Button

### FloatingActionButton

#### param

| 函數 | 說明 | Type|
| --- | --- | --- |
| onClick | 點擊後的行為 | lambda，default:null |
| interactionSource |  | MutableInteractionSource |
| shape | 形狀 | Shape |
| backgroundColor | 背景顏色 | Color |
| contentColor | 內容物(EX: Text, Icon)顏色 | Color |
| elevation | 陰影 | FloatingActionButtonElevation |
| content |  | @Composable lambda | 
| modifier | 元素修饰符 | Modifier |

### ExtendedFloatingActionButton

#### param

| 函數 | 說明 | Type|
| --- | --- | --- |
| text | 文字內容 | lambda |
| icon | Icon | lambda |
| onClick | 點擊後的行為 | lambda，default:null |
| interactionSource |  | MutableInteractionSource |
| shape | 形狀 | Shape |
| backgroundColor | 背景顏色 | Color |
| contentColor | 內容物(EX: Text, Icon)顏色 | Color |
| elevation | 陰影 | ButtonElevation |
| modifier | 元素修饰符 | Modifier |

### Use

```
FloatingActionButton(onClick = { /*TODO*/ }) {
    Icon(
        imageVector = Icons.Default.Clear,
        contentDescription = null
    )
}

FloatingActionButton(onClick = { /*TODO*/ }) {
    Text(text = "Clear")
}

ExtendedFloatingActionButton(
    icon = { Icon(Icons.Filled.Favorite, "") },
    text = { Text("Clear") },
    onClick = { /*do something*/ },
    elevation = FloatingActionButtonDefaults.elevation(20.dp)
)
```

## Switch Button