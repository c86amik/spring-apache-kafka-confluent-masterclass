/**
 * 
 */
package com.springcavaj.confluent.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcavaj.confluent.model.UserModel;
import com.springcavaj.confluent.service.SpringApacheKafkaConfluentProducerService;

/**
 * @author springcavaj
 *
 */
@RestController
@RequestMapping(value="/confluent")
public class SpringApacheKafkaConfluentController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(SpringApacheKafkaConfluentController.class);
	
	@Autowired
	private SpringApacheKafkaConfluentProducerService apacheKafkaConfluentProducerService;
	
	@PostMapping("/produceJson")
	public String produceJson(@RequestBody UserModel userModel) {
		String returnMsg = "Publish JSON User Model Message : " + userModel.toString();
		apacheKafkaConfluentProducerService.send(userModel);
		LOGGER.info(returnMsg);
		return returnMsg;
	}

}
