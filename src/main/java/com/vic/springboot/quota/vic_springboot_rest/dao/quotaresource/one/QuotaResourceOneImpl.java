package com.vic.springboot.quota.vic_springboot_rest.dao.quotaresource.one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuotaResourceOneImpl implements QuotaResourceOne {

	
	private static final Logger logger = LogManager.getLogger(QuotaResourceOneImpl.class);
	
	@Override
	public void consumeQuotaResourceOneByUser(int id) {
		logger.info("QuotaResourceOne, consumeQuotaResourceOneByUser, user id: {}", id);
	}

	@Override
	public void getQuotaResourceStatusOneByUser(int id) {
		logger.info("QuotaResourceOne, getQuotaResourceStatusOneByUser, user id: {}", id);
	}

}
