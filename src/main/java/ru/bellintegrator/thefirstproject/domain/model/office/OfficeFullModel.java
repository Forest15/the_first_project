package ru.bellintegrator.thefirstproject.domain.model.office;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class OfficeFullModel implements Serializable {

        @ApiModelProperty(notes = "The id the office", required = true)
          private Long id;
        @ApiModelProperty(notes = "The firstName of the office", required = true)
          private String name;
        @ApiModelProperty(notes = "The address of the office", required = true)
          private String address;
        @ApiModelProperty(notes = "The phone of the office", required = false)
          private String phone;
        @ApiModelProperty(notes = "Is the office active?", required = false)
        private Boolean isActive;

        public OfficeFullModel(OfficeFullModel.Builder builder) {
            setName(builder.name);
            setIsActive(builder.isActive);
            setId(builder.id);
            setAddress(builder.address);
            setPhone(builder.phone);
        }

        public OfficeFullModel(){}

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

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;

        if (!(obj instanceof OfficeFullModel))

            return false;

        if (obj == this)

            return true;

        return this.getId() == ((OfficeFullModel) obj).getId();

    }

    @Override
    public String toString() {
        return "OfficeFullModel{" +
                "id='" + id + '\'' +
                ", firstName='" + name + '\'' +
                ", isActive='" + isActive + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }



    public static final class Builder{
        private Long id;
        private String name;
        private Boolean isActive;
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

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder phone(String phone){
            this.phone = phone;
            return this;
        }

        public OfficeFullModel build(){
            return new OfficeFullModel(this);
        }

    }
}
