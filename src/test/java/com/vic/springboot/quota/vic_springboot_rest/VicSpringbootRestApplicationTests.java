package com.vic.springboot.quota.vic_springboot_rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.vic.springboot.quota.vic_springboot_rest.dao.UserRepository;
import com.vic.springboot.quota.vic_springboot_rest.entity.User;
import com.vic.springboot.quota.vic_springboot_rest.mockdb.SchedulerServiceMockDb;
import com.vic.springboot.quota.vic_springboot_rest.mockdb.UsersSingleton;
import com.vic.springboot.quota.vic_springboot_rest.utils.Utils;

@SpringBootTest
class VicSpringbootRestApplicationTests {
	@Value("${user.requests.quotaresourceone}")
	private int quotaresourceone;//3

	@Value("${user.requests.quotaresourceotwo}")
	private int quotaresourceotwo;//5

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LogManager.getLogger(SchedulerServiceMockDb.class);
	
	
	@Test
	void isUserAllowedToRunRequestsForTheResourceOne() {
		User user = new User(5, "Yosi", "Mor", 0, 0);
		int requestCount = user.getRequestcountone();
		assertTrue(requestCount < quotaresourceone);
	}
	
	
	@Test
	void isUserNotAllowedToRunRequestsForTheResourceOne() {
		User user = new User(5, "Yosi", "Mor", 4, 0);
		int requestCount = user.getRequestcountone();
		assertFalse(requestCount < quotaresourceone);
	}
	
	@Test
	void isUserAllowedToRunRequestsForTheResourceTwo() {
		User user = new User(5, "Yosi", "Mor", 0, 0);
		int requestCount = user.getRequestcounttwo();
		assertTrue(requestCount < quotaresourceone);
	}
	
	@Test
	void isUserNotAllowedToRunRequestsForTheResourceTwo() {
		User user = new User(5, "Yosi", "Mor", 0, 5);
		int requestCount = user.getRequestcounttwo();
		assertFalse(requestCount < quotaresourceone);
	}
	
	@Test
	void initUserList() {
		UsersSingleton.getUsersSingleton().setUsers(userRepository.findAll());
		List<User> users = UsersSingleton.getUsersSingleton().getUsers();
		assertFalse(users.isEmpty());
	}
	
	@Test
	void userNotExist() {
		UsersSingleton.getUsersSingleton().setUsers(userRepository.findAll());
		List<User> users = UsersSingleton.getUsersSingleton().getUsers();
		User user = Utils.getUserById(10, users);
		assertNull(user);
	}
	
	@Test
	void userExist() {
		UsersSingleton.getUsersSingleton().setUsers(userRepository.findAll());
		List<User> users = UsersSingleton.getUsersSingleton().getUsers();
		User user = Utils.getUserById(2, users);
		assertNotNull(user);
	}
	
}
