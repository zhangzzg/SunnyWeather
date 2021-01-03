package com.example.hadoop.sunnywealther

import android.app.Application
import android.content.Context

/**
 * Created by 张仲光 on 2021/1/2
 */
class SunnyWealtherApplication :Application() {
    companion object{
        lateinit var context: Context
        const val TOKEN = ""
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}