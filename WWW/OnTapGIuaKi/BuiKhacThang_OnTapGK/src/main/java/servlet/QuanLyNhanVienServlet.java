package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.util.List;

import dao.NhanVienDAO;
import daoIMPL.NhanVienDAOImpl;
import enitties.NhanVien;

/**
 * Servlet implementation class QuanLyNhanVienServlet
 */
@WebServlet("/QuanLyNhanVienServlet")
public class QuanLyNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NhanVienDAO nhanVienDao;
    private EntityManagerFactoryUtil emfu;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public QuanLyNhanVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.emfu = new EntityManagerFactoryUtil();
		this.nhanVienDao = new NhanVienDAOImpl(emfu.getEm());
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maPhongBan = request.getParameter("maPhongBan");
		List<NhanVien> danhSachNhanVien;
		int count =0 ;
		if(maPhongBan == null || maPhongBan.isEmpty()) {
			danhSachNhanVien = nhanVienDao.findAll();
			for (int i = 0; i < danhSachNhanVien.size(); i++) {
				count++;
			}
			request.setAttribute("tongNhanVien", count);
		}else {
		
			danhSachNhanVien = nhanVienDao.hienThiDSNhanVienTheoPhongBan(maPhongBan);
			for (int i = 0; i < danhSachNhanVien.size(); i++) {
				count++;
			}
			request.setAttribute("tongNhanVien", count);
		}
		request.setAttribute("danhSachNhanVien", danhSachNhanVien);
		request.getRequestDispatcher("/DanhSachNhanVien.jsp").forward(request, response);

 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maNhanVien = request.getParameter("maNhanVien");
		nhanVienDao.xoaNhanVien(maNhanVien);
		 response.sendRedirect(request.getContextPath() + "/QuanLyNhanVienServlet");
	}

}
