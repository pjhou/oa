package com.qf1802.service;

import java.util.List;

import com.qf1802.common.vo.PageVo;
import com.qf1802.common.vo.ResultVo;
import com.qf1802.domain.Student;

public interface StudentService {

	//新增
	boolean insert(Student student);
	ResultVo update(Student student);
	ResultVo delete(String no);
	List<Student> queryAll();
	PageVo<Student> queryByPage(int page, int count);
	List<Student> queryByGid(int gid);
	Long queryCountBiGid(int gid);
	
	boolean insertBatch(List<Student> list);
	
}
