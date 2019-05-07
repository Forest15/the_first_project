package ru.bellintegrator.thefirstproject.domain.model;

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

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;

        if (!(obj instanceof ResponseModel))

            return false;

        if (obj == this)

            return true;

        return this.getResult().equals(((ResponseModel) obj).getResult());

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
