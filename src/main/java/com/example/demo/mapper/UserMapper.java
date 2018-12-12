package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.springframework.stereotype.Repository;

public interface UserMapper {
	void insertUser(User user);
	User selectByUid(Integer Uid);
}
