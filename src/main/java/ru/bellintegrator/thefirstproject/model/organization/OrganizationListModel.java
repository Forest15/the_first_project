package ru.bellintegrator.thefirstproject.model.organization;

import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.thefirstproject.model.office.OfficeListModel;

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

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;

        if (!(obj instanceof OrganizationListModel))

            return false;

        if (obj == this)

            return true;

        return this.getOrgListModel().get(1).getId() == ((OrganizationListModel) obj).getOrgListModel().get(1).getId();

    }
}
