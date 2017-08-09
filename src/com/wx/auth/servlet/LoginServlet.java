package com.wx.auth.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.auth.util.AuthUtil;

/**
 * �����û�����ӿ�
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��Ӧ�Ļص���������Ҫ���ڹ���ƽ̨����д��"��ҳ��Ȩ����"����һ��.
		String backUrl="http://wx.fenghongzhang.com/WeChat2048/CallBackServlet";  //�������ܹ�����
		//String backUrl="http://www.fenghongzhang.com/WeChat2048/CallBackServlet";  //�������ܹ�����
		String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AuthUtil.APPID+
				    "&redirect_uri="+URLEncoder.encode(backUrl)+
				    "&response_type=code"+
				    "&scope=snsapi_userinfo"+
				    "&state=STATE#wechat_redirect"; //state��ҳ����໥�����õ�.
		response.sendRedirect(url);
	}

	

}
