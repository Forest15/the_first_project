package ru.bellintegrator.thefirstproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.thefirstproject.domain.entity.OrganizationEntity;
import ru.bellintegrator.thefirstproject.domain.model.organization.OrganizationFullModel;
import ru.bellintegrator.thefirstproject.domain.model.organization.OrganizationRequestModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;
@Repository
public class OrganizationRepositoryImpl implements OrganizationRepository {

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public OrganizationRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<OrganizationEntity> all(OrganizationRequestModel orgRequestModel){

        CriteriaQuery<OrganizationEntity> organizationEntityCriteriaQuery = getCriteriaQuery(orgRequestModel.getOrgName(), orgRequestModel.getInn(), orgRequestModel.getIsActive());
        TypedQuery<OrganizationEntity> organizationEntityTypedQuery = em.createQuery(organizationEntityCriteriaQuery);


        /*TypedQuery<OrganizationEntity> query = em.createQuery("SELECT orge FROM OrganizationEntity orge WHERE orge.name = :name AND orge.inn = :inn AND orge.isActive = :isActive", OrganizationEntity.class);

        query.setParameter("name",orgRequestModel.getOrgName());
        query.setParameter("inn",orgRequestModel.getInn());
        query.setParameter("isActive", orgRequestModel.getIsActive());*/

        return organizationEntityTypedQuery.getResultList();
    }

    @Override
    public OrganizationEntity loadById(Long id){
        return em.find(OrganizationEntity.class, id);
    }

    @Override
    public Integer update(OrganizationFullModel organizationFullModel){
            Query query = em.createQuery("UPDATE OrganizationEntity oe" +
                    " SET oe.name = :name," +
                    " oe.isActive = :isActive," +
                    " oe.fullName = :fullName," +
                    " oe.inn = :inn," +
                    " oe.kpp = :kpp," +
                    " oe.address = :address," +
                    " oe.phone = :phone" +
                    " WHERE oe.id = :id ");
            query.setParameter("id", organizationFullModel.getId());
            query.setParameter("name", organizationFullModel.getName());
            query.setParameter("isActive", organizationFullModel.getIsActive());
            query.setParameter("fullName", organizationFullModel.getFullName());
            query.setParameter("inn", organizationFullModel.getInn());
            query.setParameter("kpp", organizationFullModel.getKpp());
            query.setParameter("address", organizationFullModel.getAddress());
            query.setParameter("phone", organizationFullModel.getPhone());
            int result = query.executeUpdate();
            return result;
    }

    @Override
    public void save(OrganizationEntity organizationEntity){
        em.persist(organizationEntity);
    }

    private CriteriaQuery<OrganizationEntity> getCriteriaQuery(String name, String inn, Boolean isActive){

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<OrganizationEntity> organizationCriteriaQuery = criteriaBuilder.createQuery(OrganizationEntity.class);
        Root<OrganizationEntity> root = organizationCriteriaQuery.from(OrganizationEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(name != null) {
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
        }
        if(inn != null) {
            predicates.add(criteriaBuilder.like(root.get("inn"), "%" + inn + "%"));
        }
        if(isActive != null){
            predicates.add(criteriaBuilder.equal(root.get("isActive"), isActive));
        }
        organizationCriteriaQuery.select(criteriaBuilder.construct(
                OrganizationEntity.class,
                root.get("id"),
                root.get("name"),
                root.get("isActive"))
        ).where(predicates.toArray(new Predicate[]{}));
        return organizationCriteriaQuery;
    }

}
