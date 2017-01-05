package com.developgmail.mitroshin.todo.util;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.developgmail.mitroshin.todo.R;

/*Контроллер для представления activity_main.xml.*/

/*Для использования фрагментов, нужны активности, которые умеют управлять фрагментами.
Для управления фрагментами из библиотеки поддержки используется класс FragmentActivity.*/
public abstract class MainActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        /*Запрос у FragmentManager фрагмента, соответствующего идентификатору.
        Если этот фрагмент уже находится в списке, то FragmentManager возвращает его, иначе null*/
        Fragment fragment =
                fragmentManager.findFragmentById(R.id.a_main_frame_layout_fragment_container);

        /*При воссоздании активности FragmentManager сохранит список фрагментов и вернет уже
        существующий по запросу, но если фрагмент запрашивается в первые, нужно его создать*/
        if (fragment == null) {
            fragment = createFragment();
            /*Создание транзакции фрагмента, включить в нее одну операцию добавления
             и ее закрепление*/
            fragmentManager.beginTransaction().
                    add(R.id.a_main_frame_layout_fragment_container, fragment).commit();
        }
    }
}