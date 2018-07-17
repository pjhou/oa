package com.qf1802.service;


import com.qf1802.common.vo.PageVo;
import com.qf1802.common.vo.ResultVo;
import com.qf1802.domain.Depart;

import java.util.List;

public interface DepartService {

	//新增
	boolean insert(Depart depart);
	ResultVo update(String name, int id);
	ResultVo delete(int id);
	PageVo<Depart> queryByPage(int page, int count);
	Long queryCount(int index, int count);
	List<Depart> queryAll();
	
}
