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

import dao.DienThoaiDAO;
import dao.NhaCCDAO;
import daoIMPL.DienThoaiDAOIMPL;
import daoIMPL.NhaCCIMPL;
import entities.DienThoai;
import entities.NhaCungCap;

/**
 * Servlet implementation class DanhSachDienThoaiNCCServlet
 */
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DienThoaiDAO dienThoaiDao;
	private NhaCCDAO nhaCCDAO;
	private EntityManagerFactoryUtil emu;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachDienThoaiNCCServlet() {

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.emu = new EntityManagerFactoryUtil();
		this.dienThoaiDao = new DienThoaiDAOIMPL(emu.getEnManager());
		this.nhaCCDAO = new NhaCCIMPL(emu.getEnManager());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int maNCC = 0;
		String MANCC = request.getParameter("mancc");
		System.out.println("MANCC: " + MANCC);

		if (MANCC != null && !MANCC.isEmpty()) {
			try {
				maNCC = Integer.parseInt(MANCC);
			} catch (NumberFormatException e) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Mã không hợp lệ");
				return;
			}
		}
		List<NhaCungCap> listNCC = null;
		listNCC = nhaCCDAO.findAll();
		System.out.println(listNCC);
		request.setAttribute("NhaCCList", listNCC);

		List<DienThoai> listDT = null;
		listDT = dienThoaiDao.findAll();
		request.setAttribute("dienThoaiList", listDT);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/DanhSachDienThoaiNCC.jsp");
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
