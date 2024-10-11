package servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
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
import daoIMPL.DienThoaiDAOIMPL;
import entities.DienThoai;

/**
 * Servlet implementation class QuanLyFormServlet
 */
@WebServlet("/QuanLyFormServlet")
public class QuanLyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EntityManager em;
    private DienThoaiDAO dienThoaiDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.em = new EntityManagerFactoryUtil().getEnManager();
		this.dienThoaiDao = new DienThoaiDAOIMPL(em);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<DienThoai> list = dienThoaiDao.findAll();
		request.setAttribute("dienThoaiList", list);
		request.getRequestDispatcher("/QuanLyForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maDT = request.getParameter("maDT");
		if(maDT != null) {
			int maDienThoai = Integer.parseInt(maDT);
			dienThoaiDao.deleteDienThoai(maDienThoai);
		}
		response.sendRedirect("QuanLyFormServlet");
	}

}
