package ru.bellintegrator.thefirstproject.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.thefirstproject.domain.model.ResponseModel;
import ru.bellintegrator.thefirstproject.domain.model.office.*;
import ru.bellintegrator.thefirstproject.service.OfficeService;
import ru.bellintegrator.thefirstproject.service.OfficeServiceImpl;

import java.util.List;

@RestController
@RequestMapping(path = "api/office", produces = "application/json")
public class OfficeController {
    private final OfficeService officeService;

    @Autowired
    public  OfficeController( OfficeService  officeService){
        this. officeService =  officeService;
    }

    @PostMapping(value = "/list")
    @ApiOperation(value = "Request the  office list with filter", tags = " Office")
    public List<OfficeBaseModel> getOfficeList(@RequestBody OfficeRequestModel officeRequestModel){
        List<OfficeBaseModel> obm = officeService.getOfficeList(officeRequestModel);
        return obm;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get  office card by id", tags = " Office")
    public OfficeFullModel getOfficeById(@PathVariable("id") Long id) {
        return  officeService.getOfficeById(id);
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "The update of the  office details", tags = " Office")
    public ResponseModel updateOffice(@RequestBody OfficeFullModel orgUpdatingModel){
        return  officeService.updateOffice(orgUpdatingModel);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "The creation of the  office", tags = " Office")
    public ResponseModel createOffice(@RequestBody OfficeCreatingModel officeCreatingModel){
        return  officeService.createOffice( officeCreatingModel);
    }

}
