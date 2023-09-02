package com.example.todoapp.controllers;

import com.example.todoapp.entities.TodoItem;
import com.example.todoapp.service.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoFormController {

    private TodoItemService todoItemService;

    @Autowired
    public TodoFormController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping("/create-todo")
    public String showCreateForm(Model model){
        TodoItem todoItem = new TodoItem();
        model.addAttribute("todoItem", todoItem);
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model){
        TodoItem item = new TodoItem();
        item.setDescription(todoItem.getDescription());
        item.setComplete(todoItem.isComplete());

        todoItemService.save(item);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteTodoItem(@RequestParam("id") int id, Model model){
        todoItemService.deleteById(id);

        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showUpdateForm(@RequestParam("id") int id, Model model){
        TodoItem todoItem = todoItemService.findById(id);

        if (todoItem == null){
            throw new RuntimeException("Item not found");
        }
        model.addAttribute("todo", todoItem);
        return "edit-todo-item";
    }

    @PostMapping("/todo-update")
    public String updateTodoItem(@RequestParam("id") int id, @Valid TodoItem todoItem, BindingResult result, Model model){
        TodoItem item = todoItemService.findById(id);

        item.setComplete(todoItem.isComplete());
        item.setDescription(todoItem.getDescription());

        todoItemService.save(item);
        return "redirect:/";
    }
}
