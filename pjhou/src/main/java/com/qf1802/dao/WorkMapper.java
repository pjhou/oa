package com.qf1802.dao;


import com.qf1802.domain.Work;

public interface WorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}