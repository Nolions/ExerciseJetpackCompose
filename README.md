# exerciseJetpackCompose

JetpackCompose Note

- [註解](#註解)
- [Layout](#layout)
- [元素](#元素)
- [修饰符](#修饰符)

compose version: 1.0.0-alpha08

setContent: 定義Layout佈局

Surface

ExercisejetpackComposeTheme

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
| ConstraintLayout | 約束佈局 |
| Scaffold | 基于槽位的布 | 

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


> 要設置Layout Align時需要設定layout size(寬高)

## 元素

Text: TextView

| 參數 | 說明 |
| --- | --- |
| *text | 文字內容 |
| modifier ||
| color ||
| fontSize ||
| fontStyle ||
| fontWeight ||
| letterSpacing ||
| textDecoration ||
| textAlign ||
| overflow ||
| softWrap ||
| maxLines ||
| onTextLayout ||
| style ||

> * 為必要之參數

ClickableText: 可以點擊Text

Button

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

## REFERENCE

1. [Jetpack Compose Basics](https://developer.android.com/jetpack/compose/tutorial)

2. [androidx.compose.ui doc](https://developer.android.com/reference/kotlin/androidx/compose/ui/package-summary)
