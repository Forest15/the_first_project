package ru.bellintegrator.thefirstproject.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrganizationRequestModel implements Serializable {

    @ApiModelProperty(notes = "The name of organization", required = true)
    public String orgName;
    @ApiModelProperty(notes = "The inn of organization", required = false)
    public String inn;
    @ApiModelProperty(notes = "Is the organization active?", required = false)
    public String isActive;

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

    public OrganizationRequestModel(OrganizationRequestModel.Builder builder){
        setOrgName(builder.orgName);
        setInn(builder.inn);
        setIsActive(builder.isActive);
    }

    public OrganizationRequestModel(){

    }

    public static class Builder{
        private String orgName;
        private String inn;
        private String isActive;

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

        public OrganizationRequestModel build(){
            return new OrganizationRequestModel(this);
        }

    }
}
