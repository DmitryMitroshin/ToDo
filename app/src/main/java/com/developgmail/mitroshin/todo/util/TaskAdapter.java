package com.developgmail.mitroshin.todo.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developgmail.mitroshin.todo.R;
import com.developgmail.mitroshin.todo.controllers.TaskListFragment;
import com.developgmail.mitroshin.todo.model.Task;

import java.util.List;

/*Объект контроллера, который находится между RecyclerView и набором данных с информацией,
которую должен вывести RecyclerView. Адаптер создает необходимые объекты ViewHolder и связывает
их с данными модели.*/

public class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {

    /*Ссылка на список объектов модели*/
    private List<Task> mListTask;

    /*Так как Adapter реализован не в виде вложенного класса,
    а отдельно, то нужно указать активность,
    выполняющую роль хоста фрагмента, который отображает список.*/
    private TaskListFragment mTaskListFragment;

    public TaskAdapter(List<Task> listTask, TaskListFragment taskListFragment) {
        mListTask = listTask;
        mTaskListFragment = taskListFragment;
    }


    /*RecyclerView вызывает данный метод,
    когда необходимо создать новое представление для отображения элемента.
    Здесь создается новый объект View элемента списка и упаковывается во ViewHolder*/
    @Override
    public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mTaskListFragment.getActivity());
        /*Заполнение макета отдельного элемента списка. */
        /* TODO Шаблон взят из стандартной библиотеки*/
        View view = layoutInflater.inflate(R.layout.item_task, parent, false);
        return new TaskHolder(view);
    }

    /*Данный метод связывает представление View объекта ViewHolder с объектом модели из списка,
    зная позицию в списке нужного объекта*/
    @Override
    public void onBindViewHolder(TaskHolder holder, int position) {
        Task task = mListTask.get(position);
        holder.bindTask(task);
    }

    @Override
    public int getItemCount() {
        return mListTask.size();
    }
}
