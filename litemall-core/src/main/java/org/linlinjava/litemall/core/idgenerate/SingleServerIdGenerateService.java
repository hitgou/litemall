package org.linlinjava.litemall.core.idgenerate;

import java.util.concurrent.TimeUnit;

import org.linlinjava.litemall.core.redis.IRedisService;
import org.linlinjava.litemall.core.redis.RedisModel;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

/**
 * 该类用于自动初始化数据库配置到BaseConfig中，以便BaseConfig的子类调用
 */
@Service
public class SingleServerIdGenerateService extends IRedisService<RedisModel> {

	/**
	 *
	 * @param key
	 * @param liveTime
	 * @return
	 */
	public Long incr(String key, long liveTime) {
		RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
		Long increment = entityIdCounter.getAndIncrement();

		if ((null == increment || increment.longValue() == 0) && liveTime > 0) {// 初始设置过期时间
			entityIdCounter.expire(liveTime, TimeUnit.SECONDS);
		}

		return increment;
	}

	@Override
	protected String getRedisKey() {
		return "idKey";
	}

}