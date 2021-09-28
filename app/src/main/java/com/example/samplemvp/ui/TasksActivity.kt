package com.example.samplemvp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.samplemvp.R
import com.example.samplemvp.util.setupActionBar
import com.google.android.material.navigation.NavigationView

class TasksActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    private val isClick by lazy {  findViewById<NavigationView>(R.id.nav_view).isSelected }
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tasks_act)

        setupActionBar(R.id.toolbar) {
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayHomeAsUpEnabled(true)
        }

        drawerLayout = (findViewById<DrawerLayout>(R.id.drawer_layout)).apply {
            setStatusBarBackground(R.color.colorPrimaryDark)
        }

        setupDrawerContent(findViewById(R.id.nav_view))


    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.statistics_navigation_menu_item -> {
                    Toast.makeText(this, "click statistics", Toast.LENGTH_SHORT).show()
                }

                R.id.list_navigation_menu_item -> {
                    Toast.makeText(this, "click to-do list", Toast.LENGTH_SHORT).show()
                }
            }
            menuItem.isChecked = false
            drawerLayout.closeDrawers()
            true
        }
    }
}