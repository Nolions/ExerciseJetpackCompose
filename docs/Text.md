# Text

## param

| 參數 | 說明 | 型態 |
| --- | --- | --- |
| *text | 文字內容 |  |
| modifier |  |  |
| color | 字體顏色 |  |
| fontSize | 字型大小 |  |
| fontStyle | 字型 |  |
| fontWeight | 字型寬度 |  |
| letterSpacing |  |  |
| textDecoration | |  |
| textAlign | 對齊 |  |
| overflow | 文字溢出 |  |
| softWrap | |  |
| maxLines | 多大行數|  |
| onTextLayout | |  |
| style | |  |

> * 為必要之參數

## use

## Select & Focus

### SelectionContainer

### DisableSelection

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

ClickableText

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
