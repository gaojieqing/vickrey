package cn.bugu.vickrey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bugu.vickrey.domain.User;
import cn.bugu.vickrey.service.UserService;

@Controller
public class UserController {
	@Autowired
    UserService userService;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	@ResponseBody
	public User getHelloworld(@RequestParam(value="username") String username,
            @RequestParam(value="password") String password) {
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		return userService.put(user)?user:null;
	}

}
