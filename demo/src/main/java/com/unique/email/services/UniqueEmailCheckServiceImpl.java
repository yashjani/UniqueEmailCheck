package com.unique.email.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UniqueEmailCheckServiceImpl implements UniqueEmailCheckService {
	Logger logger = LoggerFactory.getLogger(UniqueEmailCheckServiceImpl.class);

	@Override
	public Integer checkUniqueEmailCount(List<String> emailList) {

		logger.info("checkUniqueEmailCount start with {}", emailList);
		if (emailList != null && !emailList.isEmpty()) {
			Set<String> emailSet = new HashSet<>();
			StringBuilder domainDetails = new StringBuilder();
			StringBuilder emailIdDetails = new StringBuilder();
			StringBuilder result = new StringBuilder();
			String[] emailPart = new String[2];
			for (String email : emailList) {
				domainDetails = new StringBuilder();
				emailIdDetails = new StringBuilder();
				result = new StringBuilder();
				emailPart = email.split("@");
				if (emailPart.length < 2) {
					continue;
				}
				domainDetails.append("@" + emailPart[1]);
				emailIdDetails.append(emailPart[0]);
				for (int i = 0; i < emailIdDetails.length(); i++) {
					if (emailIdDetails.charAt(i) != '.') {
						result.append(email.charAt(i));
					}
					if (emailIdDetails.charAt(i) == '+') {
						break;
					}
				}
				if (result.length() > 0) {
					emailSet.add(result.append(domainDetails).toString());
				}
			}
			logger.info("checkUniqueEmailCount end with result {}", emailSet.size());
			return new Integer(emailSet.size());
		}
		logger.info("checkUniqueEmailCount end with result {}", 0);
		return new Integer(0);
	}

}
