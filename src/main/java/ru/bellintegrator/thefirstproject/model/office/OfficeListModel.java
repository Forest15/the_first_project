package ru.bellintegrator.thefirstproject.model.office;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class OfficeListModel implements Serializable {
    @ApiModelProperty(notes = "The list of the base office model", required = true)
    public List<OfficeBaseModel> officeBaseModelList;

    public List<OfficeBaseModel> getOfficeBaseModelList() {
        return officeBaseModelList;
    }

    public void setOfficeBaseModelList(List<OfficeBaseModel> officeBaseModelList) {
        this.officeBaseModelList = officeBaseModelList;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;

        if (!(obj instanceof OfficeListModel))

            return false;

        if (obj == this)

            return true;

        return this.getOfficeBaseModelList().get(1).getId() == ((OfficeListModel) obj).getOfficeBaseModelList().get(1).getId();

    }
}
