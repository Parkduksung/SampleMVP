package com.example.samplemvp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.samplemvp.R
import com.example.samplemvp.data.source.TasksRepository
import com.example.samplemvp.di.Injection
import com.example.samplemvp.util.setupActionBar
import com.google.android.material.navigation.NavigationView

class TasksActivity : AppCompatActivity() {

    private val CURRENT_FILTERING_KEY = "CURRENT_FILTERING_KEY"

    private lateinit var drawerLayout: DrawerLayout

    private lateinit var tasksPresenter: TasksPresenter

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tasks_act)


        val strings = listOf("abc", "def")

        strings.asSequence()

        setupActionBar(R.id.toolbar) {
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayHomeAsUpEnabled(true)
        }

        drawerLayout = (findViewById<DrawerLayout>(R.id.drawer_layout)).apply {
            setStatusBarBackground(R.color.colorPrimaryDark)
        }

        setupDrawerContent(findViewById(R.id.nav_view))



        tasksPresenter = TasksPresenter(
            Injection.provideTasksRepository(context = applicationContext),
            TasksFragment()
        ).apply {
            if (savedInstanceState != null) {
                currentFiltering =
                    savedInstanceState.getSerializable(CURRENT_FILTERING_KEY) as TasksFilterType
            }
        }
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