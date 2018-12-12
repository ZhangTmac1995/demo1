package com.example.demo.service;

import com.example.demo.bean.User;

public interface IUserService {
	void addUser(User user);
	User selectById(Integer id);
}
