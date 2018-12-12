package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;

import javax.annotation.Resource;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public void addUser(User user) {
		System.out.println("ok!"+user);
		userMapper.insertUser(user);
		System.out.println("ok");
	}


	@Override
	public User selectById(Integer id) {
		User user = userMapper.selectByUid(id);
		return user;
	}
}
