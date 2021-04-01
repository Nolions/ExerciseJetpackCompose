package tw.nolions.exercisejetpackcompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val TAG = "ButtonTest"

class ButtonTestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Button()
        }
    }
}

@Composable
fun Button() {
    val iconBtnModifier = Modifier.width(90.dp)
    val text = remember { mutableStateOf("") }
    val context = LocalContext.current

    Column {

        Button(
            onClick = { text.value = "btn clicked." }) {
            Text(text = "Btn")
        }

        Row(Modifier.fillMaxWidth()) {
            IconBtn(Icons.Filled.Favorite, iconBtnModifier, Color.Black) {
                text.value = "Favorite clicked."
                toastAlert(context, text.value)
            }

            IconBtn(Icons.Filled.Lock, iconBtnModifier, Color.Red) {
                text.value = "Lock clicked."
                toastAlert(context, text.value)
            }

            IconBtn(Icons.Filled.Refresh, iconBtnModifier, Color.Blue) {
                text.value = "Refresh clicked."
                toastAlert(context, text.value)
            }

            IconBtn(Icons.Filled.Search, iconBtnModifier, Color.Yellow) {
                text.value = "Search clicked."

                toastAlert(context, text.value)
            }
        }

        Text(
            text = text.value,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        )

    }
}

fun toastAlert(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

@Composable
private fun IconBtn(icon: ImageVector, modifier: Modifier, color: Color, f: () -> Unit) {
    IconButton(
        onClick = { f.invoke() },
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Button()
}
