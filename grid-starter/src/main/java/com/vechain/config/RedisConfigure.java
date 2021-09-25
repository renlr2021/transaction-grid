package com.vechain.config;

import java.lang.reflect.Method;
import java.time.Duration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.ReflectionUtils;

@Configuration
@ConditionalOnClass(RedissonClient.class)
@PropertySource(value = { "classpath:config/redis.properties" })
public class RedisConfigure {
	
	@Bean
	public RedissonClient redissonClient(RedisProperties redisProperties) {
		org.redisson.config.Config config = new org.redisson.config.Config();
		String prefix = "redis://";
		Method method = ReflectionUtils.findMethod(RedisProperties.class, "isSsl");
		if (method != null && (Boolean) ReflectionUtils.invokeMethod(method, redisProperties)) {
			prefix = "rediss://";
		}
		RedisProperties.Pool pool = redisProperties.getJedis().getPool() == null ? new RedisProperties.Pool() : redisProperties.getJedis().getPool();
		if (pool.getMaxWait().equals(Duration.ofMillis(-1)))
			pool.setMaxWait(Duration.ofMillis(3000));
		config.useSingleServer().setConnectionMinimumIdleSize(pool.getMinIdle()).setConnectionPoolSize(pool.getMaxActive()).setTimeout(((int) pool.getMaxWait().toMillis()))
				.setAddress(prefix + redisProperties.getHost() + ":" + redisProperties.getPort()).setConnectTimeout(((int) redisProperties.getTimeout().toMillis()))
				.setDatabase(redisProperties.getDatabase()).setPassword(redisProperties.getPassword());
		return Redisson.create(config);
	}
}