package com.vic.springboot.quota.vic_springboot_rest.daoservice;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.vic.springboot.quota.vic_springboot_rest.dao.UserRepository;
import com.vic.springboot.quota.vic_springboot_rest.entity.User;

@Service
@Repository
public class UserSevice {
	
	@Autowired
	private UserRepository userRepository;
	
	private static final Logger logger = LogManager.getLogger(UserSevice.class);
	
	//@Scheduled(cron = "45 0-59 0-23 * * MON-SUN")//run it every minute every hour on the 45th second
	@Scheduled(cron = "45 0-59 12-18 * * MON-SUN")//run it every minute every hour on the 45th second, between 12-18 o'clock
	public  void CrudScheduler() {		
		List<User> users = userRepository.findAll();
		for(User u: users) {
			logger.info(u);
		}
	}
}
 