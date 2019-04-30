package ru.bellintegrator.thefirstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.thefirstproject.entity.OrganizationEntity;
import ru.bellintegrator.thefirstproject.model.*;
import ru.bellintegrator.thefirstproject.model.organization.*;
import ru.bellintegrator.thefirstproject.repository.OrganizationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }

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
        Optional<OrganizationEntity> organizationEntityOptional = organizationRepository.findById(id);
        if (organizationEntityOptional.isPresent()){
            OrganizationEntity organizationEntity = organizationEntityOptional.get();
            return new OrganizationFullModel.Builder().id(organizationEntity.getId()).name(organizationEntity.getName()).isActive(organizationEntity.getIsActive()).fullName(organizationEntity.getFullName()).inn(organizationEntity.getInn()).kpp(organizationEntity.getKpp()).address(organizationEntity.getAddress()).phone(organizationEntity.getPhone()).build();}
            return new OrganizationFullModel();
        //return new OrganizationFullModel.Builder().fullName("Vimpelcom").inn("111111111111").kpp("111111111").address("ул. 8-го марта").phone("84959999990").id(1L).name("Beeline").isActive("1").build();
    }

    public ResponseModel updateOrganization(OrganizationFullModel orgUpdatingModel){
        return new ResponseModel.Builder().result("success").build();
    }

    public ResponseModel createOrganization(OrganizationCreatingModel orgFullModel){
        return new ResponseModel.Builder().result("success").build();
    }

}
