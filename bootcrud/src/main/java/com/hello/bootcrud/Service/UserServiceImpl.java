package com.hello.bootcrud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hello.bootcrud.Dao.UserRepo;
import com.hello.bootcrud.model.User;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public List<User> findAllUsers() {
		
		return  (List<User>) userRepo.findAll();
	}
	
	@Override
	public User get(int id) {
		
		return this.userRepo.findById(id).get();
	}


	@Override
	public User addUser(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public void updateOrSave(User user) {
		this.userRepo.save(user);
		
	}

	@Override
	public void delete(int id) {
	this.userRepo.deleteById(id);
		
	}

	
}
