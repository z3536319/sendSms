package com.dushuai.demo.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dushuai.demo.sms.service.SmsServ;

@RestController
@RequestMapping("/")
public class SmsController {
	
	@Autowired
	private SmsServ smsServ;

	@RequestMapping("/send")
	public String send(String mobile, String content, String tKey) {
		if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(content) || StringUtils.isEmpty(tKey)) {
			return "参数错误!";
		}
		String info = this.smsServ.sendSms(mobile,content,tKey);
		return info;
	}
	
	@RequestMapping("/batchsend")
	public String batchSend(String mobile, String content, String tKey) {
		if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(content) || StringUtils.isEmpty(tKey)) {
			return "参数错误!";
		}
		String info = this.smsServ.sendBatchSms(mobile,content,tKey);
		return info;
	}
}
