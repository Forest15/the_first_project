package ru.bellintegrator.thefirstproject.domain.model.office;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OfficeCreatingModel implements Serializable {
    @ApiModelProperty(notes = "The id of the organization that the office belong to", required = true)
    private Long orgId;
    @ApiModelProperty(notes = "The firstName of the office", required = false)
    private String name;
    @ApiModelProperty(notes = "The address of the office", required = false)
    private String address;
    @ApiModelProperty(notes = "The phone of the office", required = false)
    private String phone;
    @ApiModelProperty(notes = "Is the office active?", required = false)
    private Boolean isActive;

    public OfficeCreatingModel(OfficeCreatingModel.Builder builder) {
        setName(builder.name);
        setIsActive(builder.isActive);
        setOrgId(builder.orgId);
        setAddress(builder.address);
        setPhone(builder.phone);
    }

    public OfficeCreatingModel(){}

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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public static final class Builder{
        private Long orgId;
        private Boolean isActive;
        private String name;
        private String address;
        private String phone;

        public Builder(){
        }

        public Builder orgId(Long orgId){
            this.orgId = orgId;
            return this;
        }

        public Builder isActive(Boolean isActive){
            this.isActive = isActive;
            return this;
        }

        public Builder name(String name){
            this.name = name;
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

        public OfficeCreatingModel build(){
            return new OfficeCreatingModel(this);
        }

    }
}
