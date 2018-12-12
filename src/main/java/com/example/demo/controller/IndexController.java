package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.ResponseResult;
import com.example.demo.bean.User;
import com.example.demo.service.IUserService;
import com.example.demo.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController

public class IndexController {
	@Autowired
	private IUserService userService;
	
	/**
	 * 
	 * @return String
	 */
	@RequestMapping(value="/index" ,method = RequestMethod.GET)
	@ResponseBody
	public String getIndex() {
		return "index";
	}
	
	

	
	@RequestMapping(value="/index2" ,method = RequestMethod.GET)
	public ModelAndView index2() {
		ModelAndView mv = new ModelAndView("web/index.html");
		return mv;
	}
	
	@RequestMapping(value="/add" ,method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> index3(String name,Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		userService.addUser(user);
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"success");
		return rr;
	}

	@RequestMapping(value = "/select",method = RequestMethod.GET)
	public ModelAndView index4(Integer uid){
		System.out.println(uid);
		User user = userService.selectById(uid);
		System.out.println(user);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user",user);
		ModelAndView mv = new ModelAndView("web/list.html",map);

		return mv;
	}
	
	
}
