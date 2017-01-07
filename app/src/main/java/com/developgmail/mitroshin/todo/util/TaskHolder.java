package com.developgmail.mitroshin.todo.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/*Класс необходим для удержания объектов View.
В поле itemView хранится ссылка на все представление View, переданное super(view)*/

public class TaskHolder extends RecyclerView.ViewHolder {

    /*Ссылки на виджеты внутри View элемента списка*/
    public TextView mTextViewTitle;


    public TaskHolder(View itemView) {
        super(itemView);

        /*Связывание полей объекта ViewHolder с соответствующими элементами из
        полученного объекта View*/
        /*TODO в данный момент внутри itemView находится только один виджет TextView,
        потом он быдет составным и объекты внутри нужно будет искать по их идентификатору*/
        mTextViewTitle = (TextView) itemView;
    }
}
