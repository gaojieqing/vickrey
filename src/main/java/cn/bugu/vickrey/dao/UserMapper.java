package cn.bugu.vickrey.dao;

import cn.bugu.vickrey.domain.User;

public interface UserMapper {
    int insert(User record);
    
    int delete(String username);

    int insertSelective(User record);
}