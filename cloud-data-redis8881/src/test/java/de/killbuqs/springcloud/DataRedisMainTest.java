package de.killbuqs.springcloud;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.killbuqs.springcloud.model.User;
import de.killbuqs.springcloud.util.RedisUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DataRedisMainTest {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Test
	public void test1() throws Exception {
		redisUtil.set("name", "jielong");
		System.out.println(redisUtil.get("name"));
	}
	@Test
	public void test2() throws Exception {
		System.out.println(redisUtil.get("name"));
	}
	
	@Test
	public void test3() throws Exception {
		
		User user = new User(1l, "jie", 36);
		String json = new ObjectMapper().writeValueAsString(user);
		redisTemplate.opsForValue().set("user", user);
		redisTemplate.opsForValue().set("userJson", json);
		
		
		System.out.println(redisTemplate.opsForValue().get("user"));
		System.out.println(redisTemplate.opsForValue().get("userJson"));
		
	}
}
