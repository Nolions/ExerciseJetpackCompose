# exerciseJetpackCompose

JetpackCompose Note

- [註解](#註解)
- [Layout](#layout)
- [元素](#元素)
- [修饰符](#修饰符)
- [Other](#Other)
- [Reference](#REFERENCE)

compose version: 1.0.0-alpha08

setContent: 定義Layout佈局

## 註解

| 註解 | 說明 |
| --- | --- |
| @Composable | 定義為可組合函數 |
| @Preview | 允許為即時預覽 |

## Layout

| 函數 | 說明 |
| --- | --- |
| Column | 縱向排列 |
| Row | 橫向排列 |
| Box | 重疊(後面元素疊至前面元素之上) |
| Scaffold | 基于槽位的布 | 
| ConstraintLayout | 約束佈局 |

### Column & Row align

Column

| 函數 | 說明 |
| --- | --- |
| verticalArrangement | 垂直排列 |
| horizontalAlignment | 水平對齊 |

Row

| 函數 | 說明 |
| --- | --- |
| verticalAlignment | 垂直對齊 |
| horizontalArrangement | 水平排列 |

### Scaffold

| 參數 | 說明 |
| --- | --- |
| modifier |  |
| scaffoldState |  |
| topBar | Top Bar |
| bottomBar | Bottom Bar |
| content | body Content |
| contentColor |  |
| snackbarHost |  |
| floatingActionButton | floatingActionButton位置，預設為`FabPosition.End` |
| floatingActionButtonPosition |  |
| isFloatingActionButtonDocked |  |
| drawerContent |  |
| drawerGesturesEnabled | 透過手勢來開關drawer，預設為true |
| drawerShape | drawer樣式 |
| drawerElevation |  |
| drawerBackgroundColor | drawer 背景色 |
| drawerContentColor | drawer文字內容顏色 |
| drawerScrimColor | drawer未覆蓋部分背景色 |
| backgroundColor |  |

### ConstraintLayout

add dependencies of constraintlayout-compose on app build.gradle

    implementation "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha03"

createRefs、createRefFor

constrainAs

linkTo()

parent

> 要設置Layout Align時需要設定layout size(寬高)

## 元素

### Text: TextView

| 參數 | 說明 |
| --- | --- |
| *text | 文字內容 |
| modifier ||
| color | 字體顏色|
| fontSize | 字型大小|
| fontStyle | 字型 |
| fontWeight | 字型寬度 |
| letterSpacing ||
| textDecoration ||
| textAlign | 對齊 |
| overflow | 文字溢出 |
| softWrap ||
| maxLines | 多大行數|
| onTextLayout ||
| style ||

> * 為必要之參數

Select

SelectionContainer: 可以選擇並反白區域、DisableSelection：不可以選擇反白

```
SelectionContainer {
    Column() {
        Text("Number: 1")
        Text("Number: 2")
        DisableSelection {
            Text("TNumber: 3")
            Text("TNumber: 4")
        }
        Text("Number: 5")
        Text("Number: 6")
    }
}
```

click

ClickableText

```
ClickableText(
    text = AnnotatedString("Click Me"),
    onClick = {
        text.value = "text clicked."
    }
)
```

Input&Modify

TextField: EditText

```
var text = remember { mutableStateOf("Hello") }

TextField(
    value = text.value,
    onValueChange = { text = it },
    label = { Text("Label") }
)

Text(text = text.value)
```

TextField: 帶有Border的EditText

```
var text = remember { mutableStateOf("Hello") }

OutlinedTextField(
    value = text.value,
    onValueChange = { text = it },
    label = { Text("Label") }
)

Text(text = text.value)
```

### Button

IconButton: 含有圖片Button

Image: ImageView

| 參數 | 說明 |
| --- | --- |
| *painter |  |
| *contentDescription |  |
| modifier |  |
| alignment |  |
| contentScale |  |
| alpha |  |
| colorFilter |  |

> * 為必要之參數

## Spacer

| 參數 | 說明 |
| --- | --- |
| *modifier | 墊片 |

## List

| 函數 | 說明 |
| --- | --- |
| LazyColumn | 垂直方向列表 |
| LazyRow | 水平方向列表 |

item: List列表下單一項目

items

### LazyListState

取得目前 List位置

rememberLazyListState(): 用來記憶List中狀態，並用以指像List中的`state`

```
    val listState = rememberLazyListState()
    
    LazyColumn(state = listState) {
        Log.d(TAG, "LazyListState: index: ${listState.firstVisibleItemIndex}")
    }
```

移動到指定List指定位置

animateScrollToItem(): 將List移項指定位置

rememberCoroutineScope(): animateScrollToItem()需要CoroutineScope中才能執行

```
val listState = rememberLazyListState()
val coroutineScope = rememberCoroutineScope()

LazyColumn(state = listState) {
    ...
}

Button(
    onClick = {
        coroutineScope.launch {
            listState.animateScrollToItem(index = 0)
        }
    }
) {
    Text(text = "Top")
}
```

rememberLazyListState

rememberCoroutineScope

> item元素中可搭配[Layout](#Layout)，以實現複雜UI Layout

## 修饰符 Modifier

### size 大小寬高

| 函數 | 說明 |
| --- | --- |
| width | 寬度 |
| height | 高度 |
| size |  |
| widthIn |  |
| heightIn |  |
| requiredWidth |  |
| requiredHeight |  |
| requiredSize |  |
| requiredWidthIn |  |
| defaultMinSize |  |
| wrapContentWidth | 根據內容寬度來設定元素寬度 |
| wrapContentHeight | 根據內容寬度來設定元素高度 |
| wrapContentSize | wrapContentWidth + wrapContentHeight |
| fillMaxWidth | 指定寬度與上層Layout一樣 |
| fillMaxHeight | 指定高度與上層Layout一樣 |
| fillMaxSize | fillMaxWidth + fillMaxHeight |

### offer 偏移量

| 函數 | 說明 |
| --- | --- |
| offset |  |
| absoluteOffset |  |

### padding

| 函數 | 說明 |
| --- | --- |
| padding | |
| absolutePadding | |

## Other

Surface

ExercisejetpackComposeTheme

## REFERENCE

1. [Jetpack Compose Basics](https://developer.android.com/jetpack/compose/tutorial)

2. [Jetpack Compose doc](https://developer.android.com/jetpack/compose/documentation)

3. [Jetpack Compose Playground](https://foso.github.io/Jetpack-Compose-Playground/)
