package com.example.todoapp.service;

import com.example.todoapp.entities.TodoItem;
import com.example.todoapp.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemServiceImpl implements TodoItemService{

    private TodoItemRepository todoItemRepository;

    @Autowired
    public TodoItemServiceImpl(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @Override
    public void save(TodoItem todoItem) {
        todoItemRepository.save(todoItem);
    }

    @Override
    public TodoItem findById(int id) {
        Optional<TodoItem> result = todoItemRepository.findById(id);

        TodoItem theTodoItem = null;

        if (result.isPresent()) {
            theTodoItem = result.get();
        }
        else {
            throw new RuntimeException("Did not find todo id - " + id);
        }

        return theTodoItem;
    }

    @Override
    public List<TodoItem> findAll() {
        return todoItemRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        todoItemRepository.deleteById(id);
    }
}
