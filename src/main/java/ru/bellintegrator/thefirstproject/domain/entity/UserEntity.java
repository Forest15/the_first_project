package ru.bellintegrator.thefirstproject.domain.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER", schema = "tfp")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private CountryEntity country;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private OfficeEntity office;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    private String position;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "is_identified")
    private Boolean isIdentified;
    @ManyToMany
    @JoinTable(name = "user_doc", schema = "tfp",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "doc_type_id"))
    private Set<DocTypeEntity> docTypeEntityList;

    public UserEntity() {
    }

    public UserEntity(Long id, String firstName, String lastName, String middleName, String position){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
    }

    public UserEntity(CountryEntity country, OfficeEntity office, String firstName, String lastName, String middleName, String position, String userPhone, Boolean isIdentified) {
        this.country = country;
        this.office = office;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.userPhone = userPhone;
        this.isIdentified = isIdentified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public OfficeEntity getOffice() {
        return office;
    }

    public void setOffice(OfficeEntity office) {
        this.office = office;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(Boolean identified) {
        this.isIdentified = identified;
    }

    public Set<DocTypeEntity> getDocTypeEntityList() {
        return docTypeEntityList;
    }

    public void setDocTypeEntityList(Set<DocTypeEntity> docTypeEntityList) {
        this.docTypeEntityList = docTypeEntityList;
    }
}
