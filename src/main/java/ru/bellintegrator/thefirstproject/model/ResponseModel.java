package ru.bellintegrator.thefirstproject.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ResponseModel implements Serializable {
    @ApiModelProperty(notes = "The response obtained from server", required = true)
    public String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ResponseModel(ResponseModel.Builder builder){
        setResult(builder.result);
    }

    public ResponseModel(){

    }

    public static class Builder{
        private String result;

        public Builder(){
        }

        public Builder result(String result){
            this.result = result;
            return this;
        }

        public ResponseModel build(){
            return new ResponseModel(this);
        }

    }
}
