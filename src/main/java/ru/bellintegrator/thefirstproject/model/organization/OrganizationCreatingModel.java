package ru.bellintegrator.thefirstproject.model.organization;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationCreatingModel {

    @ApiModelProperty(notes = "The name of organization", required = true)
    public String orgName;
    @ApiModelProperty(notes = "The inn of organization", required = false)
    public String inn;
    @ApiModelProperty(notes = "Is the organization active?", required = false)
    public String isActive;
    @ApiModelProperty(notes = "The full name of organization", required = false)
    public String fullName;
    @ApiModelProperty(notes = "The kpp of the organization", required = false)
    public String kpp;
    @ApiModelProperty(notes = "The address of the organization", required = false)
    public String address;
    @ApiModelProperty(notes = "The phone of the organization", required = false)
    public String phone;

    public OrganizationCreatingModel(OrganizationCreatingModel.Builder builder) {
        setOrgName(builder.orgName);
        setInn(builder.inn);
        setIsActive(builder.isActive);
        setFullName(builder.fullName);
        setKpp(builder.kpp);
        setAddress(builder.address);
        setPhone(builder.phone);
    }

    public OrganizationCreatingModel() {
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
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
        private String orgName;
        private String inn;
        private String isActive;
        private String fullName;
        private String kpp;
        private String address;
        private String phone;

        public Builder(){
        }

        public Builder orgName(String orgName){
            this.orgName = orgName;
            return this;
        }

        public Builder inn(String inn){
            this.inn = inn;
            return this;
        }

        public Builder isActive(String isActive){
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
