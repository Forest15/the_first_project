package ru.bellintegrator.thefirstproject.service;

import org.springframework.stereotype.Service;
import ru.bellintegrator.thefirstproject.model.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationService {

    public OrganizationListModel getOrgList(OrganizationRequestModel orgRequestModel){
        List<OrganizationBaseModel> orgBaseModelList = new ArrayList<OrganizationBaseModel>();
        orgBaseModelList.add(new OrganizationBaseModel.Builder().id(1L).name("Beeline").isActive("1").build());
        orgBaseModelList.add(new OrganizationBaseModel.Builder().id(2L).name("MTS").isActive("1").build());
        orgBaseModelList.add(new OrganizationBaseModel.Builder().id(3L).name("Megafon").isActive("1").build());
        OrganizationListModel orgListModel = new OrganizationListModel();
        orgListModel.setOrgListModel(orgBaseModelList);
        return orgListModel;
    }

    public OrganizationFullModel getOrgById(Long id){
        return new OrganizationFullModel.Builder().fullName("Vimpelcom").inn("111111111111").kpp("111111111").address("ул. 8-го марта").phone("84959999990").id(1L).name("Beeline").isActive("1").build();
    }

    public ResponseModel updateOrganization(OrganizationFullModel orgUpdatingModel){
        return new ResponseModel.Builder().result("success").build();
    }

    public ResponseModel createOrganization(OrganizationCreatingModel orgFullModel){
        return new ResponseModel.Builder().result("success").build();
    }

}
