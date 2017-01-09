package com.developgmail.mitroshin.todo.host;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.developgmail.mitroshin.todo.controllers.TaskFragment;
import com.developgmail.mitroshin.todo.util.MainActivity;

import java.util.UUID;

/*Хост для фрагмента TaskFragment.java*/

public class TaskActivity extends MainActivity {

    private static final String EXTRA_TASK_ID = "com.developgmail.mitroshin.todo.task_id";

    @Override
    protected Fragment createFragment() {
        /*Вместо конструктора используется метод, создающий фрагмент вместе с дополнениями*/
        UUID taskId = (UUID) getIntent().getSerializableExtra(EXTRA_TASK_ID);
        return TaskFragment.newInstance(taskId);
    }

    public static Intent newIntent(Context context, UUID taskID) {
        Intent intent = new Intent(context, TaskActivity.class);
        /*В интент прикрепляются дополнения в виде идентификатора задачи*/
        intent.putExtra(EXTRA_TASK_ID, taskID);
        return intent;
    }
}
