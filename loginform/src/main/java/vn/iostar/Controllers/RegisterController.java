package vn.iostar.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.Models.UserModel;
import vn.iostar.dao.IUserDao;
import vn.iostar.dao.impl.UserDaoimpl;


@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
 

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
		resp.sendRedirect(req.getContextPath() + "/login");
		return;
		 }
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
		for (Cookie cookie : cookies) {
		 if (cookie.getName().equals("username")) {
		session = req.getSession(true);
		session.setAttribute("username", cookie.getValue());
		resp.sendRedirect(req.getContextPath() + "/login");
		return;
		 }
		}
		}
		req.getRequestDispatcher("views/web/register.jsp").forward(req, resp);
		}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String rp = req.getParameter("rp");
		
		if(!password.equals(rp)) {
			resp.sendRedirect("views/web/register.jsp");
		}
		else {
			IUserDao userDao = new UserDaoimpl();
			UserModel a = userDao.checkExistUsername(username);
			if(a == null)
			{
				userDao.register(username, password, email);
				resp.sendRedirect("/login");
			}
			else {
				resp.sendRedirect("views/web/register.jsp");
			}
		}
		
		
		

}
	
}

	

	


