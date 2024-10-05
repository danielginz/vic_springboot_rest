package com.vic.springboot.quota.vic_springboot_rest.utils;

import java.util.List;

import com.vic.springboot.quota.vic_springboot_rest.entity.User;

public class Utils {
	public static User getUserById(int id, List<User> users) {
		User myUser = users.stream()
				.filter(user -> id == user.getId())
				.findAny()
				.orElse(null);
		return myUser;
	}
}
