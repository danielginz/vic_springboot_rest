package com.vic.springboot.quota.vic_springboot_rest.dao.quotaresource.two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuotaResourceTwoImpl implements QuotaResourceTwo{

	private static final Logger logger = LogManager.getLogger(QuotaResourceTwoImpl.class);
	
	@Override
	public void consumeQuotaResourceTwoByUser(int id) {
		logger.info("QuotaResourceTwo, consumeQuotaResourceTwoByUser, user id: {}", id);
	}

	@Override
	public void getQuotaResourceStatusTwoByUser(int id) {
		logger.info("QuotaResourceTwo, getQuotaResourceStatusTwoByUser, user id: {}", id);		
	}

}
