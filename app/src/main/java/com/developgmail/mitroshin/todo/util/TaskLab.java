package com.developgmail.mitroshin.todo.util;

/*Синглетный класс для хранения списка объектов Task*/

/*Синглетный класс допускает создание только одного экземпляра, который существует до тех пор,
пока приложение остается в памяти*/

import android.content.Context;

public class TaskLab {

    /*Ссылка на единственно возможный объект*/
    private static TaskLab sTaskLab;

    /*В синглетном классе конструктор закрыт,
    чтобы объект можно было создать только с помощью метода самого класса*/
    private TaskLab(Context context) {
    }

    /*Метод возвращает экземпляр класса, если он уже существует. В противном случае - создает его*/
    public static TaskLab getTaskLab(Context context) {
        if (sTaskLab == null) {
            sTaskLab = new TaskLab(context);
        }
        return sTaskLab;
    }
}
