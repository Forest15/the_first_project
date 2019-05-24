package ru.bellintegrator.thefirstproject.service;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.thefirstproject.domain.model.CountriesDocsBaseModel;

import java.util.List;

@Validated
public interface CounriesDocsService {
    /**
     * Get the countries list
     *
     * @return {List<CountryBaseModel>}
     */
    List<CountriesDocsBaseModel> getCountriesList();

    /**
     * Get the documents list
     *
     * @return {List<CountriesDocsBaseModel>}
     */
    List<CountriesDocsBaseModel> getDocsList();
}
