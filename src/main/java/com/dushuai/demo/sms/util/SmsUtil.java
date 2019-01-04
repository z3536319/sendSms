package com.dushuai.demo.sms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsUtil {
	
	@Value("${sms.single.send.url}")
	private String sendUrl;
	@Value("${sms.single.username}")
	private String username;
	@Value("${sms.single.pwd}")
	private String pwd;
	@Value("${sms.batch.send.url}")
	private String batchSendUrl;
	@Value("${sms.batch.username}")
	private String batchUsername;
	@Value("${sms.batch.pwd}")
	private String batchPwd;
	@Value("${sms.batch.time.url}")
	private String batchTimeUrl;
	@Value("${sms.report.url}")
	private String reportUrl;

	public String sendSingleSms(String mobile, String content, String tKey) {
		String info = null;
		//String tKey = getTkey();
		try{
			HttpClient httpclient = new HttpClient();
			PostMethod post = new PostMethod(sendUrl);
			post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
			post.addParameter("username", username);
			post.addParameter("mobile", mobile);
			post.addParameter("content", content);
			post.addParameter("tkey", tKey);
			post.addParameter("password", getPwd(tKey,pwd));
			httpclient.executeMethod(post);
			info = new String(post.getResponseBody(),"utf-8");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
	
	public String sendBatchSms(String mobile, String content, String tKey) {
		String info = null;
		//String tKey = getTkey();
		try{
			HttpClient httpclient = new HttpClient();
			PostMethod post = new PostMethod(batchSendUrl);
			post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
			post.addParameter("username", batchUsername);
			post.addParameter("mobile", mobile);
			post.addParameter("content", content);
			post.addParameter("tkey", tKey);
			post.addParameter("password", getPwd(tKey,batchPwd));
			httpclient.executeMethod(post);
			info = new String(post.getResponseBody(),"utf-8");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
	
	public String sendBatchTimeSms(String mobile, String content, String tKey, String time) {
		String info = null;
		//String tKey = getTkey();
		try{
			HttpClient httpclient = new HttpClient();
			PostMethod post = new PostMethod(batchTimeUrl);
			post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
			post.addParameter("username", batchUsername);
			post.addParameter("mobile", mobile);
			post.addParameter("content", content);
			post.addParameter("time", time);
			post.addParameter("tkey", tKey);
			post.addParameter("password", getPwd(tKey,batchPwd));
			httpclient.executeMethod(post);
			info = new String(post.getResponseBody(),"utf-8");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
	
	public String report(String tKey) {
		String info = null;
		//String tKey = getTkey();
		try{
			HttpClient httpclient = new HttpClient();
			PostMethod post = new PostMethod(reportUrl);
			post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
			post.addParameter("username", batchUsername);
			post.addParameter("tkey", tKey);
			post.addParameter("password", getPwd(tKey,batchPwd));
			httpclient.executeMethod(post);
			info = new String(post.getResponseBody(),"utf-8");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
	
	private String getTkey(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
	
	private String getPwd(String tKey, String password) {
		return MD5.encode((MD5.encode(password).toLowerCase()+tKey)).toLowerCase();
	}

}
