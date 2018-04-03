package cn.bugu.vickrey.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bugu.vickrey.dao.UserMapper;
import cn.bugu.vickrey.domain.User;
import cn.bugu.vickrey.service.impl.IUserService;

@Service("userService")
public class UserService implements IUserService{
	@Resource
	private UserMapper userMapper;

	@Override
	public boolean put(User user) {
		return userMapper.insertSelective(user)==1?true:false;
	}
}
