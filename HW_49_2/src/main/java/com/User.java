package com;

 class User{
    private int id;
    private String login;
    private String password;
    private String email;
    private String gender;

    public User(){}

    public User(int id, String login, String password, String email, String gender) {
       this.id = id;
       this.login = login;
       this.password = password;
       this.email = email;
       this.gender = gender;
    }

    public int getId() {
       return id;
    }

    public void setId(int id) {
       this.id = id;
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

    public String getEmail() {
       return email;
    }

    public void setEmail(String email) {
       this.email = email;
    }

    public String getGender() {
       return gender;
    }

    public void setGender(String gender) {
       this.gender = gender;
    }

    @Override
    public String toString() {
       return "User{" +
               "id=" + id +
               ", login='" + login + '\'' +
               ", password='" + password + '\'' +
               ", email='" + email + '\'' +
               ", gender='" + gender + '\'' +
               '}';
    }

 }
