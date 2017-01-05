package com.developgmail.mitroshin.todo.host;

import android.support.v4.app.Fragment;

import com.developgmail.mitroshin.todo.controllers.TaskFragment;
import com.developgmail.mitroshin.todo.util.MainActivity;

/*Хост для фрагмента TaskFragment.java*/

public class TaskActivity extends MainActivity {

    @Override
    protected Fragment createFragment() {
        return new TaskFragment();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_task, );
//    }
}
