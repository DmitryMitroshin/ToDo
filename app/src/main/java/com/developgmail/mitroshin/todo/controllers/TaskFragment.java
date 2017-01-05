package com.developgmail.mitroshin.todo.controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.developgmail.mitroshin.todo.R;
import com.developgmail.mitroshin.todo.model.Task;

/*Контроллер для представления fragment_task_details.xml
Контроллер взаимодействует с объектами модели и представления.
Его задача - выдача подробной информации о конкретном экземпляре и
его обновление при модификации пользователем.*/

public class TaskFragment extends Fragment {

    /*Ссылка на объект модели*/
    private Task mTask;

    /*Ссылки на виджеты представления*/
    private EditText mEditTextTaskTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*При создании фрагмента, будет создаваться экземпляр класса модели*/
        mTask = new Task();
    }

    /*Заполнение макета представления фрагмента и возврат заполненного фргмента активности-хосту*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        /*Заполнение макета.
        Передается идентификатор ресурса макета,
        родитель представления,
        нужно ли включать заполненное представление в родителя*/
        View view = inflater.inflate(R.layout.fragment_task_details, container, false);

        findAllViewById(view);
        addAllListeners();

        return view;
    }

    /*Метод обавляет слушатели события для виджетов*/
    private void addAllListeners() {
        /*Слушатель для поля ввода заголовка*/
        mEditTextTaskTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mTask.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /*Метод связывает объекты контроллера с объектами представления*/
    private void findAllViewById(View view) {
        mEditTextTaskTitle = (EditText) view.findViewById(R.id.f_task_details_edit_text_task_title);
    }
}