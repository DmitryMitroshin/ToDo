package com.developgmail.mitroshin.todo.util;

/*Синглетный класс для хранения списка объектов Task*/

/*Синглетный класс допускает создание только одного экземпляра, который существует до тех пор,
пока приложение остается в памяти*/

import android.content.Context;

import com.developgmail.mitroshin.todo.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskLab {

    /*Ссылка на единственно возможный объект*/
    private static TaskLab sTaskLab;

    /*Класс TaskLab нужен для инкапсуляции списка объектов Task*/
    private List<Task> mListTask;

    /*В синглетном классе конструктор закрыт,
    чтобы объект можно было создать только с помощью метода самого класса*/
    private TaskLab(Context context) {
        mListTask = new ArrayList<>();

        /*TODO Данные для примера, удалить*/
        for (int i = 0; i < 100; i ++) {
            Task task = new Task();
            task.setTitle("Task #" + i);
            /*Каждая вторая задача выполнена*/
            task.setComplete(i % 2 == 0);
            mListTask.add(task);
        }
    }

    /*Метод возвращает экземпляр класса, если он уже существует. В противном случае - создает его*/
    public static TaskLab getTaskLab(Context context) {
        if (sTaskLab == null) {
            sTaskLab = new TaskLab(context);
        }
        return sTaskLab;
    }

    /*Метод возвращает текущий список задач*/
    public List<Task> getListTask() {
        return mListTask;
    }

    /*Метод возвращает конкретный экземпляр Task из списка*/
    public Task getTaskById(UUID id) {
        for (Task task : mListTask) {
            if (task.getUUID().equals(id)) {
                return task;
            }
        }
        return null;
    }
}
