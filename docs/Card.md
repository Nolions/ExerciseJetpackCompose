# Cards

## param

| 函數 | 說明 | Type|
| --- | --- | --- |
| onClick | 點擊後的行為 | lambda，default:null |
| shape | 形狀 | Shape |
| backgroundColor | 背景顏色  | Color |
| contentColor | 內文顏色 | Color |
| border | 邊框 | BorderStroke，default:null |
| elevation | 陰影 | Dp |
| content |  | @Composable lambda | 
| modifier | 元素修饰符 | Modifier |

```
 Card(
    border = BorderStroke(10.dp, Color.Red),
    modifier = Modifier.fillMaxWidth().padding(15.dp)
) {
    Column {
        Image(
            painter = painterResource(R.drawable.power),
            contentDescription = null,
            modifier = Modifier.height(180.dp).width(180.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            buildAnnotatedString {
                append("welcome to ")
                withStyle(
                    style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                ) {
                    append("Jetpack Compose Playground")
                }
            }
        )
    }
}
```