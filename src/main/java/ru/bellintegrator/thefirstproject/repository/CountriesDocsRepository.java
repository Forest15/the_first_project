package ru.bellintegrator.thefirstproject.repository;

import ru.bellintegrator.thefirstproject.domain.entity.CountryEntity;
import ru.bellintegrator.thefirstproject.domain.entity.DocTypeEntity;

import java.util.List;

public interface CountriesDocsRepository {
    /**
     * Get all the CountryEntity objects;
     *
     * @return List<CountryEntity>
     */
    List<CountryEntity> countriesAll();

    /**
     * Get all the DocTypeEntity objects;
     *
     * @return List<DocTypeEntity>
     */
    List<DocTypeEntity> docsAll();

    /**
     * Get the CountryEntity object by id;
     *
     * @param id
     * @return CountryEntity
     */
    CountryEntity loadCountryById(Long id);

    /**
     * Get the DocTypeEntity object by id;
     *
     * @param id
     * @return DocTypeEntity
     */
    DocTypeEntity loadDocById(Long id);
}
