# CheckBox & RadioButton

## CheckBox

復選框

### param

| 函數 | 說明 | Type|
| --- | --- | --- |
| checked | 預設狀態 | Boolean |
| onCheckedChange | 點擊後的行為 | lambda |
| enabled | 啟用 | Boolean |
| colors | CheckBox相關顏色設置 | RadioButtonColors | 
| interactionSource |  | MutableInteractionSource |
| modifier | 元素修饰符 | Modifier |

### Use

```
val checkOptions = listOf("A", "B", "C")
val checked = ArrayList<Boolean>()
    checked.add(false)
    checked.add(false)
    checked.add(false)

val optionsChecked = remember { mutableStateOf(checked) }

Column {
    Row {
        checkOptions.forEachIndexed { index, text ->
            val checkedState = remember { mutableStateOf(optionsChecked.value[index]) }
            Row(
                Modifier
                    .selectable(
                        selected = checkedState.value,
                        onClick = {
                            checkedState.value = !checkedState.value
                            optionsChecked.value[index] = checkedState.value
                        }
                    )
            ) {
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = {
                        checkedState.value = it
                        optionsChecked.value[index] = it
                    }, colors = CheckboxDefaults.colors(
                        checkmarkColor = Color.White,
                        checkedColor = Color.Red,
                        uncheckedColor = Color.Blue,
                    )
                )

                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 4.dp, end = 8.dp)
                )
            }
        }
    }

    Text(text = "Checked:${optionsChecked.value.toString()}")
}
```

## RadioButton

單選按鈕

### param

| 函數 | 說明 | Type|
| --- | --- | --- |
| selected | 預設狀態 | Boolean |
| onClick | 點擊後的行為 | lambda |
| enabled | 啟用 | Boolean |
| colors | RadioButton相關顏色設置 | RadioButtonColors | 
| interactionSource |  | MutableInteractionSource |
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

