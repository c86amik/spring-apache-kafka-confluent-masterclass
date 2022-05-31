/**
 * 
 */
package com.springcavaj.confluent.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springcavaj.confluent.model.UserModel;

/**
 * @author springcavaj
 *
 */
@Service
public class SpringApacheKafkaConfluentConsumerService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(SpringApacheKafkaConfluentConsumerService.class);
	
	@KafkaListener(topics = "springcavaj-topic", groupId = "group_json",
			containerFactory = "kafkaListenerContainerFactory")
	public void consumeUserModel(UserModel userModel) {
		LOGGER.info("UserModel : {}", userModel);
	}

}
