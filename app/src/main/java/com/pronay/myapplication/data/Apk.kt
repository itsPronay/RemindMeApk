package com.pronay.myapplication.data

import android.app.Application

class Apk: Application() {
    override fun onCreate() {
        super.onCreate()
        graph.provide(this)
    }
}