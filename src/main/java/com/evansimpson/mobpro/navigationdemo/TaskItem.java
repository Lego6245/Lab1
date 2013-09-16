package com.evansimpson.mobpro.navigationdemo;

import java.io.Serializable;

/**
 * Created by lego6245 on 9/15/13.
 */
public class TaskItem implements Serializable {
    private String name;

    public TaskItem(String s)
    {
        this.setName(s);
    }

    public void setName(String s)
    {
        name = s;
    }

    public String getName()
    {
        return name;
    }
}
