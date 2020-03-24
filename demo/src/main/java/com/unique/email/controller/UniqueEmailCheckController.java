package com.unique.email.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unique.email.services.UniqueEmailCheckService;

@RestController
@RequestMapping(value = "/api")
public class UniqueEmailCheckController {
	Logger logger = LoggerFactory.getLogger(UniqueEmailCheckController.class);
	
	@Autowired
	UniqueEmailCheckService uniqueEmailCheckService;

	@PostMapping(value = "/emailcheck")
	public Integer checkUniqueEmailCount(@RequestBody List<String> emailList) {
		logger.info("checkUniqueEmailCount Controller request Start");
		return uniqueEmailCheckService.checkUniqueEmailCount(emailList);
	}

}
