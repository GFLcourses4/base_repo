package com.example.base_repo.controller;

import java.util.List;

public interface UserService {
    User getUser(int id);
    List<User> getAllUser();

    void update(User user);

    void remove(int user);

    User create(User user);

    void createAll(List<User> user);
}
