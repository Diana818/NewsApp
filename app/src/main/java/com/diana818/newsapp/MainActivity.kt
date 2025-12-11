package com.diana818.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import com.diana818.newsapp.ui.theme.NewsAppTheme
import com.diana818.newsapp.presentation.news_list.NewsListScreen

@AndroidEntryPoint // Necessary for Hilt
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                // This is the starting point for your news list UI
                NewsListScreen()
            }
        }
    }
}