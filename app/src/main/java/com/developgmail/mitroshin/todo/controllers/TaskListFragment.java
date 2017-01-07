package com.developgmail.mitroshin.todo.controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developgmail.mitroshin.todo.R;

/*Контроллер для представления fragment_task_details.xml
Контроллер инкапсулирует список экземпляров класса Task и
предоставляет методы для взаимодействия с этим списком*/

public class TaskListFragment extends Fragment {

    /*Ссылка на виджет для отображения списка*/
    private RecyclerView mRecyclerViewTaskList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        mRecyclerViewTaskList = (RecyclerView)
                view.findViewById(R.id.f_task_list_recycler_view_task_list);
        /*RecyclerView необходим Manager. В данном случае именно LinearLayoutManager
        LayoutManager управляет позиционированием элементов, а также определяет поведение прокрутки*/
        mRecyclerViewTaskList.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
