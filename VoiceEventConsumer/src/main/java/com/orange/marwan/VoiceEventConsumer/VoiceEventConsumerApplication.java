package com.orange.marwan.VoiceEventConsumer;


import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

@SpringBootApplication
public class VoiceEventConsumerApplication {

	public static void main(String[] args) {
		// SpringApplication.run(VoiceEventConsumerApplication.class, args);
		String group = "testgroup";
		ConstantUtls.loadCons();
		final StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
		Properties proper = new Properties();
		proper.setProperty("group.id", group);
		proper.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, ConstantUtls.bootStraperServer);
		proper.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
		proper.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		proper.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, ConstantUtls.bootStraperServer);
		proper.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		proper.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		proper.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getName());
	}

}
