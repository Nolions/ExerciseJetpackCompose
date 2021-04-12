# CheckBox & RadioButton

## CheckBox

## RadioButton

### param

| 函數 | 說明 | Type|
| --- | --- | --- |
| selected | 預設狀態 | Boolean |
| onClick | 點擊後的行為 | lambda |
| enabled | 啟用 | Boolean |
| interactionSource |  | MutableInteractionSource |
| color |  | RadioButtonColors | 
| modifier | 元素修饰符 | Modifier |

### Use

```
 val radioOptions = listOf("A", "B", "C")
 val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

 Column {
    Row {
        radioOptions.forEach { text ->
            RadioButton(
                selected = (text == selectedOption),
                onClick = { onOptionSelected(text) }
            )

            Text(
                text = text,
                style = MaterialTheme.typography.body1.merge(),
                modifier = Modifier.padding(start = 4.dp, end = 8.dp)
            )
        }
    }

    Text(
        text = selectedOption
    )
}
```

