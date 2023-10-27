package com.comunidadedevspace.taskbeats

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            // you will get result here in result.data
            println("Result")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskList = listOf<Task>(
            Task("Title0", "Desc0"),
            Task("Title1", "Desc1"),
        )

        // Adapter

        val adapter: TaskListAdapter = TaskListAdapter(taskList, ::openTaskDetailView)


        // RecyclerView
        val rvTasks: RecyclerView = findViewById(R.id.rv_task_list)
        rvTasks.adapter = adapter
    }
    private fun openTaskDetailView(task: Task){

        startForResult.launch(intent)

        val intent = TaskDetailActivity.start(this, task)
        startActivity(intent)
    }
}