package ru.bellintegrator.thefirstproject.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "OFFICE", schema = "tfp")
public class OfficeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private OrganizationEntity organization;
    private String name;
    private String address;
    @Column(name = "office_phone")
    private String officePhone;
    @Column(name = "is_active")
    private Boolean isActive;

    public OfficeEntity() {
    }

    public OfficeEntity(Long id, String name, Boolean isActive){
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public OfficeEntity(OrganizationEntity organization, String name, String address, String officePhone, Boolean isActive) {
        this.organization = organization;
        this.name = name;
        this.address = address;
        this.officePhone = officePhone;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
