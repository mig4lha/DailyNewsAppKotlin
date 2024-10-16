package com.mig.dailynewsapp.ui.theme.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mig.dailynewsapp.Screen
import com.mig.dailynewsapp.models.Article
import com.mig.dailynewsapp.ui.theme.DailyNewsAppTheme
import com.mig.dailynewsapp.ui.theme.encodeURL
import java.util.*

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()) {

    val viewModel : HomeViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    HomeViewContent(modifier = modifier,
        navController = navController,
        uiState = uiState)

    LaunchedEffect(Unit) {
        viewModel.fetchArticles()
    }
}

@Composable
fun HomeViewContent(modifier: Modifier = Modifier,
                    navController: NavController = rememberNavController(),
                    uiState: ArticlesState) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        if (uiState.isLoading) {
            Text("Loading articles...")
        }
        else if (uiState.error != null) {
            Text("Error: ${uiState.error}")
        }
        else if (uiState.articles.isEmpty()) {
            Text("No articles found!")
        }else{
            LazyColumn(modifier = modifier
                .fillMaxSize()) {
                itemsIndexed(
                    items = uiState.articles,
                ){ index, article ->
                    ArticleRow(
                        modifier = Modifier
                            .clickable {
                                Log.d("Click_debug",article.url ?:"none")
                                navController.navigate(
                                    Screen.ArticleDetail.route
                                        .replace("{articleUrl}", article.url?.encodeURL()?:"")
                                )
                            },
                        article = article)
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    val articles = arrayListOf(
        Article("Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin lobortis augue in erat scelerisque, vitae fringilla nisi tempus. Sed finibus tellus porttitor dignissim eleifend. Etiam sed neque libero. Integer auctor turpis est. Nunc ac auctor velit. Nunc et mi sollicitudin, iaculis nunc et, congue neque. Suspendisse potenti. Vestibulum finibus justo sed eleifend commodo. Phasellus vestibulum ligula nisi, convallis rhoncus quam placerat id. Donec eu lobortis lacus, quis porta tortor. Suspendisse quis dolor sapien. Maecenas finibus purus at orci aliquam eleifend. Nam venenatis sapien ac enim efficitur pretium. Praesent sagittis risus vitae feugiat blandit. Etiam non neque arcu. Cras a mauris eu erat sodales iaculis non a lorem.",
            urlToImage = "https://media.istockphoto.com/id/1166633394/pt/foto/victorian-british-army-gymnastic-team-aldershot-19th-century.jpg?s=1024x1024&w=is&k=20&c=fIfqysdzOinu8hNJG6ZXOhl8ghQHA7ySl8BZZYWrxyQ="),
        Article("Lorem Ipsum is simply dummy text of the printing", "description"))

    //val articles = arrayListOf<Article>()
    DailyNewsAppTheme {
        HomeViewContent(uiState = ArticlesState(
            articles = articles,
            isLoading = false,
            error = null
        ))
    }
}

//@Composable
//fun HomeView(modifier: Modifier = Modifier) {
//
//    var articles by remember { mutableStateOf(listOf<Article>()) }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(8.dp, 32.dp, 8.dp, 32.dp)
//    ){
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            items(articles) { article ->
//                ArticleRow(article = article)
//            }
//        }
//    }
//
//    LaunchedEffect(Unit) {
//        val client = OkHttpClient()
//
//        val request = Request.Builder()
//            .url("https://newsapi.org/v2/top-headlines?country=us&apiKey=af09ec606cb14a1389c3f5c7a2f589a6")
//            .build()
//
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                e.printStackTrace()
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                response.use {
//                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
//
//                    for ((name, value) in response.headers) {
//                        println("$name: $value")
//                    }
//
//                    var articlesResult = arrayListOf<Article>()
//                    val result = response.body!!.string()
//                    val jsonResult = JSONObject(result)
//                    val status = jsonResult.getString("status")
//                    if(status == "ok"){
//                        val articlesJson = jsonResult.getJSONArray("articles")
//                        for (i in 0 until articlesJson.length()) {
//                            val articleJson = articlesJson.getJSONObject(i)
//                            val article = Article(
//                                title = articleJson.getString("title"),
//                                description = articleJson.getString("description"),
//                                urlToImage = articleJson.getString("urlToImage"),
//                                url = articleJson.getString("url"),
//                                publishedAt = formatDate(articleJson.getString("publishedAt"))
//                            )
//                            articlesResult.add(article)
//                        }
//                    }
//
//                    articles = articlesResult
//
//                    for(article in articles){
//                        println(article.title)
//                    }
//                }
//            }
//        })
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun HomeViewPreview() {
//    DailyNewsAppTheme {
//        HomeView()
//    }
//}