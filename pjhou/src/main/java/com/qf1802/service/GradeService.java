package com.qf1802.service;


import com.qf1802.common.vo.PageVo;
import com.qf1802.common.vo.ResultVo;
import com.qf1802.domain.Grade;

import java.util.List;

public interface GradeService {

	//新增
	boolean insert(Grade grade);
	ResultVo update(Grade grade);
	ResultVo delete(int id);
	List<Grade> queryAll();
	PageVo<Grade> queryByPage(int page, int count);
	
	
}
