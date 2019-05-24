package ru.bellintegrator.thefirstproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.thefirstproject.domain.entity.UserEntity;
import ru.bellintegrator.thefirstproject.domain.model.user.UserRequestModel;
import ru.bellintegrator.thefirstproject.domain.model.user.UserUpdateModel;

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
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<UserEntity> all(UserRequestModel userRequestModel){

        CriteriaQuery<UserEntity> userCriteriaQuery = getCriteriaQuery(userRequestModel.getOfficeId(), userRequestModel.getFirstName(), userRequestModel.getLastName(), userRequestModel.getMiddleName(), userRequestModel.getPosition(), userRequestModel.getCitizenshipCode());
        TypedQuery<UserEntity> userEntityTypedQuery = em.createQuery(userCriteriaQuery);

        return userEntityTypedQuery.getResultList();
    }

    @Override
    public UserEntity loadById(Long id){
        UserEntity ue = em.find(UserEntity.class, id);
        return ue;
    }

    @Override
    public Integer update(UserUpdateModel userUpdateModel){
        Query query = em.createNativeQuery("UPDATE tfp.user u" +
                " SET u.office_id = :officeId," +
                " u.country_id = :countryId," +
                " u.first_name = :firstName," +
                " u.second_name = :lastName," +
                " u.middle_name = :middleName," +
                " u.position = :position," +
                " u.user_phone = :userPhone," +
                " u.is_identified = :isIdentified" +
                " WHERE u.id = :id ");
        query.setParameter("id", userUpdateModel.getId());
        query.setParameter("countryId", userUpdateModel.getCitizenshipId());
        query.setParameter("officeId", userUpdateModel.getOfficeId());
        query.setParameter("firstName", userUpdateModel.getFirstName());
        query.setParameter("lastName", userUpdateModel.getLastName());
        query.setParameter("middleName", userUpdateModel.getMiddleName());
        query.setParameter("position", userUpdateModel.getPosition());
        query.setParameter("userPhone", userUpdateModel.getPhone());
        query.setParameter("isIdentified", userUpdateModel.getIsIdentified());
        int result = query.executeUpdate();
        return result;
    }

    @Override
    public void save(UserEntity userEntity){
        em.persist(userEntity);
    }

    private CriteriaQuery<UserEntity> getCriteriaQuery(Long officeId, String firstName, String lastName, String middleName, String position, String citizenshipCode){

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> userCriteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> root = userCriteriaQuery.from(UserEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.equal(root.get("office").get("id"), officeId));
        predicates.add(criteriaBuilder.equal(root.get("country").get("code"), citizenshipCode));

        if(firstName != null) {
            predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%"));
        }
        if(lastName != null) {
            predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%"));
        }
        if(middleName != null) {
            predicates.add(criteriaBuilder.like(root.get("middleName"), "%" + middleName + "%"));
        }
        if(position != null) {
            predicates.add(criteriaBuilder.like(root.get("position"), "%" + position + "%"));
        }

        userCriteriaQuery.select(criteriaBuilder.construct(
                UserEntity.class,
                root.get("id"),
                root.get("firstName"),
                root.get("lastName"),
                root.get("middleName"),
                root.get("position"))
        ).where(predicates.toArray(new Predicate[]{}));
        return userCriteriaQuery;
    }
}
