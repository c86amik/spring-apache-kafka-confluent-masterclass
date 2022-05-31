/**
 * 
 */
package com.springcavaj.confluent.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.springcavaj.confluent.model.UserModel;

/**
 * @author springcavaj
 *
 */
@Configuration
public class SpringApacheKafkaConfig {
	
	@Bean
	public ProducerFactory<String, UserModel> producerFactory(){
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-41p56.asia-south1.gcp.confluent.cloud:9092");
		config.put(ProducerConfig.RETRIES_CONFIG, 0);
		config.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<String, UserModel>(config);
	}
	
	@Bean(name = "kafkaJsonTemplate") 
	public KafkaTemplate<String, UserModel> kafkaJsonTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
	
	@Bean
	public ConsumerFactory<String, UserModel> consumerFactory(){
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-41p56.asia-south1.gcp.confluent.cloud:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(UserModel.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, UserModel> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, UserModel> containerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		containerFactory.setConsumerFactory(consumerFactory());
		return containerFactory;
	}

}
