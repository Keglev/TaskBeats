package com.comunidadedevspace.taskbeats

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity

/**
 * Loads [MainFragment].
 */
class TaskDetailActivity : AppCompatActivity() {

    companion object{
        val TASK_TITLE_EXTRA = "task.title.extra.detail"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)


        // Recover String from the former screen
        val title: String = intent.getStringExtra(TASK_TITLE_EXTRA) ?: ""

        // Recover XML Field
        val tvTitle = findViewById<TextView>(R.id.tv_task_title_detail)

        // Set a new text on the screen
        tvTitle.text = title
    }

    // Activity life cicle
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_task_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_task -> {
                // (TODO) Return activity action
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}