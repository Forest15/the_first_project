package ru.bellintegrator.thefirstproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.thefirstproject.domain.entity.OrganizationEntity;
import ru.bellintegrator.thefirstproject.domain.model.organization.OrganizationFullModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
    public List<OrganizationEntity> all(){
        TypedQuery<OrganizationEntity> query = em.createQuery("SELECT orge FROM OrganizationEntity orge", OrganizationEntity.class);
        return query.getResultList();
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
}
