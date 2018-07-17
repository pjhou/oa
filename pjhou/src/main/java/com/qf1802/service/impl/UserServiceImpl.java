package com.qf1802.service.impl;


import java.util.List;
import java.util.Objects;

import com.qf1802.common.util.MD5Utils;
import com.qf1802.dao.UserMapper;
import com.qf1802.domain.User;
import com.qf1802.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper dao;
	//成功 有对象 失败 null
	@Override
	public User queryByNo(String no, String password) {
		// TODO Auto-generated method stub
		User user=dao.queryByNo(no);
		if(user!=null) {
//			System.out.println("shur :"+MD5Utils.md5(password));
//			System.out.println("shujuk :"+user.getPassword());
			if(Objects.equals(MD5Utils.md5(password), user.getPassword())){
				return user;
			}
		}
		return null;
	}
	@Override
	public boolean updatePassword(User user) {
		// TODO Auto-generated method stub
		user.setPassword(MD5Utils.md5(user.getPassword()));
		return dao.updatePassword(user)>0;
	}
	@Override
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		return dao.insert(user)>0;
	}
	@Override
	public boolean insertBach(List<User> list) {
		// TODO Auto-generated method stub
		try {
			for(User u:list) {
				dao.insert(u);
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}

}
