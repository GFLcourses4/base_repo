package com.example.base_repo.dto;

public class ProxyDTO {
    private String host;
    private Integer post;
    private CredsDTO credsDTO;

    public ProxyDTO() {
    }

    public ProxyDTO(String host, Integer post, CredsDTO credsDTO) {
        this.host = host;
        this.post = post;
        this.credsDTO = credsDTO;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public CredsDTO getCredsDTO() {
        return credsDTO;
    }

    public void setCredsDTO(CredsDTO credsDTO) {
        this.credsDTO = credsDTO;
    }
}
