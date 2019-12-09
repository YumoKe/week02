package com.wangkaiteng.utils;

import java.util.Date;

public class Utils {

	// 设置名字
	public static String setName(){
		String name = "";
		for (int i = 0; i < 3; i++) {
			name += RandomString.getRandomChar();
		}
		return name;
	}
	
	//性别
	public static String setSex(){
		if ((int)(Math.random() * 10) > 5) {
			return "男";
		} else {
			return "女";
		}
	}
	
	// 手机号
	public static String setPhone(){
		return UserRandomUtil.getPhone();
	}
	
	// 邮箱
	public static String setEmail(){
		return UserRandomUtil.getEmail();
	}
	
	// 生日
	public static Date setAge(){
		return TimeRandomUtil.randomDate("1949-01-01 00:00:00", "2001-01-01 00:00:00");
	}
	
	public static void main(String[] args) {
		System.out.println(setAge());
	}
}
