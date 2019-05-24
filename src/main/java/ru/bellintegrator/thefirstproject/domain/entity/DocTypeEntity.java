package ru.bellintegrator.thefirstproject.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doc_type", schema = "tfp")
public class DocTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String code;
    private String name;

    @ManyToMany(mappedBy = "docTypeEntityList")
    private List<UserEntity> userEntityList;

    public DocTypeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }
}
