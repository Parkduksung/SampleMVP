package com.example.samplemvp.ui

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.samplemvp.R
import com.example.samplemvp.di.Injection
import com.example.samplemvp.util.replaceFragmentInActivity
import com.example.samplemvp.util.setupActionBar
import com.google.android.material.navigation.NavigationView

class TasksActivity : AppCompatActivity() {

    private val CURRENT_FILTERING_KEY = "CURRENT_FILTERING_KEY"

    private lateinit var drawerLayout: DrawerLayout

    private lateinit var tasksPresenter: TasksPresenter

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

        val tasksFragment =
            (supportFragmentManager.findFragmentById(R.id.contentFrame) as TasksFragment?)
                ?: TasksFragment.newInstance().also {
                    replaceFragmentInActivity(it, R.id.contentFrame)
                }

        tasksPresenter = TasksPresenter(
            Injection.provideTasksRepository(context = applicationContext),
            tasksFragment
        ).apply {
            if (savedInstanceState != null) {
                currentFiltering =
                    savedInstanceState.getSerializable(CURRENT_FILTERING_KEY) as TasksFilterType
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState.apply {
            putSerializable(CURRENT_FILTERING_KEY, tasksPresenter.currentFiltering)
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            //NavigationView ??? layout_gravity ??? ????????? ????????? ??????.
            drawerLayout.openDrawer(GravityCompat.START)
            return true
        }

        return super.onOptionsItemSelected(item)
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