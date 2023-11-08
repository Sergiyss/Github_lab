package ua.dev.webnauts.githublab.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.dev.webnauts.githublab.Greeting

class MainActivity : ComponentActivity() {
    private val mainViewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {



            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val launches by mainViewModel.launches

                    Column {
                        launches?.let {
                            LazyColumn(
                                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),

                                content = {
                                items(it.results.size) { index ->
                                    Text(text = it.results[index].question)

                                    Row(modifier = Modifier.fillMaxWidth(1f),
                                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {
                                        it.results[index].incorrectAnswers.forEach { answer ->
                                            Button(
                                                modifier = Modifier.padding(0.dp),
                                                onClick = { }) {
                                                Text(
                                                    softWrap = true,
                                                    overflow = TextOverflow.Ellipsis,
                                                    maxLines = 1,
                                                    modifier = Modifier.fillMaxWidth(.3f),
                                                    text = answer)
                                            }
                                        }
                                    }
                                }
                            })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Column {


            GreetingView("Hello, Android! ${Greeting().greet()}")
            GreetingView("Hello, Android! ${Greeting().daysUntilNewYear()}")
        }
    }
}
