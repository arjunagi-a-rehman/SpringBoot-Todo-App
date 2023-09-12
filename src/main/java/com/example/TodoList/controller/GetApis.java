package com.example.TodoList.controller;

import com.example.TodoList.Entities.Status;
import com.example.TodoList.Entities.Todo;
import com.example.TodoList.Services.CuredServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class GetApis {
    @Autowired
    CuredServices services;

    @GetMapping("/todo/startedTask")
    public ArrayList<Todo> startedTasks(@RequestParam Status status){
        return services.recordsWithStarted(status);
    }

    @GetMapping("/todo/mytasks")
    public HashMap<String, Todo> getList(){
        return services.getAll();
    }

    @GetMapping("/todo/status/{title}")
    public String getStatus(@PathVariable String title){
        if(!services.checkTitel(title))return "wrong op";
        return services.getStatus(title).toString();
    }
}