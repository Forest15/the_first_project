package ru.bellintegrator.thefirstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.thefirstproject.adapter.OrganizationAdapterImpl;
import ru.bellintegrator.thefirstproject.domain.entity.OrganizationEntity;
import ru.bellintegrator.thefirstproject.domain.model.*;
import ru.bellintegrator.thefirstproject.domain.model.organization.*;
import ru.bellintegrator.thefirstproject.repository.OrganizationRepository;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationRepository organizationRepository;
    private final OrganizationAdapterImpl organizationAdapter;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository, OrganizationAdapterImpl organizationAdapter) {
        this.organizationRepository = organizationRepository;
        this.organizationAdapter = organizationAdapter;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationBaseModel> getOrgList(OrganizationRequestModel orgRequestModel){

        List<OrganizationEntity> organizationBaseModelsList = organizationRepository.all(orgRequestModel);
        return organizationAdapter.mapAsList(organizationBaseModelsList, OrganizationBaseModel.class);
    }

    @Override
    @Transactional(readOnly = true)
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
                organizationCreatingModel.getName(),
                organizationCreatingModel.getIsActive(),
                organizationCreatingModel.getFullName(),
                organizationCreatingModel.getInn(),
                organizationCreatingModel.getKpp(),
                organizationCreatingModel.getAddress(),
                organizationCreatingModel.getPhone()
                );
        organizationRepository.save(organizationEntity);
        return new ResponseModel.Builder().result("success").build();
    }

}
