package servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;

import dao.DienThoaiDAO;
import dao.NhaCCDAO;
import daoIMPL.DienThoaiDAOIMPL;
import daoIMPL.NhaCCIMPL;
import entities.DienThoai;
import entities.NhaCungCap;

/**
 * Servlet implementation class ThemMoiSanPhamServlet
 */
@WebServlet("/ThemMoiSanPhamServlet")
public class ThemMoiSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("tuan05");
		
	}
    public ThemMoiSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager en = emf.createEntityManager();
		NhaCCDAO nccDAO = new NhaCCIMPL(en);
		List<NhaCungCap> listNCC =  nccDAO .findAll();
		request.setAttribute("NhaCCList", listNCC);
		request.getRequestDispatcher("/ThemMoiSanPham.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maDTStr = request.getParameter("madt");
		String tenDT = request.getParameter("tenDienThoai");
		String namSXStr = request.getParameter("namSanXuat");
		String cauHinh = request.getParameter("cauHinh");
		String nhaCC = request.getParameter("NhaCC");
		String hinhAnh = request.getParameter("hinhAnh");
		
		int maDT = Integer.parseInt(maDTStr);
		int namSX = Integer.parseInt(namSXStr);
		
		DienThoai dt = new DienThoai();
		dt.setMadt(maDT);
		dt.setTenDienThoai(tenDT);
		dt.setCauHinh(cauHinh);
		dt.setNamSanXuat(namSX);
		dt.setHinhAnh(hinhAnh);
		EntityManager em = emf.createEntityManager();
		NhaCungCap ncc = em.find(NhaCungCap.class, nhaCC);
		dt.setNhaCungCap(ncc);
		
		DienThoaiDAO dienThoaiDao = new DienThoaiDAOIMPL(em);
		dienThoaiDao.addDienThoai(dt);
		
		request.setAttribute("dienThoai", dt);
		request.getRequestDispatcher("/DanhSachDienThoaiNCCServlet").forward(request, response);
		
	}
	@Override
	public void destroy() {
		if (emf != null) {
			emf.close();
		}
	}

}
