package com.example.todoapp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "todo_item")
@Data
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "is_complete")
    private boolean isComplete;
}
