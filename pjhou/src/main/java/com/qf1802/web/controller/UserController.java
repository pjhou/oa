package com.qf1802.web.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf1802.common.vo.PageVo;
import com.qf1802.domain.LoginLog;
import com.qf1802.domain.User;
import com.qf1802.service.LoginLogService;
import com.qf1802.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


//操作用户表
@Controller
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	private LoginLogService logService;
	//InternalResourceViewResolver
	//登录
	@RequestMapping(value="/login.do",method= {RequestMethod.POST})
	public String login(String no,String pass,String ip,String city,HttpSession session,HttpServletResponse resp) {
		User user=service.queryByNo(no, pass);
		if(user!=null) {
			session.setAttribute("user", user);
			Cookie ck=new Cookie("user", user.getNo());
			ck.setMaxAge(-1);
			resp.addCookie(ck);
			LoginLog log=new LoginLog();
			log.setCreatetime(new Date());
			log.setIp(ip);
			log.setNo(no);
			log.setLocation(city);
			logService.insert(log);
			return "index";
		}else {
			return "login";
		}
	}
	//注销
	@RequestMapping("/loginout.do")
	public String loginout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
	//查询登录历史
	@RequestMapping("/loginloglist.do")
	@ResponseBody
	public PageVo<LoginLog> list()
	{
		PageVo<LoginLog> po=new PageVo<>();
		po.setData(logService.queryAll());
		po.setCode(0);
		po.setCount(po.getData().size());
		po.setMsg("OK");
		return po;
	}

}
