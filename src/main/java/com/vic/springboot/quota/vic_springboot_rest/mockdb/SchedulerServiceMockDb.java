package com.vic.springboot.quota.vic_springboot_rest.mockdb;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vic.springboot.quota.vic_springboot_rest.dao.UserRepository;
import com.vic.springboot.quota.vic_springboot_rest.dao.quotaresource.one.QuotaResourceOne;
import com.vic.springboot.quota.vic_springboot_rest.dao.quotaresource.one.QuotaResourceOneImpl;
import com.vic.springboot.quota.vic_springboot_rest.dao.quotaresource.two.QuotaResourceTwo;
import com.vic.springboot.quota.vic_springboot_rest.dao.quotaresource.two.QuotaResourceTwoImpl;
import com.vic.springboot.quota.vic_springboot_rest.entity.User;
import com.vic.springboot.quota.vic_springboot_rest.utils.Utils;

@Component
public class SchedulerServiceMockDb {

	@Value("${user.requests.quotaresourceone}")
	private int quotaresourceone;

	@Value("${user.requests.quotaresourceotwo}")
	private int quotaresourceotwo;

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LogManager.getLogger(SchedulerServiceMockDb.class);

	//@Scheduled(cron = "15 0-59 0-23 * * MON-SUN") //run it every fiftinth's second, every minute, every hour
	@Scheduled(cron = "15 0-59 0,18-23 * * MON-SUN") //run it every fiftinth's second, every minute, between 18-23 hours
	public void quotaResourceOneScheduledMethod() {
		String connectToQuotaResource = "n";
		int quoteNum;
		int id = 0;
		String operation = null;
		Scanner input = new Scanner(System.in);

		List<User> users = UsersSingleton.getUsersSingleton().getUsers();
		if (users == null || users.isEmpty()) {
			users = userRepository.findAll();
			UsersSingleton.getUsersSingleton().setUsers(users);
		}

		System.out.println("Do you want to connect to QuotaResource Databases? Type y or n:");
		connectToQuotaResource = input.nextLine();

		if ("y".equals(connectToQuotaResource)) {
			User user;
			System.out.println("Enter your id: ");
			try {
				id = input.nextInt();
				user = Utils.getUserById(id, users);
			} catch (InputMismatchException e) {
				user = null;
			}

			if (user != null) {
				System.out.println("Hello, please choose QuotaResource you want to connect, 1 or 2: ");
				try {
					quoteNum = input.nextInt();
				} catch (InputMismatchException e) {
					quoteNum = 0;
				}

				input.nextLine();
				System.out.println(
						"Choose the operation: ConsumeQuotaResourceByUser(c), GetQuotaResourceByUser(g), type c or g: ");
				operation = input.nextLine();

				int requestCount;
				if (quoteNum == 1) {
					requestCount = user.getRequestcountone();
					if (requestCount < quotaresourceone) {
						runQuotaResourceOneOperation(operation, id);
						user.setRequestcountone(++requestCount);
						userRepository.save(user);
					} else {
						logger.info("User {} is blocked. You have used up your quota.", id);
					}

				} else if (quoteNum == 2) {
					requestCount = user.getRequestcounttwo();
					if (requestCount < quotaresourceotwo) {
						runQuotaResourceTwoOperation(operation, id);
						user.setRequestcounttwo(++requestCount);
						userRepository.save(user);
					} else {
						logger.info("User {} is blocked. You have used up your quota.", id);
					}
				}

			} else {
				logger.info("There is no such user, id={}.", id);
			}
		}

	}
	
	
	public void runQuotaResourceOneOperation(String operation, int id) {
		QuotaResourceOne quotaResourceOne = new QuotaResourceOneImpl();
		// can be implemented by Reflection
		switch (operation) {
		case "c":
			quotaResourceOne.consumeQuotaResourceOneByUser(id);
			break;
		case "g":
			quotaResourceOne.getQuotaResourceStatusOneByUser(id);
			break;
		default:
			logger.info("Invalid operation: {} .", operation);
		}
	}

	public void runQuotaResourceTwoOperation(String operation, int id) {
		QuotaResourceTwo quotaResourceTwo = new QuotaResourceTwoImpl();
		// can be implemented by Reflection
		switch (operation) {
		case "c":
			quotaResourceTwo.consumeQuotaResourceTwoByUser(id);
			break;
		case "g":
			quotaResourceTwo.getQuotaResourceStatusTwoByUser(id);
			break;
		default:
			logger.info("Invalid operation: {} .", operation);
		}
	}
}
