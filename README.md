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

## Other

Surface

ExercisejetpackComposeTheme

## REFERENCE

1. [Jetpack Compose Basics](https://developer.android.com/jetpack/compose/tutorial)

2. [Jetpack Compose doc](https://developer.android.com/jetpack/compose/documentation)

3. [Jetpack Compose Playground](https://foso.github.io/Jetpack-Compose-Playground/)
