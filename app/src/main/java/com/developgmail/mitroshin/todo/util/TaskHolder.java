package com.developgmail.mitroshin.todo.util;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.developgmail.mitroshin.todo.R;
import com.developgmail.mitroshin.todo.controllers.TaskListFragment;
import com.developgmail.mitroshin.todo.host.TaskActivity;
import com.developgmail.mitroshin.todo.model.Task;

/*Класс необходим для удержания объектов View.
В поле itemView хранится ссылка на все представление View, переданное super(view)*/

public class TaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    /*Ссылки на виджеты внутри View элемента списка*/
    private TextView mTextViewTitle;
    private TextView mTextViewDate;
    private CheckBox mCheckBoxComplete;

    /*Объекты представления теперь связаны с TaskHolder.
    Теперь нужно связать их и с объектами модели*/
    private Task mTask;

    private TaskListFragment mTaskListFragment;

    public TaskHolder(View itemView, TaskListFragment taskListFragment) {
        super(itemView);

        /*TODO Ссылка на объект фрагмента нужна для реализации уведомлений.
        Удалить, если потом не понадобится.*/
        mTaskListFragment = taskListFragment;

        /*Назначение слушателя для элемента View*/
        itemView.setOnClickListener(this);

        /*Связывание полей объекта ViewHolder с соответствующими элементами из
        полученного объекта View*/
        mTextViewTitle = (TextView) itemView.findViewById(R.id.item_task_text_view_title);
        mTextViewDate = (TextView) itemView.findViewById(R.id.item_task_text_view_date);
        mCheckBoxComplete = (CheckBox) itemView.findViewById(R.id.item_task_check_box_complete);
    }

    /*Метод связывает данные из объекта модели с TaskHolder*/
    public void bindTask(Task task) {
        mTask = task;
        mTextViewTitle.setText(mTask.getTitle());
        mTextViewDate.setText(mTask.getDate().toString());
        mCheckBoxComplete.setChecked(mTask.isComplete());
    }

    /*Метод отрбатывает при клике на виджет элемента списка*/
    @Override
    public void onClick(View view) {
        /*Вызов активности детализации*/
        Intent intent = TaskActivity.newIntent(mTaskListFragment.getActivity(),
                mTask.getUUID());
        mTaskListFragment.startActivity(intent);
    }
}
