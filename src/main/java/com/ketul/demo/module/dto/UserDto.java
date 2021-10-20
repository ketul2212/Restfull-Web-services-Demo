package com.ketul.demo.module.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ketul.demo.module.User;

@Component
public class UserDto {

	private int eid = 2;
	private static List<User> userList = new ArrayList<User>();
	
	static {
		userList.add(new User(1,"Ketul", 21));
		userList.add(new User(2, "Sunny", 25));
	}
	
	//Retrive All
	public List<User> getAll() {
		return userList;
	}
	
	//get one
	public User getOne(int id) {
		for(User user : userList) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
	//save user
	public User saveUser(User user) {
		if(user.getId() == 0)
			user.setId(++eid);
		userList.add(user);
		return user;
	}

	public User deleteById(int id) {
		Iterator<User> itr = userList.iterator();
		
		while(itr.hasNext()) {
			User user = itr.next();
			
			if(user.getId() == id) {
				itr.remove();
				return user;
			}
		}
		return null;
	}
}
