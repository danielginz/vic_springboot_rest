package com.vic.springboot.quota.vic_springboot_rest.mockdb;

import java.util.ArrayList;
import java.util.List;

import com.vic.springboot.quota.vic_springboot_rest.entity.User;

public class UsersSingleton {

	private List<User> users = new ArrayList<User>();
	
	private static UsersSingleton usersSingleton;
	
	private UsersSingleton() {
		
	}
	
	public static UsersSingleton getUsersSingleton() {
		if(usersSingleton == null) {
			usersSingleton = new UsersSingleton();
		}
		return usersSingleton;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
