package com.wangkaiteng.test;




import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wangkaiteng.beans.User;
import com.wangkaiteng.utils.Utils;

@SuppressWarnings("all")
// 设置运行时的框架
@RunWith(SpringJUnit4ClassRunner.class)
// 设置配置文件
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class Demo {

	// IOC自动装配
	@Resource
	RedisTemplate redisTemplate;
	
	@Test
	public void showJDK(){
		// 获取redis
		ValueOperations ofv = redisTemplate.opsForValue();
		// 系统线程开始执行时间
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			// 设置User属性
			User user = new User();
			user.setId(i);
			user.setSex(Utils.setSex());
			user.setBirthday(Utils.setAge());
			user.setEmail(Utils.setEmail());
			user.setName(Utils.setName());
			user.setPhone(Utils.setPhone());
			ofv.set(i+"", user);
		}
		// 系统线程结束时间
		long end = System.currentTimeMillis();
		System.out.println("JDK耗时:"+ (end - begin));
	}
	
	
	@Test
	public void showJSON(){
		// 获取redis
		ValueOperations ofv = redisTemplate.opsForValue();
		// 系统线程开始执行时间
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			// 设置User属性
			User user = new User();
			user.setId(i);
			user.setSex(Utils.setSex());
			user.setBirthday(Utils.setAge());
			user.setEmail(Utils.setEmail());
			user.setName(Utils.setName());
			user.setPhone(Utils.setPhone());
			ofv.set(i+"", user);
		}
		// 系统线程结束时间
		long end = System.currentTimeMillis();
		System.out.println("JSON:"+ (end - begin));
	}
	
	@Test
	public void showHash(){
		// 绑定key
		BoundHashOperations boundHashOps = redisTemplate.boundHashOps("user_val");
		// 系统线程开始执行时间
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			// 设置User属性
			User user = new User();
			user.setId(i);
			user.setSex(Utils.setSex());
			user.setBirthday(Utils.setAge());
			user.setEmail(Utils.setEmail());
			user.setName(Utils.setName());
			user.setPhone(Utils.setPhone());
			boundHashOps.put(i+"", user.toString());
		}
		// 系统线程结束时间
		long end = System.currentTimeMillis();
		System.out.println("Hash耗时:"+ (end - begin));
	}
}
