package com.qf1802.service.impl;

import com.qf1802.common.vo.PageVo;
import com.qf1802.common.vo.ResultVo;
import com.qf1802.dao.StaffMapper;
import com.qf1802.domain.Staff;
import com.qf1802.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffMapper mapper;
	
	@Override
	public boolean insert(Staff staff) {
		// TODO Auto-generated method stub
		/*String no=mapper.queryMaxNo();
		if(no==null) {
			no="QF000001";
		}else {
			no=Integer.parseInt(no.substring(2))+1;
			
		}
		staff.setNo(no);*/
		return mapper.insert(staff)>0;
	}

	@Override
	public ResultVo update(Staff staff) {
		// TODO Auto-generated method stub
		if(mapper.updateById(staff)>0) {
			return ResultVo.setOK("修改员工成功");
		}else {
			return ResultVo.setERROR("修改员工失败");
		}
		
	}

	@Override
	public ResultVo delete(String no) {
		// TODO Auto-generated method stub
		if(mapper.deleteById(no)>0) {
			return ResultVo.setOK("删除员工成功");
		}else {
			return ResultVo.setERROR("删除员工失败");
		}
	}

	@Override
	public List<Staff> queryAll() {
		// TODO Auto-generated method stub
		return mapper.queryAll();
	}

	@Override
	public PageVo<Staff> queryByPage(int page, int count) {
		// TODO Auto-generated method stub
		int index=0;
		if(page>0) {
			index=(page-1)*count;
		}
		PageVo<Staff> po=new PageVo<>();
		po.setData(mapper.queryByPage(index, count));
		if(po.getData()!=null) {
			po.setCount(mapper.queryCount().intValue());
		}
		po.setCode(0);
		po.setMsg("OK");
		return po;
	}

	@Override
	public String queryMaxNo() {
		// TODO Auto-generated method stub
		return mapper.queryMaxNo();
	}

	@Override
	public boolean insertBatch(List<Staff> list) {
		// TODO Auto-generated method stub
		
		try {
			for(Staff s:list) {
				mapper.insert(s);
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


}
