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

import dao.NhaCCDAO;
import daoIMPL.NhaCCIMPL;
import entities.NhaCungCap;

/**
 * Servlet implementation class TrangChuServlet
 */
public class TrangChuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil emu;
	private NhaCCDAO nhaCCDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrangChuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.emu = new EntityManagerFactoryUtil();
		this.nhaCCDAO = new NhaCCIMPL(emu.getEnManager());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		NhaCungCap ncc0 = new NhaCungCap();

		ncc0.setTenNhaCungCap("Nokia");
		ncc0.setSoDienThoai("0123456789");
		ncc0.setDiaChi("2A Hàng Bông");
		nhaCCDAO.addNCC(ncc0);

		NhaCungCap ncc1 = new NhaCungCap();

		ncc1.setTenNhaCungCap("SamSung");
		ncc1.setSoDienThoai("147896523");
		ncc1.setDiaChi("8B Hàng Gánh");
		nhaCCDAO.addNCC(ncc1);

		NhaCungCap ncc2 = new NhaCungCap();

		ncc2.setTenNhaCungCap("Xiaomi");
		ncc2.setSoDienThoai("45786325778");
		ncc2.setDiaChi("2A Hàng Nón");
		nhaCCDAO.addNCC(ncc2);

		NhaCungCap ncc3 = new NhaCungCap();

		ncc3.setTenNhaCungCap("Lenovo");
		ncc3.setSoDienThoai("147589355");
		ncc3.setDiaChi("5A Hàng Mã");
		nhaCCDAO.addNCC(ncc3);

		NhaCungCap ncc4 = new NhaCungCap();

		ncc4.setTenNhaCungCap("Iphone");
		ncc4.setSoDienThoai("0123457859");
		ncc4.setDiaChi("4A Hàng Bài");
		nhaCCDAO.addNCC(ncc4);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/trangChu.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
