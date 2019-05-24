package ru.bellintegrator.thefirstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.thefirstproject.adapter.CountriesDocsAdapter;
import ru.bellintegrator.thefirstproject.domain.entity.CountryEntity;
import ru.bellintegrator.thefirstproject.domain.entity.DocTypeEntity;
import ru.bellintegrator.thefirstproject.domain.model.CountriesDocsBaseModel;
import ru.bellintegrator.thefirstproject.repository.CountriesDocsRepository;

import java.util.List;

@Service
public class CountriesDocsServiceImpl implements CounriesDocsService{

    private final CountriesDocsRepository countriesDocsRepository;
    private final CountriesDocsAdapter countriesDocsAdapter;

    @Autowired
    CountriesDocsServiceImpl(CountriesDocsRepository countriesDocsRepository, CountriesDocsAdapter countriesDocsAdapter){
        this.countriesDocsRepository = countriesDocsRepository;
        this.countriesDocsAdapter = countriesDocsAdapter;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CountriesDocsBaseModel> getCountriesList(){
        List<CountryEntity> countryEntityList = countriesDocsRepository.countriesAll();
        return countriesDocsAdapter.mapAsList(countryEntityList, CountriesDocsBaseModel.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CountriesDocsBaseModel> getDocsList(){
        List<DocTypeEntity> docTypeEntityList = countriesDocsRepository.docsAll();
        return countriesDocsAdapter.mapAsList(docTypeEntityList, CountriesDocsBaseModel.class);
    }

}
