package com.mig.dailynewsapp.ui.theme.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mig.dailynewsapp.models.Article
import com.mig.dailynewsapp.ui.theme.DailyNewsAppTheme
import java.util.Date

@Composable
fun HomeView(modifier: Modifier = Modifier) {
    var articles = arrayListOf(
        Article(
            title = "Lorem Ipsum",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ultrices nibh iaculis sem viverra, ac lacinia arcu viverra. Sed dapibus commodo leo in sollicitudin. Phasellus massa lectus, consequat vitae accumsan sed, hendrerit ullamcorper nisl. Fusce a varius augue, et cursus tortor. Nunc commodo augue leo, a eleifend magna efficitur quis. Suspendisse lacus neque, ultrices id lectus non, efficitur euismod nunc. In sed tincidunt metus. Integer justo elit, vestibulum pharetra blandit a, tempus ut massa.",
            urlToImage = "https://cdn.discordapp.com/attachments/981454241140990005/1293510014413045832/tigrinho_sniffa.jpg?ex=6707a293&is=67065113&hm=71e42af700919b0f5969151124b37f01c8739a82d091b7f9e41832c70430fd49&",
            url = "Test 1",
            publishedAt = Date().toString()
        ),
        Article(
            title = "Lorem Ipsum",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ultrices nibh iaculis sem viverra, ac lacinia arcu viverra. Sed dapibus commodo leo in sollicitudin. Phasellus massa lectus, consequat vitae accumsan sed, hendrerit ullamcorper nisl. Fusce a varius augue, et cursus tortor. Nunc commodo augue leo, a eleifend magna efficitur quis. Suspendisse lacus neque, ultrices id lectus non, efficitur euismod nunc. In sed tincidunt metus. Integer justo elit, vestibulum pharetra blandit a, tempus ut massa.",
            urlToImage = "Test 1",
            url = "Test 1",
            publishedAt = Date().toString()
        ),
        Article(
            title = "Lorem Ipsum",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ultrices nibh iaculis sem viverra, ac lacinia arcu viverra. Sed dapibus commodo leo in sollicitudin. Phasellus massa lectus, consequat vitae accumsan sed, hendrerit ullamcorper nisl. Fusce a varius augue, et cursus tortor. Nunc commodo augue leo, a eleifend magna efficitur quis. Suspendisse lacus neque, ultrices id lectus non, efficitur euismod nunc. In sed tincidunt metus. Integer justo elit, vestibulum pharetra blandit a, tempus ut massa.",
            urlToImage = "https://cdn.discordapp.com/attachments/981454241140990005/1293510014413045832/tigrinho_sniffa.jpg?ex=6707a293&is=67065113&hm=71e42af700919b0f5969151124b37f01c8739a82d091b7f9e41832c70430fd49&",
            url = "Test 1",
            publishedAt = Date().toString()
        ),
        Article(
            title = "Lorem Ipsum",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ultrices nibh iaculis sem viverra, ac lacinia arcu viverra. Sed dapibus commodo leo in sollicitudin. Phasellus massa lectus, consequat vitae accumsan sed, hendrerit ullamcorper nisl. Fusce a varius augue, et cursus tortor. Nunc commodo augue leo, a eleifend magna efficitur quis. Suspendisse lacus neque, ultrices id lectus non, efficitur euismod nunc. In sed tincidunt metus. Integer justo elit, vestibulum pharetra blandit a, tempus ut massa.",
            urlToImage = "https://cdn.discordapp.com/attachments/981454241140990005/1293510014413045832/tigrinho_sniffa.jpg?ex=6707a293&is=67065113&hm=71e42af700919b0f5969151124b37f01c8739a82d091b7f9e41832c70430fd49&",
            url = "Test 1",
            publishedAt = Date().toString()
        ),
        Article(
            title = "Lorem Ipsum",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ultrices nibh iaculis sem viverra, ac lacinia arcu viverra. Sed dapibus commodo leo in sollicitudin. Phasellus massa lectus, consequat vitae accumsan sed, hendrerit ullamcorper nisl. Fusce a varius augue, et cursus tortor. Nunc commodo augue leo, a eleifend magna efficitur quis. Suspendisse lacus neque, ultrices id lectus non, efficitur euismod nunc. In sed tincidunt metus. Integer justo elit, vestibulum pharetra blandit a, tempus ut massa.",
            urlToImage = "https://cdn.discordapp.com/attachments/981454241140990005/1293510014413045832/tigrinho_sniffa.jpg?ex=6707a293&is=67065113&hm=71e42af700919b0f5969151124b37f01c8739a82d091b7f9e41832c70430fd49&",
            url = "Test 1",
            publishedAt = Date().toString()
        ),
        Article(
            title = "Lorem Ipsum",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ultrices nibh iaculis sem viverra, ac lacinia arcu viverra. Sed dapibus commodo leo in sollicitudin. Phasellus massa lectus, consequat vitae accumsan sed, hendrerit ullamcorper nisl. Fusce a varius augue, et cursus tortor. Nunc commodo augue leo, a eleifend magna efficitur quis. Suspendisse lacus neque, ultrices id lectus non, efficitur euismod nunc. In sed tincidunt metus. Integer justo elit, vestibulum pharetra blandit a, tempus ut massa.",
            urlToImage = "https://cdn.discordapp.com/attachments/981454241140990005/1293510014413045832/tigrinho_sniffa.jpg?ex=6707a293&is=67065113&hm=71e42af700919b0f5969151124b37f01c8739a82d091b7f9e41832c70430fd49&",
            url = "Test 1",
            publishedAt = Date().toString()
        ),
        Article(
            title = "Lorem Ipsum",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ultrices nibh iaculis sem viverra, ac lacinia arcu viverra. Sed dapibus commodo leo in sollicitudin. Phasellus massa lectus, consequat vitae accumsan sed, hendrerit ullamcorper nisl. Fusce a varius augue, et cursus tortor. Nunc commodo augue leo, a eleifend magna efficitur quis. Suspendisse lacus neque, ultrices id lectus non, efficitur euismod nunc. In sed tincidunt metus. Integer justo elit, vestibulum pharetra blandit a, tempus ut massa.",
            urlToImage = "https://cdn.discordapp.com/attachments/981454241140990005/1293510014413045832/tigrinho_sniffa.jpg?ex=6707a293&is=67065113&hm=71e42af700919b0f5969151124b37f01c8739a82d091b7f9e41832c70430fd49&",
            url = "Test 1",
            publishedAt = Date().toString()
        ),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp, 32.dp, 8.dp, 32.dp)
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(articles) { article ->
                ArticleRow(article = article)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    DailyNewsAppTheme {
        HomeView()
    }
}