package com.developgmail.mitroshin.todo.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.developgmail.mitroshin.todo.R;
import com.developgmail.mitroshin.todo.model.Task;

/*Класс необходим для удержания объектов View.
В поле itemView хранится ссылка на все представление View, переданное super(view)*/

public class TaskHolder extends RecyclerView.ViewHolder {

    /*Ссылки на виджеты внутри View элемента списка*/
    private TextView mTextViewTitle;
    private TextView mTextViewDate;
    private CheckBox mCheckBoxComplete;

    /*Объекты представления теперь связаны с TaskHolder.
    Теперь нужно связать их и с объектами модели*/
    private Task mTask;

    public TaskHolder(View itemView) {
        super(itemView);

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
}
