package ru.bellintegrator.thefirstproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.thefirstproject.domain.entity.CountryEntity;
import ru.bellintegrator.thefirstproject.domain.entity.DocTypeEntity;
import ru.bellintegrator.thefirstproject.domain.entity.OfficeEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CountriesDocsRepositoryImpl implements CountriesDocsRepository {

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public CountriesDocsRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CountryEntity> countriesAll(){
        TypedQuery<CountryEntity> query = em.createQuery("SELECT ce FROM CountryEntity ce", CountryEntity.class);
        return query.getResultList();
    }

    @Override
    public List<DocTypeEntity> docsAll(){
        TypedQuery<DocTypeEntity> query = em.createQuery("SELECT dte FROM DocTypeEntity dte", DocTypeEntity.class);
        return query.getResultList();
    }

    @Override
    public CountryEntity loadCountryById(Long id){
        return em.find(CountryEntity.class, id);
    }

    @Override
    public DocTypeEntity loadDocById(Long id){
        return em.find(DocTypeEntity.class, id);
    }

}
