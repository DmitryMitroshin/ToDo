package com.developgmail.mitroshin.todo.host;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.developgmail.mitroshin.todo.R;

/*Хост для фрагмента TaskFragment.java*/

public class TaskPagerActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_pager);
    }
}
