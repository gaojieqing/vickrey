package cn.bugu.vickrey.dao;

import cn.bugu.vickrey.domain.Bid;

public interface BidMapper {
    int insert(Bid record);

    int insertSelective(Bid record);
}