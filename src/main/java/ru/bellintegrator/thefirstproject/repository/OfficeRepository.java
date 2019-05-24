package ru.bellintegrator.thefirstproject.repository;

import ru.bellintegrator.thefirstproject.domain.entity.OfficeEntity;
import ru.bellintegrator.thefirstproject.domain.model.office.OfficeFullModel;
import ru.bellintegrator.thefirstproject.domain.model.office.OfficeRequestModel;

import java.util.List;

public interface OfficeRepository {

    /**
     * Get all the OfficeEntity objects;
     *
     * @return List<OfficeEntity>
     */
    List<OfficeEntity> all(OfficeRequestModel officeRequestModel);

    /**
     * Get the OfficeEntity object by id;
     *
     * @param id
     * @return OfficeEntity
     */
    OfficeEntity loadById(Long id);

    /**
     * Update the officeEntity object;
     * @param officeFullModel
     */
    Integer update(OfficeFullModel officeFullModel);

    /**
     * Save the OfficeEntity object;
     *
     * @param officeEntity
     */
    void save(OfficeEntity officeEntity);
}
