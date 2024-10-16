package com.mig.dailynewsapp.ui.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.mig.dailynewsapp.R
import com.mig.dailynewsapp.models.Article
import java.util.Date

@Composable
fun ArticleRow(modifier: Modifier = Modifier, article: Article) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        /*Box(
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray)
                .align(Alignment.CenterVertically)
        )*/
        val sampleImagePainter = painterResource(id = R.drawable.sample_image)
        article.urlToImage?.let {
            AsyncImage(
                model = article.urlToImage,
                contentDescription = article.title,
                error = sampleImagePainter,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop
            )
        }?:run {
            AsyncImage(
                model = sampleImagePainter,
                contentDescription = "Sample Image",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = article.title!!,
                style = MaterialTheme.typography.headlineSmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = article.description!!,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = article.publishedAt!!,
                style = MaterialTheme.typography.labelMedium,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleRowPreview() {
    ArticleRow(
        article = Article(
            title = "Lorem Ipsum",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ultrices nibh iaculis sem viverra, ac lacinia arcu viverra. Sed dapibus commodo leo in sollicitudin. Phasellus massa lectus, consequat vitae accumsan sed, hendrerit ullamcorper nisl. Fusce a varius augue, et cursus tortor. Nunc commodo augue leo, a eleifend magna efficitur quis. Suspendisse lacus neque, ultrices id lectus non, efficitur euismod nunc. In sed tincidunt metus. Integer justo elit, vestibulum pharetra blandit a, tempus ut massa.",
            urlToImage = "https://cdn.discordapp.com/attachments/981454241140990005/1293510014413045832/tigrinho_sniffa.jpg?ex=6707a293&is=67065113&hm=71e42af700919b0f5969151124b37f01c8739a82d091b7f9e41832c70430fd49&",
            url = "Test 1",
            publishedAt = Date().toString()
        )
    )
}