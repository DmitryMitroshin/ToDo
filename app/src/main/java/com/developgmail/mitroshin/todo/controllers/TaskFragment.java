package com.developgmail.mitroshin.todo.controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.developgmail.mitroshin.todo.R;
import com.developgmail.mitroshin.todo.model.Task;
import com.developgmail.mitroshin.todo.util.TaskLab;

import java.util.UUID;

/*Контроллер для представления fragment_task_details.xml
Контроллер взаимодействует с объектами модели и представления.
Его задача - выдача подробной информации о конкретном экземпляре и
его обновление при модификации пользователем.*/

public class TaskFragment extends Fragment {

    /*Ссылка на объект модели*/
    private Task mTask;

    /*Ссылки на виджеты представления*/
    private EditText mEditTextTaskTitle;
    private Button mButtonDate;
    private CheckBox mCheckBoxComplete;

    /*Ключ для дополнения, получаемого в виде аргумента фрагмента при его создании*/
    public static final String ARG_TASK_ID = "task_id";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Выборка аргументов фрагмента*/
        UUID taskID = (UUID) getArguments().getSerializable(ARG_TASK_ID);

        mTask = TaskLab.getTaskLab(getActivity()).getTaskById(taskID);
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

        mEditTextTaskTitle.setText(mTask.getTitle());
        mCheckBoxComplete.setChecked(mTask.isComplete());

        /*На кнопке отображается дата текущего экземпляра*/
        mButtonDate.setText(mTask.getDate().toString());
        /*TODO Кнопка пока заблокирована. Добавить на нее вызов диалогового окна DatePicker*/
        mButtonDate.setEnabled(false);

        return view;
    }

    /*Метод создает экземпляр фрагмента, упаковывает и задает его аргументы*/
    public static TaskFragment newInstance(UUID taskId) {
        /*Дополнения нужно сохранить в объекте Bundle*/
        Bundle args = new Bundle();
        /*В объекте они хранятся в виде пар ключ-значение*/
        args.putSerializable(ARG_TASK_ID, taskId);

        /*Создание фрагмента и прикрепление к нему аргументов*/
        TaskFragment fragment = new TaskFragment();
        fragment.setArguments(args);
        return fragment;
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

        /*Слушатель для ввода статуса задачи*/
        mCheckBoxComplete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                /*Статус задачи устанавливается в зависимости от состояния CheckBox*/
                mTask.setComplete(b);
            }
        });
    }

    /*Метод связывает объекты контроллера с объектами представления*/
    private void findAllViewById(View view) {
        mEditTextTaskTitle = (EditText) view.findViewById(R.id.f_task_details_edit_text_task_title);
        mButtonDate = (Button) view.findViewById(R.id.f_task_details_button_task_date);
        mCheckBoxComplete = (CheckBox) view.findViewById(R.id.f_task_details_check_box_complete);
    }
}
