package servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
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
import dao.PhongBanDAO;
import daoIMPL.NhanVienDAOImpl;
import daoIMPL.PhongBanDAOImpl;
import enitties.NhanVien;
import enitties.PhongBan;

/**
 * Servlet implementation class ThemNhanVienMoiServlet
 */
@WebServlet("/ThemNhanVienMoiServlet")
public class ThemNhanVienMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EntityManagerFactoryUtil emuf;
    private EntityManagerFactory emf;
    private NhanVienDAO nhanvienDAO;
    private PhongBanDAO phongBanDAO;
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.emuf = new EntityManagerFactoryUtil();
		this.emf = Persistence.createEntityManagerFactory("ontap");
		this.nhanvienDAO = new NhanVienDAOImpl(emuf.getEm());
		this.phongBanDAO = new PhongBanDAOImpl(emuf.getEm());
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ThemNhanVienMoiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<PhongBan> listPB =  phongBanDAO.findAll();
		request.setAttribute("listPhongBan", listPB);
		request.getRequestDispatcher("/ThemNhanVienMoi.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maNhanVien = request.getParameter("maNhanVien");
		String tenNhanVien = request.getParameter("tenNhanVien");
		String tuoi = request.getParameter("tuoi");
		String diaChi = request.getParameter("diaChi");
		String sdt = request.getParameter("sdt");
		String phongBan = request.getParameter("phongBan");
		int Tuoi = Integer.parseInt(tuoi);
		NhanVien nv = new NhanVien();
		nv.setMaNhanVien(maNhanVien);
		nv.setTenNhanVien(tenNhanVien);
		nv.setsDT(sdt);
		nv.setDiaChi(diaChi);
		nv.setTuoi(Tuoi);
		EntityManager em = emf.createEntityManager();
		PhongBan pb = em.find(PhongBan.class, phongBan);
		nv.setPhongBan(pb);
		nhanvienDAO.themNhanVienMoi(nv);
		request.getRequestDispatcher("QuanLyNhanVienServlet").forward(request, response);
		
	}

}
