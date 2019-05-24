package ru.bellintegrator.thefirstproject.domain.model.user;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserBaseModel implements Serializable {
    @ApiModelProperty(notes = "The id of the user.", required = false)
    private Long id;
    @ApiModelProperty(notes = "The first name of the user.", required = false)
    private String firstName;
    @ApiModelProperty(notes = "The second name of the user.", required = false)
    private String lastName;
    @ApiModelProperty(notes = "The middle name of the user.", required = false)
    private String middleName;
    @ApiModelProperty(notes = "The user position", required = false)
    private String position;

    public UserBaseModel(UserBaseModel.Builder builder){
        setId(builder.id);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setMiddleName(builder.middleName);
        setPosition(builder.position);
    }

    public UserBaseModel(){

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public static class Builder{
        private Long id;
        private String firstName;
        private String lastName;
        private String middleName;
        private String position;

        public Builder(){

        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder middleName(String middleName){
            this.middleName = middleName;
            return this;
        }

        public Builder position(String position){
            this.position = position;
            return this;
        }

        public UserBaseModel build(){
            return new UserBaseModel(this);
        }
    }

}
