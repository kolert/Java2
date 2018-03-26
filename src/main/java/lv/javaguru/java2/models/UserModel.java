package lv.javaguru.java2.models;

import com.sun.org.apache.xpath.internal.SourceTree;
import lv.javaguru.java2.businesslogic.helper.Error;
import lv.javaguru.java2.businesslogic.responses.UserResponse;

import java.util.Date;

public class UserModel {

    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Long id;
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

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

    @Override
    public String toString() {
        return "UserModel{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public UserResponse validate(){
        System.out.println(toString());
        if(this.login == null || this.login.isEmpty()){
            return new UserResponse(false, new Error("Login","Can not be empty!"));
        }else if(this.name == null || this.name.isEmpty()){
            return new UserResponse(false,new Error("Name","Can not be empty!"));
        }else if(this.surname == null || this.surname.isEmpty()){
            return new UserResponse(false,new Error("Surname","Can not be empty!"));
//        }else if(this.password == null || this.password.isEmpty()){
//            return new UserResponse(false,new Error("Password","Can not be empty!"));
//        }else if(this.email == null || this.email.isEmpty()){
//            return new UserResponse(false,new Error("Email","Can not be empty!"));
        }else {
            return new UserResponse(true,null);
        }
    }
}

