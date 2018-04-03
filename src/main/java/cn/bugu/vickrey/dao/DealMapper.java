package cn.bugu.vickrey.dao;

import cn.bugu.vickrey.domain.Deal;

public interface DealMapper {
    int insert(Deal record);

    int insertSelective(Deal record);
}