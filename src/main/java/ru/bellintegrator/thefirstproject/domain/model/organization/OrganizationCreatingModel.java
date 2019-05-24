package ru.bellintegrator.thefirstproject.domain.model.organization;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrganizationCreatingModel implements Serializable {

    @ApiModelProperty(notes = "The firstName of organization", required = true)
    private String name;
    @ApiModelProperty(notes = "The inn of organization", required = false)
    private String inn;
    @ApiModelProperty(notes = "Is the organization active?", required = false)
    private Boolean isActive;
    @ApiModelProperty(notes = "The full firstName of organization", required = false)
    private String fullName;
    @ApiModelProperty(notes = "The kpp of the organization", required = false)
    private String kpp;
    @ApiModelProperty(notes = "The address of the organization", required = false)
    private String address;
    @ApiModelProperty(notes = "The phone of the organization", required = false)
    private String phone;

    public OrganizationCreatingModel(OrganizationCreatingModel.Builder builder) {
        setName(builder.name);
        setInn(builder.inn);
        setIsActive(builder.isActive);
        setFullName(builder.fullName);
        setKpp(builder.kpp);
        setAddress(builder.address);
        setPhone(builder.phone);
    }

    public OrganizationCreatingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
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

    public static final class Builder{
        private String name;
        private String inn;
        private Boolean isActive;
        private String fullName;
        private String kpp;
        private String address;
        private String phone;

        public Builder(){
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder inn(String inn){
            this.inn = inn;
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

        public OrganizationCreatingModel build(){
            return new OrganizationCreatingModel(this);
        }

    }
}
