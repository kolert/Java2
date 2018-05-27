package lv.javaguru.java2.database.Entities;

import lv.javaguru.java2.businesslogic.helper.Error;
import lv.javaguru.java2.businesslogic.responses.Response;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="surname",nullable = false)
    private String surname;
    @Column(name="login",nullable = false)
    private String login;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="created",nullable = false)
    private Timestamp created;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="role",nullable = false)
    private char role;
    @Column(name="status",nullable = false)
    private char status;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role+"";
    }

    public void setRole(char role) {
        this.role = role;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setModel(User userModel){
        setEmail(userModel.getEmail());
        setName(userModel.getName());
        java.util.Date utilDate = new java.util.Date();
        setCreated(new Timestamp(utilDate.getTime()));
        setLogin(userModel.getLogin());
        setPassword(userModel.getPassword());
        setRole(userModel.getRole().charAt(0));
        setStatus(userModel.getStatus());
        setSurname(userModel.getSurname());
    }

    public Response validate(){
        System.out.println(toString());
        if(this.login == null || this.login.isEmpty()){
            return new Response(false, new Error("Login","Can not be empty!"));
        }else if(this.email == null || this.email.isEmpty()){
            return new Response(false,new Error("Email","Can not be empty!"));
        }else if(this.name == null || this.name.isEmpty()){
            return new Response(false,new Error("Name","Can not be empty!"));
        }else if(this.surname == null || this.surname.isEmpty()){
            return new Response(false,new Error("Surname","Can not be empty!"));
//        }else if(this.password == null || this.password.isEmpty()){
//            return new Response(false,new Error("Password","Can not be empty!"));
        }else {
            return new Response(true,null);
        }
    }
}
