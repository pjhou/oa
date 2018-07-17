package com.qf1802.service;


import com.qf1802.common.vo.PageVo;
import com.qf1802.common.vo.ResultVo;
import com.qf1802.domain.Course;

import java.util.List;

public interface CourseService {

	//新增
	boolean insert(Course course);
	ResultVo update(Course course);
	ResultVo delete(int id);
	List<Course> queryAll();
	PageVo<Course> queryByPage(int page, int count);
	
	
}
