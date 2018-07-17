package com.qf1802.service;


import com.qf1802.common.vo.PageVo;
import com.qf1802.common.vo.ResultVo;
import com.qf1802.domain.Staff;

import java.util.List;

public interface StaffService {

	//新增
	boolean insert(Staff staff);
	ResultVo update(Staff staff);
	ResultVo delete(String no);
	List<Staff> queryAll();
	PageVo<Staff> queryByPage(int page, int count);
	String queryMaxNo();
	boolean insertBatch(List<Staff> list);
	
}
