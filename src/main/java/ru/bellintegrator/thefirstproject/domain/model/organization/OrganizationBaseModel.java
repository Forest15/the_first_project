package ru.bellintegrator.thefirstproject.domain.model.organization;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrganizationBaseModel implements Serializable {

    @ApiModelProperty(notes = "The id of the organization", required = false)
    public Long id;
    @ApiModelProperty(notes = "The firstName of organization", required = false)
    public String name;
    @ApiModelProperty(notes = "Is the organization active?", required = false)
    public Boolean isActive;

    public OrganizationBaseModel(OrganizationBaseModel.Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setIsActive(builder.isActive);
    }

    public OrganizationBaseModel() {
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

    public static class Builder{
        private Long id;
        private String name;
        private Boolean isActive;
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

        public OrganizationBaseModel build(){
            return new OrganizationBaseModel(this);
        }
    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if (!(o instanceof OrganizationBaseModel)){
            return false;
        }
        if(o == this){
            return true;
        }

        return this.getId() == ((OrganizationBaseModel) o).getId();
    }
}
