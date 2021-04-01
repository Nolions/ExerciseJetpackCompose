package tw.nolions.exercisejetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

    Column() {
        Image(
            painter = painterResource(R.drawable.power),
            contentDescription = null,
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Hello $name!")
        Text(text = "Hi $name!")
        Text(text = "Good morning $name!")
        Text(text = "good afternoon $name!")
        Text(text = "good night $name!")
    }
}

@Preview(showBackground = false)
@Composable
fun PreviewGreeting() {
    Greeting("Android")
}
