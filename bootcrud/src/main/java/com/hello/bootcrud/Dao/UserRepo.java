package com.hello.bootcrud.Dao;

import org.springframework.data.repository.CrudRepository;

import com.hello.bootcrud.model.User;

public interface UserRepo  extends CrudRepository<User, Integer>{

}
