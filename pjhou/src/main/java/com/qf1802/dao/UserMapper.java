package com.qf1802.dao;

import com.qf1802.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



public interface UserMapper {

	//新增
	@Insert("insert into t_user(no,password,role,flag) values(#{no},#{password},#{role},1)")
	public int insert(User user);
	//查询
	@Select("select * from t_user where no=#{no} and flag=1 and role>1")
	@ResultType(User.class)
	public User queryByNo(String no);
	//修改密码
	@Update("update t_user set password=#{password} where flag=1 and role>1 and no=#{no}")
	public int updatePassword(User user);


}
