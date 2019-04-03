package ru.bellintegrator.thefirstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController{

    @RequestMapping(value = "/project")
    public String theFirstProject(){
        return "The First Project";
    }
}