package com.dushuai.demo.sms.service;

public interface SmsServ {

	String sendSms(String mobile, String content, String tKey);

	String sendBatchSms(String mobile, String content, String tKey);

	String sendBatchTImeSms(String mobile, String content, String tKey, String time);

	String report(String tKey);

}
