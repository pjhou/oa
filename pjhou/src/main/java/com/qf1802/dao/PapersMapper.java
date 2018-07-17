package com.qf1802.dao;


import com.qf1802.domain.Papers;

public interface PapersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Papers record);

    int insertSelective(Papers record);

    Papers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Papers record);

    int updateByPrimaryKey(Papers record);
}