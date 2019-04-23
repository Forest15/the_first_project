package ru.bellintegrator.thefirstproject.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class OrganizationListModel implements Serializable {
    @ApiModelProperty(notes = "The list of the organization model", required = true)
    public List<OrganizationBaseModel> orgListModel;

    public List<OrganizationBaseModel> getOrgListModel() {
        return orgListModel;
    }

    public void setOrgListModel(List<OrganizationBaseModel> orgListModel) {
        this.orgListModel = orgListModel;
    }
}
