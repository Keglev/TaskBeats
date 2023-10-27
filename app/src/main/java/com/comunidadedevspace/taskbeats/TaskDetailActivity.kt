package com.comunidadedevspace.taskbeats

import android.app.Activity
import android.content.Context
import android.content.Intent
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
        private const val TASK_DETAIL_EXTRA = "task.title.extra.detail"

        fun start(context: Context, task: Task): Intent{
            val intent = Intent(context, TaskDetailActivity::class.java)
                .apply {
                    putExtra(TaskDetailActivity.TASK_DETAIL_EXTRA, task)
                }
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)


        // Recover Task from the former screen
        val task: Task? = intent.getSerializableExtra(TASK_DETAIL_EXTRA) as Task?
        requireNotNull(task)

        // Recover XML Field
        val tvTitle = findViewById<TextView>(R.id.tv_task_title_detail)

        // Set a new text on the screen
        tvTitle.text = task.title
    }

    // Activity life circle
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_task_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_task -> {
                    val intent = Intent()
                        .apply {
                            putExtra("result_Detail", "Result")
                        }
                setResult(Activity.RESULT_OK, intent)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}