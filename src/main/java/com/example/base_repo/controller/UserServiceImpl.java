package com.example.base_repo.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> userList = new ArrayList<>();

    @Override
    public User getUser(int id) {
        return userList.stream().filter(user1 -> user1.getId() == id).findAny().get();
    }

    @Override
    public List<User> getAllUser() {
        return userList;
    }

    @Override
    public void update(User user) {
        User user2 = userList.stream().filter(user1 -> user1.getId() == user.getId()).findAny().get();
        user2.setFirstName(user.getFirstName());
        user2.setLastName(user.getLastName());
    }

    @Override
    public void remove(int id) {
        User user = userList.stream().filter(user1 -> user1.getId() == id).findAny().get();
        userList.remove(user);
    }

    @Override
    public User create(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public void createAll(List<User> user) {

    }
}
