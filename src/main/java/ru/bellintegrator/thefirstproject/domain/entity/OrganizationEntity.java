package ru.bellintegrator.thefirstproject.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORGANIZATION", schema = "tfp")
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private String name;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "full_name")
    private String fullName;
    private String inn;
    private String kpp;
    private String address;
    private String phone;

    public OrganizationEntity() {
    }

    public OrganizationEntity(Long id, String name, Boolean isActive){
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public OrganizationEntity(String name, Boolean isActive, String fullName, String inn, String kpp, String address, String phone) {
        this.name = name;
        this.isActive = isActive;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}