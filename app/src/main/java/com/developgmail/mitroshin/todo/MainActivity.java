package com.developgmail.mitroshin.todo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/*Контроллер для представления activity_main.xml.*/

public abstract class MainActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment =
                fragmentManager.findFragmentById(R.id.a_main_frame_layout_fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction().
                    add(R.id.a_main_frame_layout_fragment_container, fragment).commit();
        }
    }
}