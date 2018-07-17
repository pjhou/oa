package com.qf1802.dao;


import com.qf1802.domain.Report;

public interface ReportMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKeyWithBLOBs(Report record);

    int updateByPrimaryKey(Report record);
}