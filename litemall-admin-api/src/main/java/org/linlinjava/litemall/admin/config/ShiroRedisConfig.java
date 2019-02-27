package org.linlinjava.litemall.admin.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.linlinjava.litemall.admin.shiro.AdminAuthorizingRealm;
import org.linlinjava.litemall.admin.shiro.AdminWebSessionManager;
import org.linlinjava.litemall.db.domain.LitemallAdmin;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class ShiroRedisConfig {

	@Bean
	public Realm realm() {
		return new AdminAuthorizingRealm();
	}

	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/admin/auth/login", "anon");
		filterChainDefinitionMap.put("/admin/auth/401", "anon");
		filterChainDefinitionMap.put("/admin/auth/index", "anon");
		filterChainDefinitionMap.put("/admin/auth/403", "anon");
		filterChainDefinitionMap.put("/admin/**", "authc");
		shiroFilterFactoryBean.setLoginUrl("/admin/auth/401");
		shiroFilterFactoryBean.setSuccessUrl("/admin/auth/index");
		shiroFilterFactoryBean.setUnauthorizedUrl("/admin/auth/403");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean
	public SessionManager sessionManager() {
		// AdminWebSessionManager mySessionManager = new AdminWebSessionManager();
		// return mySessionManager;
		// DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		DefaultWebSessionManager sessionManager = new AdminWebSessionManager();
		sessionManager.setGlobalSessionTimeout(redisConfig().getTimeout()); // 设置session超时
		sessionManager.setDeleteInvalidSessions(true); // 删除无效session
		sessionManager.setSessionIdCookie(cookie()); // 设置JSESSIONID
		sessionManager.setSessionDAO(sessionDAO()); // 设置sessionDAO
		return sessionManager;
	}

	@Bean
	public DefaultWebSecurityManager securityManager() {
		// DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// securityManager.setRealm(realm());
		// securityManager.setSessionManager(sessionManager());
		// return securityManager;
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(realm()); // 设置realm
		securityManager.setSessionManager(sessionManager()); // 设置sessionManager
		securityManager.setCacheManager(redisCacheManager()); //
		// 配置缓存的话，退出登录的时候crazycake会报错，要求放在session里面的实体类必须有个id标识
		return securityManager;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public static DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}

	// ========================== 以下为 Redis 配置 ==============================
	@Bean
	public RedisConfig redisConfig() {
		return new RedisConfig();
	}

	@Bean
	public RedisManager redisManager() {
		RedisManager redisManager = new RedisManager(); // crazycake 实现
		redisManager.setHost(redisConfig().getHost());
		redisManager.setPassword(redisConfig().getPassword());
		redisManager.setTimeout(redisConfig().getTimeout());
		return redisManager;
	}

	@Bean
	public JavaUuidSessionIdGenerator sessionIdGenerator() {
		return new JavaUuidSessionIdGenerator();
	}

	@Bean
	public RedisSessionDAO sessionDAO() {
		RedisSessionDAO sessionDAO = new RedisSessionDAO(); // crazycake 实现
		sessionDAO.setRedisManager(redisManager());
		sessionDAO.setSessionIdGenerator(sessionIdGenerator()); // Session ID 生成器
		return sessionDAO;
	}

	@Bean
	public SimpleCookie cookie() {
		SimpleCookie cookie = new SimpleCookie("SHAREJSESSIONID"); // cookie的name,对应的默认是 JSESSIONID
		cookie.setHttpOnly(true);
		cookie.setPath("/"); // path为 / 用于多个系统共享JSESSIONID
		return cookie;
	}

	@Bean
	public RedisCacheManager redisCacheManager() {
		RedisCacheManager cacheManager = new RedisCacheManager(); // crazycake 实现
		cacheManager.setRedisManager(redisManager());
		return cacheManager;
	}

	/**
	 * 配置RedisTemplate，充当数据库服务
	 *
	 * @return
	 */
	@Bean
	public RedisTemplate<String, LitemallAdmin> redisTemplate111(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, LitemallAdmin> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<LitemallAdmin>(LitemallAdmin.class));
		return redisTemplate;
	}

	/**
	 * 配置RedisTemplate，充当数据库服务
	 *
	 * @return
	 */
	// @Bean
	// public RedisTemplate<String, LitemallAdmin>
	// redisTemplate(RedisConnectionFactory connectionFactory) {
	// RedisTemplate<String, LitemallAdmin> redisTemplate = new RedisTemplate<>();
	// redisTemplate.setConnectionFactory(connectionFactory);
	// redisTemplate.setKeySerializer(new StringRedisSerializer());
	// redisTemplate.setValueSerializer(new
	// Jackson2JsonRedisSerializer<LitemallAdmin>(LitemallAdmin.class));
	// return redisTemplate;
	// }

	@Bean(name = "redisTemplate")
	public RedisTemplate<byte[], Object> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<byte[], Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}

}
