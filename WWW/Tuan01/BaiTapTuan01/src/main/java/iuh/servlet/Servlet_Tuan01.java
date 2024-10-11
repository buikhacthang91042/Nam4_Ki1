package iuh.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import iuh.entity.User;

/**
 * Servlet implementation class Servlet_Tuan01
 */
@WebServlet("/Servlet_Tuan01")
public class Servlet_Tuan01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Tuan01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Bài 2
		/*
		 * response.setContent Type("text/html"); PrintWriter out = response.getWriter();
		 * out.println("<html>"); out.println("<head>");
		 * out.println("<title>Trang Chào Mừng</title>"); out.println("</head>");
		 * out.println("<body>"); out.println("<p>Hello</p>"); out.println("</body>");
		 * out.println("<footer>"); out.println("<p>Hello</p>");
		 * out.println("</footer>"); out.println("</html>");
		 */
		
		//Bài 3
		
				 
		/*
		 * User user = new User(); user.setId(1); user.setName("John Doe");
		 * user.setEmail("john.doe@example.com");
		 * 
		 * ObjectMapper mapper = new ObjectMapper(); String jsonString =
		 * mapper.writeValueAsString(user);
		 * 
		 * response.setContentType("application/json");
		 * response.getWriter().write(jsonString);
		 */
	
		//Bài 4
		/*
		 * response.setContentType("text/html; charset=UTF-8"); PrintWriter print =
		 * response.getWriter(); String tenDangNhap =
		 * getServletConfig().getInitParameter("Tên đăng nhập"); String matkhau =
		 * getServletConfig().getInitParameter("Mật khẩu");
		 * 
		 * print.println("Tên đăng nhập là: " +tenDangNhap);
		 * print.println("Mật khẩu là: " + matkhau);
		 * 
		 * String ten = getServletContext().getInitParameter("Họ tên");
		 * print.println("Tên của tôi: " + ten);
		 */
		
		//Bài 5
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String Firstname = request.getParameter("Firstname");
        String Lastname = request.getParameter("Lastname");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Result Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Registration Information</h1>");
        out.println("<p>FirstName: " + Firstname + "</p>");
        out.println("<p>LastEmail: " + Lastname + "</p>");
       
        out.println("</body>");
        out.println("</html>");
	}

}
