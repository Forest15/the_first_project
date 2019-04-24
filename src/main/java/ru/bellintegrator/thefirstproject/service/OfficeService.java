package ru.bellintegrator.thefirstproject.service;

import org.springframework.stereotype.Service;
import ru.bellintegrator.thefirstproject.model.office.OfficeListModel;
import ru.bellintegrator.thefirstproject.model.office.OfficeBaseModel;
import ru.bellintegrator.thefirstproject.model.office.OfficeRequestModel;
import ru.bellintegrator.thefirstproject.model.organization.OrganizationBaseModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfficeService {

    public OfficeListModel getOfficeList(OfficeRequestModel officeRequestModel){
        List<OfficeBaseModel> officeBaseModelList = new ArrayList<OfficeBaseModel>();
        officeBaseModelList.add(new OfficeBaseModel.Builder().id(1L).name("BeelineTechOffice").isActive("1").build());
        officeBaseModelList.add(new OfficeBaseModel.Builder().id(2L).name("BeelineSalesOffice").isActive("1").build());
        OfficeListModel officeListModel = new OfficeListModel();
        officeListModel.setOfficeBaseModelList(officeBaseModelList);
        return officeListModel;
    }

}
