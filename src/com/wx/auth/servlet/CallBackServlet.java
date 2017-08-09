package com.wx.auth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.auth.util.AuthUtil;

import net.sf.json.JSONObject;

/**
 *1.���ǻص���ַ
 * code �ǻش��Ĳ���
 */
public class CallBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AuthUtil.APPID+
					"&secret="+AuthUtil.APPSECRET+
					"&code="+code+
					"&grant_type=authorization_code";
		JSONObject jsonObject=AuthUtil.doGetJson(url);
		String openid=jsonObject.getString("openid");
		String token=jsonObject.getString("access_token");
		String inforUrl="https://api.weixin.qq.com/sns/userinfo?"+
					"access_token="+token+
					 "&openid="+openid+
					 "&lang=zh_CN";
		JSONObject userInfo=AuthUtil.doGetJson(inforUrl);
		System.out.println(userInfo);
		//ʹ��΢���û���Ϣֱ�ӵ�¼
		request.setAttribute("info", userInfo);
		request.getRequestDispatcher("/index1.jsp").forward(request, response);
		
		/**
		*userInfo�е���Ϣ.
		final String strOpenid =(String)userInfo.get("openid");
		System.out.println("openid ++>>>>>"+userInfo.get("openid"));
		
		final String nickname = (String)userInfo.get("nickname");
		System.out.println("nickname++>>>"+userInfo.get("nickname"));
		
		final int sex = (int)userInfo.get("sex");
		System.out.println("sex+>>>"+userInfo.get("sex"));
		
		System.out.println(userInfo.get("city")); //����
		System.out.println(userInfo.get("province"));  //ʡ��
		System.out.println(userInfo.get("headimgurl")); //ͷ��
		*/
	}

	

}
