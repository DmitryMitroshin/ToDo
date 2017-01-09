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
import com.developgmail.mitroshin.todo.model.Task;
import com.developgmail.mitroshin.todo.util.TaskAdapter;
import com.developgmail.mitroshin.todo.util.TaskLab;

import java.util.List;

/*Контроллер для представления fragment_task_details.xml
Контроллер инкапсулирует список экземпляров класса Task и
предоставляет методы для взаимодействия с этим списком*/

public class TaskListFragment extends Fragment {

    /*Ссылка на виджет для отображения списка*/
    private RecyclerView mRecyclerViewTaskList;

    /*Ссылка на объект адаптера*/
    private TaskAdapter mTaskAdapter;

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

        updateUI();

        return view;
    }

    /*Метод вызывается ОС перед отображением активности на переднем плане*/
    @Override
    public void onResume() {
        super.onResume();
        /*Нужно обновить данные в списке, на случай, если их изменили в активности детализации*/
        updateUI();
    }

    private void updateUI() {
        TaskLab taskLab = TaskLab.getTaskLab(getActivity());
        List<Task> listTask = taskLab.getListTask();

        /*Создавать новый адаптер и заполнять список, нужно только в том случае,
        если он еще не существует. Иначе нужно просто сообщить ему, что могли произойти изменения.*/
        if (mTaskAdapter == null) {
            mTaskAdapter = new TaskAdapter(listTask, this);
            mRecyclerViewTaskList.setAdapter(mTaskAdapter);
        } else {
            mTaskAdapter.notifyDataSetChanged();
        }
    }
}
