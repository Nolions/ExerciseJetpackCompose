package tw.nolions.exercisejetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("Android")
        }
    }
}

@Composable
fun Greeting(name: String) {
    val imageModifier = Modifier
        .height(180.dp)
        .width(180.dp)

    var username = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }

    Column() {
        Image(
            painter = painterResource(R.drawable.power),
            contentDescription = null,
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(10.dp))

        SelectionContainer {
            Column() {
                Text(text = "Hello $name!", color = Color.Blue, textDecoration = null)
                Text(text = "Hi $name!")
                DisableSelection {
                    Text(text = "Good morning $name!")
                    Text(text = "good afternoon $name!")
                }

                Text(text = "good night $name!")
            }
        }

        TextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = {
                Text("UserName")
            }
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("password") },
        )

        Text(
            text = username.value,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )

        Text(
            text = password.value,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        )
    }


}

@Preview(showBackground = false)
@Composable
fun PreviewGreeting() {
    Greeting("Android")
}
