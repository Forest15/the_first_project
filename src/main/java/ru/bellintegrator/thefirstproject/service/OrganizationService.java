package ru.bellintegrator.thefirstproject.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.thefirstproject.domain.model.ResponseModel;
import ru.bellintegrator.thefirstproject.domain.model.organization.*;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OrganizationService {
    /**
     * Get the organization list
     *
     * @return {List<OrganizationBaseModel>}
     */
    List<OrganizationBaseModel> getOrgList(OrganizationRequestModel organizationRequestModel);

    /**
     *
     * Get the organization by id;
     *
     * @param id
     *
     * @return OrganizationFullModel
     */
    public OrganizationFullModel getOrgById(Long id);

    /**
     *
     * Update the organization;
     *
     * @param orgUpdatingModel
     *
     * @return ResponseModel
     *
     */
    public ResponseModel updateOrganization(OrganizationFullModel orgUpdatingModel);

    /**
     * Add new organization into DB
     *
     * @param organizationCreatingModel
     */
    ResponseModel createOrganization(@Valid OrganizationCreatingModel organizationCreatingModel);
}