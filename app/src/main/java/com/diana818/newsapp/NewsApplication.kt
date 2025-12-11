package com.diana818.newsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // Marks this class for Hilt code generation
class NewsApplication : Application()