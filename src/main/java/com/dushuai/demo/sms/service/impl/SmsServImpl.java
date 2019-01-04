package com.dushuai.demo.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dushuai.demo.sms.service.SmsServ;
import com.dushuai.demo.sms.util.SmsUtil;

@Service("smsServ")
public class SmsServImpl implements SmsServ{

	@Autowired
	private SmsUtil smsUtil;
	
	@Override
	public String sendSms(String mobile, String content, String tKey) {
		return smsUtil.sendSingleSms(mobile, content,tKey);
	}

	@Override
	public String sendBatchSms(String mobile, String content, String tKey) {
		return smsUtil.sendBatchSms(mobile, content, tKey);
	}

	@Override
	public String sendBatchTImeSms(String mobile, String content, String tKey, String time) {
		return smsUtil.sendBatchTimeSms(mobile, content, tKey, time);
	}

	@Override
	public String report(String tKey) {
		return smsUtil.report(tKey);
	}

}
