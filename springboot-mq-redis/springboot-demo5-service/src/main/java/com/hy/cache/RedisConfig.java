package com.hy.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisConfig {

	@Value("${spring.redis.port}")
	private Integer port;
	@Value("${spring.redis.host}")
	private String hostName;
	@Value("${spring.redis.password}")
	private String password;

	@Bean
	public JedisPoolConfig productJedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
		return jedisPoolConfig;
	}

	@Bean
	public JedisConnectionFactory productJedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
		JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory();
		jedisConnectionFactory.setHostName(hostName);
		jedisConnectionFactory.setPort(port);
		jedisConnectionFactory.setPassword(password);
		jedisConnectionFactory.setUsePool(true);
		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
		return jedisConnectionFactory;
	}
	@Scope("prototype")
	public Jedis productJedis(JedisConnectionFactory jedisConnectionFactory) {
		return	(Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
	}

	@Bean
	public StringRedisSerializer productStringRedisSerializer() {
		StringRedisSerializer stringRedisSerializer=new StringRedisSerializer();
		return stringRedisSerializer;
	}

	@Bean
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RedisTemplate productRedisTemplate(StringRedisSerializer stringRedisSerializer,JedisConnectionFactory jedisConnectionFactory) {
		RedisTemplate redisTemplate=new RedisTemplate();
		redisTemplate.setKeySerializer(stringRedisSerializer);
		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		return redisTemplate;
	}
	@Bean
	@SuppressWarnings({ "rawtypes"})
	public RedisClient productRedisClient(StringRedisTemplate stringRedisTemplate,RedisTemplate productRedisTemplate) {
		RedisClient redisClient=new RedisClient();
		redisClient.setRedisTemplate(productRedisTemplate);
		redisClient.setStringRedisTemplate(stringRedisTemplate);
		return redisClient;
	}
}
