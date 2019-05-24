package ru.bellintegrator.thefirstproject.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.thefirstproject.domain.model.ResponseModel;
import ru.bellintegrator.thefirstproject.domain.model.office.OfficeBaseModel;
import ru.bellintegrator.thefirstproject.domain.model.office.OfficeCreatingModel;
import ru.bellintegrator.thefirstproject.domain.model.office.OfficeFullModel;
import ru.bellintegrator.thefirstproject.domain.model.office.OfficeRequestModel;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OfficeService {
    /**
     * Get the office list
     *
     * @return {List<OfficeBaseModel>}
     */
    List<OfficeBaseModel> getOfficeList(OfficeRequestModel officeRequestModel);

    /**
     *
     * Get the office by id;
     *
     * @param id
     *
     * @return OfficeFullModel
     */
    public OfficeFullModel getOfficeById(Long id);

    /**
     *
     * Update the office;
     *
     * @param officeUpdatingModel
     *
     * @return ResponseModel
     *
     */
    public ResponseModel updateOffice(OfficeFullModel officeUpdatingModel);

    /**
     * Add new office into DB
     *
     * @param officeCreatingModel
     */
    ResponseModel createOffice
    (@Valid OfficeCreatingModel officeCreatingModel);
}
