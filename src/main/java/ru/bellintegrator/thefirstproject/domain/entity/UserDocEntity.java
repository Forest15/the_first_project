package ru.bellintegrator.thefirstproject.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "USER_DOC", schema = "tfp")
public class UserDocEntity {

    @EmbeddedId
    private UserDocIdEntity userDocIdEntity;
    /*@JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;
    @JoinColumn(name = "doc_type_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private DocTypeEntity docType;*/
    @Column(name = "ser_num")
    private String serNum;
    @Column(name = "who_issued")
    private String whoIssued;
    @Column(name = "dep_code")
    private String depCode;
    @Column(name = "doc_date")
    @Temporal(TemporalType.DATE)
    private Date docDate;
    @Column(name = "is_general")
    private Boolean isGeneral;

    public UserDocEntity() {
    }

    public UserDocEntity(UserDocIdEntity userDocIdEntity, /*UserEntity user, DocTypeEntity docType,*/ String serNum, String whoIssued, String depCode, Date docDate, Boolean isGeneral) {
        this.userDocIdEntity = userDocIdEntity;
        /*this.user = user;
        this.docType = docType;*/
        this.serNum = serNum;
        this.whoIssued = whoIssued;
        this.depCode = depCode;
        this.docDate = docDate;
        this.isGeneral = isGeneral;
    }

    public UserDocIdEntity getUserDocIdEntity() {
        return userDocIdEntity;
    }

    public void setUserDocIdEntity(UserDocIdEntity userDocIdEntity) {
        this.userDocIdEntity = userDocIdEntity;
    }

   /* public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public DocTypeEntity getDocType() {
        return docType;
    }

    public void setDocType(DocTypeEntity docType) {
        this.docType = docType;
    }*/

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public String getWhoIssued() {
        return whoIssued;
    }

    public void setWhoIssued(String whoIssued) {
        this.whoIssued = whoIssued;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Boolean getIsGeneral() {
        return isGeneral;
    }

    public void setIsGeneral(Boolean general) {
        this.isGeneral = general;
    }
}
