package com.qf1802.dao;



import com.qf1802.domain.LoginLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface LoginLogMapper {
	@Insert("insert into t_loginlog (ip, no, createtime,location) values ( #{ip,jdbcType=VARCHAR}, #{no,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, #{location,jdbcType=VARCHAR})")
    int insert(LoginLog record);
	@Select("select id, ip, no, createtime, location from t_loginlog order by createtime desc limit 15")
    @ResultType(LoginLog.class)
	List<LoginLog> queryAll();
}