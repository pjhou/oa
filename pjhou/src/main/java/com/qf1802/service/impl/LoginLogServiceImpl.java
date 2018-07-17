package com.qf1802.service.impl;

import com.qf1802.dao.LoginLogMapper;
import com.qf1802.domain.LoginLog;
import com.qf1802.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginLogServiceImpl implements LoginLogService {

	@Autowired
	private LoginLogMapper mapper;
	@Override
	public boolean insert(LoginLog log) {
		// TODO Auto-generated method stub
		return mapper.insert(log)>0;
	}

	@Override
	public List<LoginLog> queryAll() {
		// TODO Auto-generated method stub
		return mapper.queryAll();
	}

}
