package com.example.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.StatusCodeLogin;
import com.example.util.GainOpenid;
import com.example.util.GainToken;

@Controller
@RequestMapping("/")
public class LoginController {

	/**
	 * 根据code返回token,返回json数据
	 * @param code
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public StatusCodeLogin HellowWord(String code){
		StatusCodeLogin statuscode=new StatusCodeLogin();
		String openid= GainOpenid.getopen(code);
		System.out.println("openid:"+openid);

		if(code != null && code !=""){
			//获取token
			String token=GainToken.genToken();
			statuscode.setMessage("登录成功");
			statuscode.setStatus(200);
			Map<String,String> data=new HashMap<>();
			data.put("token",token);
			statuscode.setData(data);
			return statuscode;
		}else{
			statuscode.setMessage("登录失败");
			statuscode.setStatus(200);
			Map<String,String> data=new HashMap<>();
			data.put("token","");
			statuscode.setData(data);
			return statuscode;
		}
	}
}
