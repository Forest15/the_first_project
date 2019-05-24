package ru.bellintegrator.thefirstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.thefirstproject.adapter.OfficeAdapterImpl;
import ru.bellintegrator.thefirstproject.domain.entity.OfficeEntity;
import ru.bellintegrator.thefirstproject.domain.model.ResponseModel;
import ru.bellintegrator.thefirstproject.domain.model.office.*;
import ru.bellintegrator.thefirstproject.repository.OfficeRepository;
import ru.bellintegrator.thefirstproject.repository.OrganizationRepository;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService{

    private final OfficeRepository officeRepository;
    private final OrganizationRepository organizationRepository;
    private final OfficeAdapterImpl officeAdapter;

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository, OfficeAdapterImpl officeAdapter, OrganizationRepository organizationRepository) {
        this.officeRepository = officeRepository;
        this.organizationRepository = organizationRepository;
        this.officeAdapter = officeAdapter;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeBaseModel> getOfficeList(OfficeRequestModel orgRequestModel){

        List<OfficeEntity> officeEntityList = officeRepository.all(orgRequestModel);
        List<OfficeBaseModel> obm = officeAdapter.mapAsList(officeEntityList, OfficeBaseModel.class);
        return obm;
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeFullModel getOfficeById(Long id){
        OfficeEntity officeEntity = officeRepository.loadById(id);
        return new OfficeFullModel.Builder().
                id(officeEntity.getId()).
                name(officeEntity.getName()).
                isActive(officeEntity.getIsActive()).
                address(officeEntity.getAddress()).
                phone(officeEntity.getOfficePhone()).
                build();
    }

    @Override
    @Transactional
    public ResponseModel updateOffice(OfficeFullModel officeFullModel){

        officeRepository.update(officeFullModel);
        return new ResponseModel.Builder().result("success").build();
    }

    @Override
    @Transactional
    public ResponseModel createOffice(OfficeCreatingModel officeCreatingModel){
        OfficeEntity officeEntity = new OfficeEntity(
                organizationRepository.loadById(officeCreatingModel.getOrgId()),
                officeCreatingModel.getName(),
                officeCreatingModel.getAddress(),
                officeCreatingModel.getPhone(),
                officeCreatingModel.getIsActive()
        );
        officeRepository.save(officeEntity);
        return new ResponseModel.Builder().result("success").build();
    }

}
