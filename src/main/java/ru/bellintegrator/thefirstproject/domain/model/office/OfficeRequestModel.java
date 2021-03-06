package ru.bellintegrator.thefirstproject.domain.model.office;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OfficeRequestModel implements Serializable {
    @ApiModelProperty(notes = "The id of the office", required = true)
    public Long orgId;
    @ApiModelProperty(notes = "The firstName of the office", required = false)
    public String name;
    @ApiModelProperty(notes = "The phone of the office", required = false)
    public String phone;
    @ApiModelProperty(notes = "Is the office active?", required = false)
    public Boolean isActive;

    public OfficeRequestModel(OfficeRequestModel.Builder builder){
        setOrgId(builder.orgId);
        setName(builder.name);
        setPhone(builder.phone);
        setIsActive(builder.isActive);
    }

    public OfficeRequestModel(){

    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public static class Builder{
        private Long orgId;
        private String name;
        private String phone;
        private Boolean isActive;

        public Builder(){

        }

        public Builder orgId(Long orgId){
            this.orgId = orgId;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder phone(String phone){
            this.phone = phone;
            return this;
        }

        public Builder isActive(Boolean isActive){
            this.isActive = isActive;
            return this;
        }

        public OfficeRequestModel build(){
            return new OfficeRequestModel(this);
        }
    }
}
