package com.example.samplemvp.util

import androidx.annotation.IdRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.setupActionBar(@IdRes toolbarId : Int, action : ActionBar.() -> Unit){
    setSupportActionBar(findViewById(toolbarId))
    supportActionBar?.run {
        action()
    }
}