package com.jungle.learning.weblearning.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jungle.learning.weblearning.helper.RequestParams;
import com.jungle.learning.weblearning.model.UserInfo;
import com.jungle.learning.weblearning.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
       
	private static final long serialVersionUID = -7945645905061241350L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestParams rp = new RequestParams(request);
		String name = rp.getString("username");
		String pass = rp.getString("password");
		RegisterService rs = new RegisterService();
		rs.register(new UserInfo(name, pass));
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
