package cn.bugu.vickrey.dao;

import cn.bugu.vickrey.pojo.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}