package tw.nolions.exercisejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import tw.nolions.exercisejetpackcompose.ui.theme.ExercisejetpackComposeTheme

class ConstraintLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutContent()
        }
    }
}

@Composable
fun ConstraintLayoutContent() {
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
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutPreview() {
    ExercisejetpackComposeTheme {
        ConstraintLayoutContent()
    }
}