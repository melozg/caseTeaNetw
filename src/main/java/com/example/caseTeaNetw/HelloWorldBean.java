package com.example.caseTeaNetw;

public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }
    //getter
    public String getMessage(){
        return message;
    }
    //setter
    public void setMessage(String message){
        this.message = message;
    }

    //simple java bean
    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
