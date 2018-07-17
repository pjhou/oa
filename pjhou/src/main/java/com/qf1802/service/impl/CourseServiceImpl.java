package com.qf1802.service.impl;

import com.qf1802.common.vo.PageVo;
import com.qf1802.common.vo.ResultVo;
import com.qf1802.dao.CourseMapper;
import com.qf1802.domain.Course;
import com.qf1802.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper mapper;
	
	@Override
	public boolean insert(Course course) {
		// TODO Auto-generated method stub
		return mapper.insert(course)>0;
	}

	@Override
	public ResultVo update(Course course) {
		// TODO Auto-generated method stub
		if(mapper.updateById(course)>0) {
			return ResultVo.setOK("修改学科成功");
		}else {
			return ResultVo.setERROR("修改学科失败");
		}
		
	}

	@Override
	public ResultVo delete(int id) {
		// TODO Auto-generated method stub
		if(mapper.deleteById(id)>0) {
			return ResultVo.setOK("删除学科成功");
		}else {
			return ResultVo.setERROR("删除学科失败");
		}
	}

	@Override
	public List<Course> queryAll() {
		// TODO Auto-generated method stub
		return mapper.queryAll();
	}

	@Override
	public PageVo<Course> queryByPage(int page, int count) {
		// TODO Auto-generated method stub
		int index=0;
		if(page>0) {
			index=(page-1)*count;
		}
		PageVo<Course> po=new PageVo<>();
		po.setData(mapper.queryByPage(index, count));
		if(po.getData()!=null) {
			po.setCount(mapper.queryCount().intValue());
		}
		po.setCode(0);
		po.setMsg("OK");
		return po;
	}


}
