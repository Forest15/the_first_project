package ru.bellintegrator.thefirstproject.repository;

import ru.bellintegrator.thefirstproject.domain.entity.OrganizationEntity;
import ru.bellintegrator.thefirstproject.domain.model.organization.OrganizationFullModel;

import java.util.List;

public interface OrganizationRepository {
    /**
     * Get all the OrganizationEntity objects;
     *
     * @return List<OrganizationEntity>
     */
    List<OrganizationEntity> all();

    /**
     * Get the OrganizationEntity object by id;
     *
     * @param id
     * @return OrganizationEntity
     */
    OrganizationEntity loadById(Long id);

    /**
     * Update the organizationEntity object;
     * @param organizationFullModel
     */
    Integer update(OrganizationFullModel organizationFullModel);

    /**
     * Save the OrganizationEntity object;
     *
     * @param organizationEntity
     */
    void save(OrganizationEntity organizationEntity);
}
