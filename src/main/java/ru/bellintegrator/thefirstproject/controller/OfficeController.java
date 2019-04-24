package ru.bellintegrator.thefirstproject.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.thefirstproject.model.office.OfficeListModel;
import ru.bellintegrator.thefirstproject.model.office.OfficeRequestModel;
import ru.bellintegrator.thefirstproject.service.OfficeService;

@RestController
@RequestMapping(path = "api/office", produces = "application/json")
public class OfficeController {
    @Autowired
    private OfficeService officeService;

    @PostMapping(value = "/list")
    @ApiOperation(value = "Request the office list with filter", tags = "Office")
    public OfficeListModel getOfficeList(OfficeRequestModel officeRequestModel){
        return officeService.getOfficeList(officeRequestModel);
    }
/*
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get organization card by id", tags = "Organization")
    public OrganizationFullModel getOrgById(@PathVariable("id") Long id) {
        return orgService.getOrgById(id);
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "The update of the organization details")
    public ResponseModel updateOrganization(OrganizationFullModel orgUpdatingModel){
        return orgService.updateOrganization(orgUpdatingModel);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "The creation of the organization", tags = "Organization")
    public ResponseModel createOrganization(OrganizationCreatingModel orgFullModel){
        return orgService.createOrganization(orgFullModel);
    }*/

}
