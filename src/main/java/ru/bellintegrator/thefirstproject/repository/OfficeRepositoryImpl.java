package ru.bellintegrator.thefirstproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.thefirstproject.domain.entity.OfficeEntity;
import ru.bellintegrator.thefirstproject.domain.model.office.OfficeFullModel;
import ru.bellintegrator.thefirstproject.domain.model.office.OfficeRequestModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OfficeRepositoryImpl implements OfficeRepository{
    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public OfficeRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<OfficeEntity> all(OfficeRequestModel officeRequestModel){

        CriteriaQuery<OfficeEntity> officeCriteriaQuery = getCriteriaQuery(officeRequestModel.getOrgId(), officeRequestModel.getName(), officeRequestModel.getPhone(), officeRequestModel.getIsActive());
        TypedQuery<OfficeEntity> officeEntityTypedQuery = em.createQuery(officeCriteriaQuery);

        return officeEntityTypedQuery.getResultList();

    }

    @Override
    public OfficeEntity loadById(Long id){
        return em.find(OfficeEntity.class, id);
    }

    @Override
    public Integer update(OfficeFullModel officeFullModel){
        Query query = em.createQuery("UPDATE OfficeEntity oe" +
                " SET oe.name = :name," +
                " oe.isActive = :isActive," +
                " oe.address = :address," +
                " oe.officePhone = :officePhone" +
                " WHERE oe.id = :id ");
        query.setParameter("id", officeFullModel.getId());
        query.setParameter("name", officeFullModel.getName());
        query.setParameter("isActive", officeFullModel.getIsActive());
        query.setParameter("address", officeFullModel.getAddress());
        query.setParameter("officePhone", officeFullModel.getPhone());
        int result = query.executeUpdate();
        return result;
    }

    @Override
    public void save(OfficeEntity officeEntity){
        em.persist(officeEntity);
    }

    private CriteriaQuery<OfficeEntity> getCriteriaQuery(Long orgId, String name, String phone, Boolean isActive){

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<OfficeEntity> officeCriteriaQuery = criteriaBuilder.createQuery(OfficeEntity.class);
        Root<OfficeEntity> root = officeCriteriaQuery.from(OfficeEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(root.get("organization").get("id"), orgId));
        if(name != null) {
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
        }
        if(phone != null) {
            predicates.add(criteriaBuilder.like(root.get("officePhone"), "%" + phone + "%"));
        }
        if(isActive != null){
            predicates.add(criteriaBuilder.equal(root.get("isActive"), isActive));
        }
        officeCriteriaQuery.select(criteriaBuilder.construct(
                OfficeEntity.class,
                root.get("id"),
                root.get("name"),
                root.get("isActive"))
        ).where(predicates.toArray(new Predicate[]{}));
        return officeCriteriaQuery;
    }
}
