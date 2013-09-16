package com.evansimpson.mobpro.navigationdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lego6245 on 9/15/13.
 */
public class TaskListAdapter extends ArrayAdapter<TaskItem> {

    private List<TaskItem> items;
    private int layoutResourceID;
    private Context context;

    public TaskListAdapter(Context context, int layoutResourceID, List<TaskItem> items)
    {
        super(context, layoutResourceID, items);
        this.items = items;
        this.layoutResourceID = layoutResourceID;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        TaskItemHolder holder = null;

        LayoutInflater inflater = ((FirstActivity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceID, parent, false);

        holder = new TaskItemHolder();
        holder.taskItem = items.get(position);
        holder.removeItem = (Button)row.findViewById((R.id.removeItem));
        holder.removeItem.setTag(holder.taskItem);

        holder.taskName = (TextView)row.findViewById((R.id.taskName));

        row.setTag(holder);
        setupItem(holder);
        return row;
    }

    private void setupItem(TaskItemHolder holder) {
        holder.taskName.setText(holder.taskItem.getName());
    }

    public static class TaskItemHolder {
        TaskItem taskItem;
        TextView taskName;
        Button removeItem;

    }
}
