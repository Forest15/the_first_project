package ru.bellintegrator.thefirstproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.thefirstproject.domain.entity.UserDocEntity;
import ru.bellintegrator.thefirstproject.domain.model.userDoc.UserDocBaseModel;
import ru.bellintegrator.thefirstproject.domain.model.userDoc.UserDocFullModel;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDocRepositoryImpl{

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public UserDocRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    /*public List<UserDocBaseModel> all(Long userId) {
        Query q = em.createNativeQuery("SELECT o.doc_type_id," +
                " dt.name," +
                " o.ser_num," +
                " o.who_issued," +
                " o.dep_code," +
                " o.doc_date," +
                " o.is_general" +
                " FROM tfp.user_doc o" +
                " LEFT JOIN tfp.doc_type dt" +
                " ON o.doc_type_id = dt.id" +
                " WHERE o.user_id = :userId", "userDocBaseMapping");
        q.setParameter("userId", userId);
        List<UserDocBaseModel> userDocBaseModels = q.getResultList();
        return q.getResultList();
    }*/

        public List<UserDocEntity> all(Long userId) {
            TypedQuery<UserDocEntity> query = em.createQuery("SELECT ude FROM UserDocEntity ude LEFT OUTER JOIN ude.userDocIdEntity udit LEFT OUTER JOIN udit.user uditu WHERE uditu.id = :userId", UserDocEntity.class);
            query.setParameter("userId", userId);
        return query.getResultList();
    }

    public UserDocEntity loadById(Long id) {
        return em.find(UserDocEntity.class, id);
    }

    public Integer update(UserDocFullModel userDocFullModel) {
        Query query = em.createNativeQuery("UPDATE tfp.user_doc ud" +
                " SET ud.ser_num = :serNum," +
                " ud.who_issued = :whoIssued," +
                " ud.dep_code = :depCode," +
                " ud.doc_date = :docDate," +
                " ud.is_general = :isGeneral" +
                " WHERE ud.user_id = :userId AND ud.doc_type_id = :docTypeId ");
        query.setParameter("userId", userDocFullModel.getUserId());
        query.setParameter("docTypeId", userDocFullModel.getDocTypeId());
        query.setParameter("isGeneral", userDocFullModel.getIsGeneral());
        query.setParameter("docDate", userDocFullModel.getDocDate());
        query.setParameter("depCode", userDocFullModel.getDepCode());
        query.setParameter("whoIssued", userDocFullModel.getWhoIssued());
        query.setParameter("serNum", userDocFullModel.getSerNum());

        int result = query.executeUpdate();
        return result;
    }

    public void save(UserDocEntity userDocEntity) {

            em.persist(userDocEntity);
    }
}
