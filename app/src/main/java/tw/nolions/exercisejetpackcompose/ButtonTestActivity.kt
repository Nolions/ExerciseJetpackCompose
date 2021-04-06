package tw.nolions.exercisejetpackcompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
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

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.weight(1f)) {
                Button(
                    onClick = { text.value = "btn clicked." },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                        contentColor = Color.Red,
                    )
                ) {
                    Text(text = "Btn")
                }
            }

            Box(modifier = Modifier.weight(2f)) {
                ClickableText(
                    text = AnnotatedString("Click Me"),
                    modifier = Modifier.padding(10.dp),
                    onClick = {
                        text.value = "text clicked."
                    }
                )
            }
        }

        Spacer(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
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

            IconBtn(Icons.Filled.Search, iconBtnModifier, Color.Green) {
                text.value = "Search clicked."
                toastAlert(context, text.value)
            }
        }

        Spacer(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        )

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
