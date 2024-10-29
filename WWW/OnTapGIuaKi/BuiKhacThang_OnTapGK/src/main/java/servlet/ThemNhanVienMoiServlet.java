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
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	private Validator validator;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.emuf = new EntityManagerFactoryUtil();
		this.emf = Persistence.createEntityManagerFactory("ontap");
		this.nhanvienDAO = new NhanVienDAOImpl(emuf.getEm());
		this.phongBanDAO = new PhongBanDAOImpl(emuf.getEm());
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemNhanVienMoiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<PhongBan> listPB = phongBanDAO.findAll();
		request.setAttribute("listPhongBan", listPB);
		request.getRequestDispatcher("/ThemNhanVienMoi.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maNhanVien = request.getParameter("maNhanVien");
		String tenNhanVien = request.getParameter("tenNhanVien");
		String tuoi = request.getParameter("tuoi");
		String diaChi = request.getParameter("diaChi");
		String sdt = request.getParameter("sdt");
		String phongBan = request.getParameter("phongBan");
		int Tuoi = 0;
		Map<String, String> error = new HashMap<>();
		if (tuoi == null || tuoi.trim().isEmpty()) {
			error.put("tuoi", "Tuổi phải lớn hơn 18");
		} else {
			Tuoi = Integer.parseInt(tuoi);
		}
		NhanVien nv = new NhanVien();
		nv.setMaNhanVien(maNhanVien);
		nv.setTenNhanVien(tenNhanVien);
		nv.setsDT(sdt);
		nv.setDiaChi(diaChi);
		nv.setTuoi(Tuoi);
		EntityManager em = emf.createEntityManager();
		PhongBan pb = em.find(PhongBan.class, phongBan);
		nv.setPhongBan(pb);

		Set<ConstraintViolation<NhanVien>> dsLoi = validator.validate(nv);
		for (ConstraintViolation<NhanVien> constraintViolation : dsLoi) {
			String tenTruong = constraintViolation.getPropertyPath().toString();
			error.put(tenTruong, constraintViolation.getMessage());
		}

		if (!error.isEmpty()) {
			request.setAttribute("error", error);
			List<PhongBan> listPB = phongBanDAO.findAll();
			request.setAttribute("listPhongBan", listPB);
			request.getRequestDispatcher("/ThemNhanVienMoi.jsp").forward(request, response);
			return;
		}

		nhanvienDAO.themNhanVienMoi(nv);
		System.out.println(nv.getMaNhanVien());
		response.sendRedirect(request.getContextPath() + "/QuanLyNhanVienServlet");

	}

}
