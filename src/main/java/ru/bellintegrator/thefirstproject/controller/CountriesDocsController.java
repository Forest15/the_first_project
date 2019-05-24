package ru.bellintegrator.thefirstproject.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.thefirstproject.domain.model.CountriesDocsBaseModel;
import ru.bellintegrator.thefirstproject.service.CountriesDocsServiceImpl;

import java.util.List;

@RestController
@RequestMapping(path = "api", produces = "application/json")
public class CountriesDocsController {

    private final CountriesDocsServiceImpl countriesDocsService;

    @Autowired
    public CountriesDocsController(CountriesDocsServiceImpl countriesDocsService){
        this.countriesDocsService = countriesDocsService;
    }

    @GetMapping(value = "/countries")
    @ApiOperation(value = "Request the countries list", tags = "Countries")
    public List<CountriesDocsBaseModel> getCountriesList(){
        return countriesDocsService.getCountriesList();
    }

    @GetMapping(value = "/docs")
    @ApiOperation(value = "Request the docs list", tags = "Documents")
    public List<CountriesDocsBaseModel> getDocsList(){
        return countriesDocsService.getDocsList();
    }
}
