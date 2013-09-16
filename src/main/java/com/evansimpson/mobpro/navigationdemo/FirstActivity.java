package com.evansimpson.mobpro.navigationdemo;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class FirstActivity extends Activity  {

    private TaskListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        setupListViewAdapter();

        setupAddTaskButton();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            ActionBar ab = getActionBar();
            ab.setSubtitle("First Activity");
        }

    }

    public void removeListItemOnClickHandler(View v) {
        TaskItem itemToRemove = (TaskItem)v.getTag();
        adapter.remove(itemToRemove);
    }

    private void setupListViewAdapter() {
        adapter = new TaskListAdapter(FirstActivity.this, R.layout.taskitem, new ArrayList<TaskItem>());
        ListView taskListView = (ListView)findViewById(R.id.taskList);
        taskListView.setAdapter(adapter);
    }

    private void setupAddTaskButton() {
        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.insert(new TaskItem(((EditText)findViewById(R.id.entryField)).getText().toString()), 0);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first, menu);
        return true;
    }
    
}
