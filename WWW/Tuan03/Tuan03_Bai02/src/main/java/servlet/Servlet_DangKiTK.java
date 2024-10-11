package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.util.List;

import dao.TaiKhoanDAO;
import daoImplement.TaiKhoanDAOIMPL;
import entities.TaiKhoan;

/**
 * Servlet implementation class Servlet_DangKiTK
 */
public class Servlet_DangKiTK extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManageFactory;
	private TaiKhoanDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_DangKiTK() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.entityManageFactory = new EntityManagerFactoryUtil();
		this.dao = new TaiKhoanDAOIMPL(this.entityManageFactory.getEnManager());
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String gender = request.getParameter("gender");
		
		TaiKhoan tk = new TaiKhoan();
		tk.setFirstName(firstName);
		tk.setLastName(lastName);
		tk.setEmail(email);
		tk.setPassWord(password);
		tk.setGender(gender);
		
		this.dao.save(tk);
		request.setAttribute("taikhoan", tk);
		List<TaiKhoan> list = this.dao.findAll();
		System.out.println(list);
        request.setAttribute("tkList", list);
        RequestDispatcher rd = request.getRequestDispatcher("ListTaiKhoan.jsp");
        rd.forward(request, response);
	}

}
