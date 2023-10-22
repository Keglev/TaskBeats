package com.comunidadedevspace.taskbeats

import android.os.Bundle
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
}