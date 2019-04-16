package ru.bellintegrator.thefirstproject.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.thefirstproject.model.CountryModel;

@RestController
@RequestMapping(value = "/project", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController{

    @GetMapping(value = "/country")
    @ApiOperation(value = "Get country", tags = "Country")
    public CountryModel theFirstProject(){
        return new CountryModel();
    }
}