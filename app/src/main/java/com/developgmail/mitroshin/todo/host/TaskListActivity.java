package com.developgmail.mitroshin.todo.host;

import android.support.v4.app.Fragment;

import com.developgmail.mitroshin.todo.controllers.TaskListFragment;
import com.developgmail.mitroshin.todo.util.MainActivity;

/*Хост для фрагмента TaskListFragment.java*/

public class TaskListActivity extends MainActivity {

    @Override
    protected Fragment createFragment() {
        return new TaskListFragment();
    }
}
