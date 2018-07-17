package com.qf1802.service;

import java.util.List;


import com.qf1802.domain.LoginLog;

public interface LoginLogService {

	boolean insert(LoginLog log);
	List<LoginLog> queryAll();
}
