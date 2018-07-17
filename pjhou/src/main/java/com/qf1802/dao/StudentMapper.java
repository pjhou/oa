package com.qf1802.dao;



import com.qf1802.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface StudentMapper {
	@Update("update t_student set flag=2 where no=#{no}")
    int deleteByNo(String no);
	@Insert("insert into t_student (no, name, sex, birthday, cardno, school, education, gid, flag,  email, qq, phone, introno,  createdate, photo) values (#{no}, #{name}, #{sex},  #{birthday,jdbcType=DATE}, #{cardno}, #{school},  #{education}, #{gid}, 1,  #{email}, #{qq}, #{phone}, #{introno}, #{createdate,jdbcType=DATE},null)")
    int insert(Student record);
	@Select("select  no, name, sex, birthday, cardno, school, education, gid, flag, email, qq, phone,introno, createdate, photo from t_student where no=#{no}")
    Student selectByNo(String no);
	@Update("update t_student set  photo = #{photo} where no = #{no}")
    int updateByNo(@Param("photo") String photo, @Param("no") String no);
    //查询  分页
  	@Select("select no, name, sex, birthday, cardno, school, education, gid, flag, email, qq, phone,introno, createdate, photo from t_student where flag=1 limit #{rowindex},#{count}")
  	@ResultType(Student.class)
	List<Student> queryByPage(@Param("rowindex") int index, @Param("count") int count);
  	
  	//总数量
  	@Select("select count(*) from t_student where flag=1")
  	@ResultType(Long.class)
  	Long queryCount();
  	//查询  班级人数
  	@Select("select no, name, sex, birthday, cardno, school, education, gid, flag, email, qq, phone,introno, createdate, photo from t_student where flag=1 and gid=#{gid}")
  	@ResultType(Student.class)
  	List<Student> queryByGid(int gid);
  	
  	//总数量
  	@Select("select count(*) from t_student where flag=1 and gid=#{gid}")
  	@ResultType(Long.class)
  	Long queryCountGid(int gid);
}