package com.example.todoapp.controllers;

import com.example.todoapp.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private TodoItemService todoItemService;

    @Autowired
    public HomeController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("todoItems", todoItemService.findAll());
        return "index";
    }
}
