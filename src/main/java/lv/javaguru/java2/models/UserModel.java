package lv.javaguru.java2.models;

import lv.javaguru.java2.businesslogic.helper.Error;
import lv.javaguru.java2.businesslogic.responses.UserResponse;

public class UserModel {

    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserResponse validate(){
        if(this.name == null || this.name.isEmpty()){
            return new UserResponse(false,new Error("Name","Can not be empty!"));
        }else if(this.surname == null || this.surname.isEmpty()){
            return new UserResponse(false,new Error("Surname","Can not be empty!"));
        }else if(this.login == null || this.login.isEmpty()){
            return new UserResponse(false,new Error("Login","Can not be empty!"));
        }else if(this.password == null || this.password.isEmpty()){
            return new UserResponse(false,new Error("Password","Can not be empty!"));
        }else if(this.email == null || this.email.isEmpty()){
            return new UserResponse(false,new Error("Email","Can not be empty!"));
        }else {
            return new UserResponse(true,null);
        }
    }
}

