package com.mig.dailynewsapp.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mig.dailynewsapp.models.Article
import java.util.Date

@Composable
fun HomeView(modifier: Modifier = Modifier) {
    var articles = arrayListOf(
        Article(
            title = "Test 1",
            description = "Test 1",
            urlToImage = "Test 1",
            url = "Test 1",
            publishedAt = Date().toString()
        ),
        Article(
            title = "Test 2",
            description = "Test 2",
            urlToImage = "Test 2",
            url = "Test 2",
            publishedAt = Date().toString()
        )
    )

    LazyColumn(modifier = modifier) {
        itemsIndexed(items = articles){
            index, article ->
            Text(text = article.title!!)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DailyNewsAppTheme {
        HomeView()
    }
}