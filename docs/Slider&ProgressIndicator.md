# Slider&ProgressIndicator

## Slider

#### param

| 函數 | 說明 | Type|
| --- | --- | --- |
| value | 進度 | Float |
| onValueChange | Slider值改變時的行為 | lanbda |
| enabled | 啟用 | Boolean |
| valueRange | 指定範圍 | losedFloatingPointRange<Float>，defaut:0f..1f |
| steps | 刻度 | Int |
| onValueChangeFinished | Slider的value變更時會調用，但透過拖曳變更值，則不會觸發 | lanbda |
| interactionSource |  | MutableInteractionSource |
| modifier | 元素修饰符 | Modifier |

### Use

## ProgressIndicator

### LinearProgressIndicator

#### param

| 函數 | 說明 | Type|
| --- | --- | --- |
| progress | 進度 | Float |
| backgroundColor | 背景顏色 | Color |
| color | 內容顏色 | Color |
| modifier | 元素修饰符 | Modifier |

#### Use

```
var sliderPosition = remember { mutableStateOf(0f) }

LinearProgressIndicator(
        progress = sliderPosition,
        modifier = Modifier.padding(10.dp, 20.dp),
        color = Color.Green,
        backgroundColor = Color.DarkGray
)
```

### CircularProgressIndicator

#### param

| 函數 | 說明 | Type|
| --- | --- | --- |
| progress | 進度 | Float |
| strokeWidth | 指示器寬度 | DP |
| color | 內容顏色 | Color |
| modifier | 元素修饰符 | Modifier |

### Use

```
var sliderPosition = remember { mutableStateOf(0f) }

CircularProgressIndicator(
    progress = sliderPosition.value,
    strokeWidth = 2.dp,
    color = Color.DarkGray,
)
```

### Example

結合Slider與ProgressIndicator，並用Slider控制LinearProgressIndicator與CircularProgressIndicator進度

```
var sliderPosition = remember { mutableStateOf(0f) }

val animatedProgress = animateFloatAsState(
        targetValue = sliderPosition.value / 10,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

Row() {

    OutlinedButton(
        onClick = {
            if (sliderPosition.value > 0f) sliderPosition.value -= 0.1f * 10
        }
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = null
        )
    }

    Slider(
        value = sliderPosition.value,
        onValueChange = {
            sliderPosition.value = it
        },
        valueRange = 0F..10F,
        steps = 10,
        colors = SliderDefaults.colors()
    )

    OutlinedButton(
        onClick = {
            if (sliderPosition.value < 1f) sliderPosition.value += 0.1f * 10
        }
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null
        )
    }
}

Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    LinearProgressIndicator(
        progress = animatedProgress,
        modifier = Modifier.padding(10.dp, 20.dp),
        color = Color.Green,
        backgroundColor = Color.DarkGray
    )

    CircularProgressIndicator(
        progress = sliderPosition.value/10,
        strokeWidth = 20.dp,
        color = Color.DarkGray,
    )

    Text(text = sliderPosition.value.toInt().toString())
}

```

> LinearProgressIndicator與CircularProgressIndicator中可以不指定progress值，則會一直運行轉態呈現。
