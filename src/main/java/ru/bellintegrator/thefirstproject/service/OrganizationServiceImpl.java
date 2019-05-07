package ru.bellintegrator.thefirstproject.service;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.thefirstproject.adapter.Adapter;
import ru.bellintegrator.thefirstproject.domain.entity.OrganizationEntity;
import ru.bellintegrator.thefirstproject.domain.model.*;
import ru.bellintegrator.thefirstproject.domain.model.organization.*;
import ru.bellintegrator.thefirstproject.repository.OrganizationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationRepository organizationRepository;
    private final Adapter adapter;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository, Adapter adapter) {
        this.organizationRepository = organizationRepository;
        this.adapter = adapter;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationBaseModel> getOrgList(OrganizationRequestModel orgRequestModel){

        List<OrganizationEntity> organizationBaseModelsList = organizationRepository.all();
        return adapter.mapAsList(organizationBaseModelsList, OrganizationBaseModel.class);
    }

    @Override
    @Transactional
    public OrganizationFullModel getOrgById(Long id){
        OrganizationEntity organizationEntity = organizationRepository.loadById(id);
        return new OrganizationFullModel.Builder().
                id(organizationEntity.getId()).
                name(organizationEntity.getName()).
                isActive(organizationEntity.getIsActive()).
                fullName(organizationEntity.getFullName()).
                inn(organizationEntity.getInn()).
                kpp(organizationEntity.getKpp()).
                address(organizationEntity.getAddress()).
                phone(organizationEntity.getPhone()).
                build();
    }

    @Override
    @Transactional
    public ResponseModel updateOrganization(OrganizationFullModel organizationFullModel){

        organizationRepository.update(organizationFullModel);
        return new ResponseModel.Builder().result("success").build();
    }

    @Override
    @Transactional
    public ResponseModel createOrganization(OrganizationCreatingModel organizationCreatingModel){
        OrganizationEntity organizationEntity = new OrganizationEntity(
                organizationCreatingModel.orgName,
                organizationCreatingModel.isActive,
                organizationCreatingModel.fullName,
                organizationCreatingModel.inn,
                organizationCreatingModel.kpp,
                organizationCreatingModel.address,
                organizationCreatingModel.phone
                );
        organizationRepository.save(organizationEntity);
        return new ResponseModel.Builder().result("success").build();
    }

}
