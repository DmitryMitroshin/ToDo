package com.developgmail.mitroshin.todo.model;

/*Класс модели. Хранит информацию о задачах пользователя*/

import java.util.Date;
import java.util.UUID;

public class Task {

    /*Уникальный идентификатор задачи*/
    private UUID mUUID;
    /*Заголовок задачи*/
    private String mTitle;
    /*Дата. Задается пользователем*/
    private Date mDate;
    /*Статус выполнения задачи*/
    private boolean mComplete;

    /*Конструктор. При создании экземпляра класса,
    ему необходимо присвоить уникальный идентификатор*/

    public Task() {
        /*Уникальный идентификатор генерируется случайным образом*/
        mUUID = UUID.randomUUID();
        /*Инициализация с помощью текущей даты*/
        mDate = new Date();
    }

    /*Метод для чтения заголовка задачи.*/
    public String getTitle() {
        return mTitle;
    }

    /*Метод для записи заголовка задачи. Необходим, так как задается пользователем.*/
    public void setTitle(String title) {
        mTitle = title;
    }

    /*Метод для чтения уникального идентификатора задачи.
    Так как уникальный идентификатор присваивается при создании новой задачи,
    отпадает необходимость в методе для записи в данное поле.*/
    public UUID getUUID() {
        return mUUID;
    }

    /*Метод для чтения даты задачи.*/
    public Date getDate() {
        return mDate;
    }

    /*Метод для записи даты задачи*/
    public void setDate(Date date) {
        mDate = date;
    }

    /*Метод для чтения статуса задачи.*/
    public boolean isComplete() {
        return mComplete;
    }

    /*Метод для записи статуса задачи*/
    public void setComplete(boolean complete) {
        mComplete = complete;
    }
}
