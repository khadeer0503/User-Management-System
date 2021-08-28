package com.hello.bootcrud.Service;

import java.util.List;

import com.hello.bootcrud.model.User;

public interface UserService {
List<User> findAllUsers();
User get(int id);
User addUser(User user);
void updateOrSave(User user);
void delete(int id);
}
