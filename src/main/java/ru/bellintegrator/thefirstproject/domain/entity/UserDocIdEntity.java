package ru.bellintegrator.thefirstproject.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
@Embeddable
public class UserDocIdEntity implements Serializable {

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;
    @JoinColumn(name = "doc_type_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private DocTypeEntity docType;

    public UserDocIdEntity() {
    }

    public UserDocIdEntity(UserEntity user, DocTypeEntity docType) {
        this.user = user;
        this.docType = docType;
    }

    public UserEntity getUser() {
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
    }

    /*@Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "doc_type_id", nullable = false)
    private Long docTypeId;

    public UserDocIdEntity() {
    }

    public UserDocIdEntity(Long userId, Long docTypeId) {
        this.userId = userId;
        this.docTypeId = docTypeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDocTypeId() {
        return docTypeId;
    }

    public void setDocTypeId(Long docTypeId) {
        this.docTypeId = docTypeId;
    }*/
}
