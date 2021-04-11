# ProgressIndicator

進度指示器

## LinearProgressIndicator

### param

| 函數 | 說明 | Type|
| --- | --- | --- |
| progress | Block of Toolbar Icon | Float |
| backgroundColor | 背景顏色 | Color |
| color | 內容顏色 | Color |
| modifier | 元素修饰符 | Modifier |

## use

沒有指定進度

```
LinearProgressIndicator(
    modifier = Modifier.padding(8.dp),
    color = Color.Green,
    backgroundColor = Color.Red
)
```

```
var progress = remember { mutableStateOf(0f) }
val animatedProgress = animateFloatAsState(
    targetValue = progress.value,
    animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
).value

Column {
    Row(modifier = Modifier.padding(10.dp, 0.dp)) {
        OutlinedButton(
            onClick = {
                if (progress.value > 0f) progress.value -= 0.1f
            }
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null
            )
        }

        LinearProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier.padding(10.dp, 20.dp)
        )

        OutlinedButton(
            onClick = {
                if (progress.value < 1f) progress.value += 0.1f
            }
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }

    Spacer(Modifier.height(30.dp))

    Text(
        text = "${progress.value.toString()}%",
        modifier = Modifier.padding(10.dp, 0.dp)
    )
}
```