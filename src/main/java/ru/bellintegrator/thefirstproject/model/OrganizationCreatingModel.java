package ru.bellintegrator.thefirstproject.model;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationCreatingModel extends OrganizationRequestModel {
    @ApiModelProperty(notes = "The full name of organization", required = false)
    public String fullName;
    @ApiModelProperty(notes = "The kpp of the organization", required = false)
    public String kpp;
    @ApiModelProperty(notes = "The address of the organization", required = false)
    public String address;
    @ApiModelProperty(notes = "The phone of the organization", required = false)
    public String phone;

    public OrganizationCreatingModel(OrganizationCreatingModel.Builder builder) {
        setFullName(builder.fullName);
        setKpp(builder.kpp);
        setAddress(builder.address);
        setPhone(builder.phone);
    }

    public OrganizationCreatingModel() {
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

    public static final class Builder extends OrganizationRequestModel.Builder{
        private String fullName;
        private String kpp;
        private String address;
        private String phone;

        public Builder(){
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

        public OrganizationCreatingModel builder(){
            return new OrganizationCreatingModel(this);
        }

    }
}
