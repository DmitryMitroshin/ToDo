package com.developgmail.mitroshin.todo.controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developgmail.mitroshin.todo.R;
import com.developgmail.mitroshin.todo.model.Task;

/*Контроллер для представления fragment_task_details.xml
Контроллер взаимодействует с объектами модели и представления.
Его задача - выдача подробной информации о конкретном экземпляре и
его обновление при модификации пользователем.*/

public class TaskFragment extends Fragment {

    /*Ссылка на объект модели*/
    private Task mTask;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*При создании фрагмента, будет создаваться экземпляр класса модели*/
        mTask = new Task();
    }

    /*Заполнение макета представления фрагмента и возврат заполненного фргмента активности-хосту*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        /*Заполнение макета.
        Передается идентификатор ресурса макета,
        родитель представления,
        нужно ли включать заполненное представление в родителя*/
        View view = inflater.inflate(R.layout.fragment_task_details, container, false);
        return view;
    }
}
