# Layout

| 函數 | 說明 |
| --- | --- |
| Column | 縱向排列 |
| Row | 橫向排列 |
| Box | 重疊(後面元素疊至前面元素之上) |
| Scaffold | 基於槽位的佈局 |
| ConstraintLayout | 約束佈局 |

## Column

縱向佈局

### param

| 參數 | 說明 | 型態 |
| --- | --- | --- |
| modifier |  | Modifier |
| verticalArrangement | 垂直排列 | Arrangement.Vertical |
| horizontalAlignment | 水平對齊 | Alignment.Horizontal |
| content |  |  |

### Use

```
Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    ......
}
```

## Row

### param

| 參數 | 說明 | 型態 |
| --- | --- | --- |
| modifier | 垂直排列 | Modifier |
| horizontalArrangement | 水平排列 | Arrangement.Horizontal |
| verticalAlignment | 垂直對齊 | Alignment.Vertical |
| content |  |  |

### Use

```
Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center
) {
    ......
}
```

## Box

## Scaffold

### param

| 參數 | 說明 |
| --- | --- |
| modifier |  |
| scaffoldState |  |
| topBar | Top Bar |
| bottomBar | Bottom Bar |
| content | body Content |
| contentColor |  |
| snackbarHost |  |
| floatingActionButton | floatingActionButton設置 |
| floatingActionButtonPosition | floatingActionButton位置，預設為`FabPosition.End` |
| isFloatingActionButtonDocked | FloatingActionButton是為位於bottomBar一半高度位置 |
| drawerContent | drawerContent |
| drawerGesturesEnabled | 透過手勢來開關drawer，預設為true |
| drawerShape | drawer樣式 |
| drawerElevation |  |
| drawerBackgroundColor | drawer 背景色 |
| drawerContentColor | drawer文字內容顏色 |
| drawerScrimColor | drawer未覆蓋部分背景色 |
| backgroundColor |  |

# Use

```
val context = LocalContext.current
val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
Scaffold(
    scaffoldState = scaffoldState,
    topBar = {
        TopAppBar(
            title = { Text("TopAppBar") },
            backgroundColor = Color(0xFF1976D2)
        )
    },
    bottomBar = {
        BottomAppBar(backgroundColor = Color(0xFF1976D2)) { 
            Text("BottomAppBar")
        }
    },
    content = {
        Column(Modifier.padding(8.dp, 4.dp)) {
            Text("BodyContent")
        }
    },
    drawerContent = { Text(text = "drawerContent") },
    drawerBackgroundColor = Color.White,
    drawerContentColor = Color.Red,
    drawerScrimColor = Color.Gray,
    floatingActionButton = {
        FloatingActionButton(onClick = {
            Toast.makeText(context, "test", Toast.LENGTH_LONG).show()
        }) {
            Text("X")
        }
    },
)
```

## ConstraintLayout

約束佈局

### dependence

ConstraintLayout元件不包含在Jetpact composer基本函式庫中，所以需要而外依賴`constraintlayout-compose` Library

add dependencies of constraintlayout-compose on app build.gradle

    implementation "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha03"

createRefs、createRefFor: 建立一個要被引用變數

```
val (btn, label1, icon, label2) = createRefs()
```

constrainAs: 將元件指向特定變數

```
val btn = createRefs()
Button(
    nClick = { },
    modifier = Modifier.constrainAs(btn) { ... }
) {
    Text(text = "Btn")
}
```

linkTo: 指定元件(上/下/左/右)與要相關聊元件關係

```
// label元件上面相連於btn元件下方，並且邊距設為16dp
Text(
    text = "Label1",
    modifier = Modifier.constrainAs(label) {
        top.linkTo(btn.bottom, margin = 16.dp)
    }
)
```

parent: 外層layout

> 要設置Layout Align時需要設定layout size(寬高)

### Use

```
ConstraintLayout {
    val (btn, label1, icon, label2) = createRefs()

    Button(
        onClick = { },
        modifier = Modifier.constrainAs(btn) {
            top.linkTo(parent.top, margin = 20.dp)
        }
    ) {
        Text(text = "Btn")
    }

    Text(
        text = "Label1",
        fontSize = 25.sp,
        modifier = Modifier.constrainAs(label1) {
            top.linkTo(btn.bottom, margin = 16.dp)
        }
    )

    Icon(
        imageVector = Icons.Filled.Favorite,
        contentDescription = null,
        modifier = Modifier.constrainAs(icon) {
            top.linkTo(label1.bottom, margin = 20.dp)
        }
    )

    Text(
        text = "Label2",
        fontSize = 25.sp,
        modifier = Modifier.constrainAs(label2) {
            start.linkTo(icon.end, margin = 16.dp)
            top.linkTo(label1.bottom, margin = 20.dp)
        }
    )
}
```
