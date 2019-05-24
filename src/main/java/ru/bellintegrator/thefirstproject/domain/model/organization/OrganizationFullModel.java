package ru.bellintegrator.thefirstproject.domain.model.organization;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrganizationFullModel implements Serializable {
    private static final long serialVersionUID = -1256606141950278286L;

    @ApiModelProperty(notes = "The id of the organization", required = true)
    private Long id;
    @ApiModelProperty(notes = "The firstName of organization", required = true)
    private String name;
    @ApiModelProperty(notes = "Is the organization active?", required = false)
    private Boolean isActive;
    @ApiModelProperty(notes = "The full firstName of organization", required = true)
    private String fullName;
    @ApiModelProperty(notes = "The inn of the organization", required = true)
    private String inn;
    @ApiModelProperty(notes = "The kpp of the organization", required = true)
    private String kpp;
    @ApiModelProperty(notes = "The address of the organization", required = true)
    private String address;
    @ApiModelProperty(notes = "The phone of the organization", required = false)
    private String phone;

    public OrganizationFullModel(OrganizationFullModel.Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setIsActive(builder.isActive);
        setFullName(builder.fullName);
        setInn(builder.inn);
        setKpp(builder.kpp);
        setAddress(builder.address);
        setPhone(builder.phone);
    }

    public OrganizationFullModel() {
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

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;

        if (!(obj instanceof OrganizationFullModel))

            return false;

        if (obj == this)

            return true;

        return this.getId() == ((OrganizationFullModel) obj).getId();

    }

    @Override
    public String toString() {
        return "OrganizationFullModel{" +
                "id='" + id + '\'' +
                ", firstName='" + name + '\'' +
                ", isActive='" + isActive + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }



    public static final class Builder{
        private Long id;
        private String name;
        private Boolean isActive;
        private String fullName;
        private String inn;
        private String kpp;
        private String address;
        private String phone;

        public Builder(){
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder isActive(Boolean isActive){
            this.isActive = isActive;
            return this;
        }

        public Builder fullName(String fullName){
            this.fullName = fullName;
            return this;
        }

        public Builder inn(String inn){
            this.inn = inn;
            return this;
        }

        public Builder kpp(String kpp){
            this.kpp = kpp;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder phone(String phone){
            this.phone = phone;
            return this;
        }

        public OrganizationFullModel build(){
            return new OrganizationFullModel(this);
        }

    }
}
