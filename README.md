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

## 元素


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
