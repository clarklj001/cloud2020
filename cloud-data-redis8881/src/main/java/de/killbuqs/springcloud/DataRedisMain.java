package de.killbuqs.springcloud;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class DataRedisMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DataRedisMain.class, args);
	}
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public void run(String... args) throws Exception {
		Set<String> keys = redisTemplate.keys("*");
		 System.out.println("============");
		System.out.println(keys);
		
		redisTemplate.opsForValue().set("key1", "value1");    //String
		redisTemplate.opsForList().leftPush("key2", "value2");   //List
		System.out.println(redisTemplate.opsForValue().get("key1"));
		
		RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
		connection.flushAll();
		connection.flushDb();
		
	}

}
