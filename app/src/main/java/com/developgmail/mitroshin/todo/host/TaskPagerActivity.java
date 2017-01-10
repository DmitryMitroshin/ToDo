package com.developgmail.mitroshin.todo.host;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.developgmail.mitroshin.todo.R;
import com.developgmail.mitroshin.todo.controllers.TaskFragment;
import com.developgmail.mitroshin.todo.model.Task;
import com.developgmail.mitroshin.todo.util.TaskLab;

import java.util.List;
import java.util.UUID;

/*Хост для фрагмента TaskFragment.java*/

public class TaskPagerActivity extends FragmentActivity {

    private static final String EXTRA_TASK_ID = "com.developgmail.mitroshin.todo.task_id";

    /*Ссылка на виджет ViewPager*/
    private ViewPager mViewPager;
    /*Ссылка на список, для отображения*/
    private List<Task> mListTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_pager);

        /*Получение дополнения для отображаемых данных*/
        UUID taskId = (UUID) getIntent().getSerializableExtra(EXTRA_TASK_ID);

        mViewPager = (ViewPager) findViewById(R.id.a_view_pager_task);
        mListTask = TaskLab.getTaskLab(this).getListTask();

        /*Адаптер отвечает за взаимодействие данных с ViewPager.
        Для этого ему необходима возможность возвращать экземпляры фрагментов в getItem()
        с помощью объекта класса FragmentManager.*/
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Task task = mListTask.get(position);
                return TaskFragment.newInstance(task.getUUID());
            }

            @Override
            public int getCount() {
                return mListTask.size();
            }
        });
    }

    public static Intent newIntent(Context context, UUID taskID) {
        Intent intent = new Intent(context, TaskPagerActivity.class);
        /*В интент прикрепляются дополнения в виде идентификатора задачи*/
        intent.putExtra(EXTRA_TASK_ID, taskID);
        return intent;
    }
}
