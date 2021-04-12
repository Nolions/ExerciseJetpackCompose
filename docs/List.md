# List

| 函數 | 說明 |
| --- | --- |
| LazyColumn | 垂直方向列表 |
| LazyRow | 水平方向列表 |

## param

## item

item: List列表下單一項目

items

> item元素中可搭配Layout，以實現複雜UI Layout

## Use

```
LazyColumn( modifier = Modifier.height(200.dp), state = listState) {
    for (i in 1..size) {
        item() {
            Row {
                Icon(imageVector = Icons.Filled.Done, contentDescription = null)
                    Text(text = "item $i")
                }
            }
        }
        
        if (listState.firstVisibleItemIndex > 0){
            Log.d("aaaaaa", "LazyListState: index: ${listState.firstVisibleItemIndex}")
            Log.d("aaaaaa", "LazyListState: Offset: ${listState.firstVisibleItemScrollOffset}")
        }
    }
}
```

```
LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
    items(colors) { color ->
        Text(
            text = "color: $color",
            modifier = Modifier
                .background(Color.Cyan)
                .padding(2.dp, 8.dp)
        )
    }
}
```

## move

animateScrollToItem

rememberCoroutineScope

rememberLazyListState

rememberCoroutineScope

### Use

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


