package com.hy.cache;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({"rawtypes"})
public class RedisClient {
	
	private RedisTemplate redisTemplate;
	private StringRedisTemplate stringRedisTemplate;
	protected void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate=redisTemplate;
	}
	protected void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate=stringRedisTemplate;
	}
	
	@SuppressWarnings("unchecked")
	public void put(String key,String value) {
		redisTemplate.opsForValue().set(key, value);
	}
	@SuppressWarnings("unchecked")
	public void put(String key,String value,int second) {
		redisTemplate.opsForValue().set(key, value,second,TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("unchecked")
	public void put(String key,Object value) {
		if(value instanceof String) {
			put(key, value);
		}else {
			redisTemplate.opsForValue().set(key, value);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void put(String key,Object value,int second) {
		if(value instanceof String) {
			put(key, value,second);
		}else {
			redisTemplate.opsForValue().set(key, value,second,TimeUnit.SECONDS);
		}
	}
	
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	
	public String getString(String key) {
		return (String) redisTemplate.opsForValue().get(key);
	}
	
	public Integer getInt(String key) {
		return (Integer) redisTemplate.opsForValue().get(key);
	}
	
	public Short getShort(String key) {
		return (Short) redisTemplate.opsForValue().get(key);
	}
	
	public Long getLong(String key) {
		return (Long) redisTemplate.opsForValue().get(key);
	}
	
	public Double getDouble(String key) {
		return (Double) redisTemplate.opsForValue().get(key);
	}
	
	public Float getFloat(String key) {
		return (Float) redisTemplate.opsForValue().get(key);
	}
	
	public Character getChar(String key) {
		return (Character) redisTemplate.opsForValue().get(key);
	}
	
	public Byte getByte(String key) {
		return (Byte) redisTemplate.opsForValue().get(key);
	}
	
	public BigDecimal getBigDecimal(String key) {
		return (BigDecimal) redisTemplate.opsForValue().get(key);
	}
	
	public boolean lock(String key,long timeout) {
		Boolean isLock=(Boolean) stringRedisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				Boolean isLock=false;
				try {
					isLock=connection.setNX(key.getBytes(), "".getBytes());
					if(isLock) {
						connection.expire(key.getBytes(), timeout);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return isLock;
			}
		});
		return isLock;
	}
	
	public void unlock(String key) {
		stringRedisTemplate.delete(key);
	}
}
