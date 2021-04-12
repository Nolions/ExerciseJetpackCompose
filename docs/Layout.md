# Layout

| 函數 | 說明 |
| --- | --- |
| Column | 縱向排列 |
| Row | 橫向排列 |
| Box | 重疊(後面元素疊至前面元素之上) |
| Scaffold | 基于槽位的布 | 
| ConstraintLayout | 約束佈局 |

## Column & Row

### align

Column

| 函數 | 說明 |
| --- | --- |
| verticalArrangement | 垂直排列 |
| horizontalAlignment | 水平對齊 |

Row

| 函數 | 說明 |
| --- | --- |
| verticalAlignment | 垂直對齊 |
| horizontalArrangement | 水平排列 |

## Scaffold

| 參數 | 說明 |
| --- | --- |
| modifier |  |
| scaffoldState |  |
| topBar | Top Bar |
| bottomBar | Bottom Bar |
| content | body Content |
| contentColor |  |
| snackbarHost |  |
| floatingActionButton | floatingActionButton位置，預設為`FabPosition.End` |
| floatingActionButtonPosition |  |
| isFloatingActionButtonDocked |  |
| drawerContent |  |
| drawerGesturesEnabled | 透過手勢來開關drawer，預設為true |
| drawerShape | drawer樣式 |
| drawerElevation |  |
| drawerBackgroundColor | drawer 背景色 |
| drawerContentColor | drawer文字內容顏色 |
| drawerScrimColor | drawer未覆蓋部分背景色 |
| backgroundColor |  |

## ConstraintLayout

### dependence

add dependencies of constraintlayout-compose on app build.gradle

    implementation "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha03"

createRefs、createRefFor

constrainAs

linkTo()

parent

> 要設置Layout Align時需要設定layout size(寬高)
