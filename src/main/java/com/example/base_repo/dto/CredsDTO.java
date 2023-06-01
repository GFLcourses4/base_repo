package com.example.base_repo.dto;

public class CredsDTO {
    private String username;
    private String password;

    public CredsDTO() {
    }

    public CredsDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
