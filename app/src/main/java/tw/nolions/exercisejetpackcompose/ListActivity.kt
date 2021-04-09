package tw.nolions.exercisejetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItemList(20, listOf("Red", "Yellow", "Blue"))
        }
    }
}

@Composable
fun ItemList(size: Int, colors: List<String>) {
    Column {
        val listState = rememberLazyListState()

        val coroutineScope = rememberCoroutineScope()
        LazyColumn( modifier = Modifier.height(200.dp), state = listState) {
            for (i in 1..size) {
                item() {
                    Row {
                        Icon(imageVector = Icons.Filled.Done, contentDescription = null)
                        Text(text = "item $i")
                    }
                }
            }

            if (listState.firstVisibleItemIndex > 0){
                Log.d("aaaaaa", "LazyListState: index: ${listState.firstVisibleItemIndex}")
                Log.d("aaaaaa", "LazyListState: Offset: ${listState.firstVisibleItemScrollOffset}")
            }
        }

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.LightGray)
        )

        LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            items(colors) { color ->
                Text(
                    text = "color: $color",
                    modifier = Modifier
                        .background(Color.Cyan)
                        .padding(2.dp, 8.dp)
                )
            }
        }

        Button(
            onClick = {
                coroutineScope.launch {
                    listState.animateScrollToItem(index = 0)
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.White,
            ),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Top")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemListPreview() {
    ItemList(6, listOf("Red", "Yellow", "Blue"))
}