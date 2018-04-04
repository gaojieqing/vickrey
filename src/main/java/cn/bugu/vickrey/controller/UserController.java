package cn.bugu.vickrey.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bugu.vickrey.domain.User;
import cn.bugu.vickrey.service.UserService;

@Controller
public class UserController {

	private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public User getUser(@RequestParam Map<String, String> map) {
		User user = new User();
		logger.info("username:" + map.get("username"));
		user.setUserName(map.get("username"));
		logger.info("password:" + map.get("password"));
		user.setPassword(map.get("password"));
		return userService.put(user) ? user : null;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public User postUser(@RequestBody Map<String, String> map) {
		User user = new User();
		logger.info("username:" + map.get("username"));
		user.setUserName(map.get("username"));
		logger.info("password:" + map.get("password"));
		user.setPassword(map.get("password"));
		return userService.put(user) ? user : null;
	}

	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteUser(@RequestBody Map<String, String> map) {
		return userService.delete(map.get("username")) ? true : false;
	}

}
