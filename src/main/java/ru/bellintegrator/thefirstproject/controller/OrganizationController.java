package ru.bellintegrator.thefirstproject.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.thefirstproject.model.*;
import ru.bellintegrator.thefirstproject.model.organization.OrganizationCreatingModel;
import ru.bellintegrator.thefirstproject.model.organization.OrganizationFullModel;
import ru.bellintegrator.thefirstproject.model.organization.OrganizationListModel;
import ru.bellintegrator.thefirstproject.model.organization.OrganizationRequestModel;
import ru.bellintegrator.thefirstproject.service.OrganizationService;

@RestController
@RequestMapping(path = "api/organization", produces = "application/json")
public class OrganizationController {

    @Autowired
    private OrganizationService orgService;

    @PostMapping(value = "/list")
    @ApiOperation(value = "Request the organization list with filter", tags = "Organization")
    public OrganizationListModel getOrgList(OrganizationRequestModel orgRequestModel){
        return orgService.getOrgList(orgRequestModel);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get organization card by id", tags = "Organization")
    public OrganizationFullModel getOrgById(@PathVariable("id") Long id) {
        return orgService.getOrgById(id);
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "The update of the organization details", tags = "Organization")
    public ResponseModel updateOrganization(OrganizationFullModel orgUpdatingModel){
        return orgService.updateOrganization(orgUpdatingModel);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "The creation of the organization", tags = "Organization")
    public ResponseModel createOrganization(OrganizationCreatingModel orgFullModel){
        return orgService.createOrganization(orgFullModel);
    }
}