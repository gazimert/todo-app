package com.example.todoapp.service;

import com.example.todoapp.entities.TodoItem;

import java.util.List;

public interface TodoItemService {
    void save(TodoItem todoItem);

    TodoItem findById(int id);

    List<TodoItem> findAll();

    void deleteById(int id);
}
