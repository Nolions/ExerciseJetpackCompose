# Text Label

Label元件: Text

## param

| 參數 | 說明 | 型態 |
| --- | --- | --- |
| *text | 文字內容 |  |
| modifier | 元素修飾符 | Modifier |
| color | 字體顏色 | Color |
| fontSize | 字型大小 | TextUnit |
| fontStyle | 字型 | FontStyle? |
| fontWeight | 字型寬度 | FontWeight? |
| fontFamily | 字型寬度 | FontFamily? |
| letterSpacing |  | TextUnit |
| textDecoration | | TextDecoration? |
| textAlign | 對齊 | TextAlign? |
| lineHeight |  | TextUnit |
| overflow | 文字溢出 | TextOverflow |
| softWrap | | Boolean |
| maxLines | 多大行數| Int |
| onTextLayout | |  |
| style | 風格樣式 | TextStyle |

> * 為必要之參數

## use

## Select & Focus

SelectionContainer: 可以選取反白區域

DisableSelection: 選取反白區域中無法被選取區域

### Use

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

## Click

可以點擊的Text元件: ClickableText

### param

| 參數 | 說明 | 型態 |
| --- | --- | --- |
| *text | 文字內容 |  |
| modifier | 元素修飾符 | Modifier |
| softWrap |  | Boolean |
| overflow | 文字溢出 | TextOverflow |
| maxLines | 多大行數 | Int |
| onClick | 點擊後的行為 | lambda |
| onTextLayout | |  |
| style | 樣式風格 | TextStyle |

### Use

```
ClickableText(
    text = AnnotatedString("Click Me"),
    onClick = {
        text.value = "text clicked."
    }
)
```

## TextField

可以進行輸入&修改TextView

### Use

```
var text = remember { mutableStateOf("Hello") }

TextField(
    value = text.value,
    onValueChange = { text = it },
    label = { Text("Label") }
)

Text(text = text.value)
```

### OutlinedTextField

帶有外框的TextField

#### Use

```
var text = remember { mutableStateOf("Hello") }

OutlinedTextField(
    value = text.value,
    onValueChange = { text = it },
    label = { Text("Label") }
)

Text(text = text.value)
```
