package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductList;
import utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.util.List;


import dao.ProductDAO;

import daoImplement.ProductDAOIMPL;

/**
 * Servlet implementation class ProductListController
 */
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManageFactory;
	private ProductDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.entityManageFactory = new EntityManagerFactoryUtil();
		this.dao = new ProductDAOIMPL(this.entityManageFactory.getEnManager());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		System.out.println("doGet called");
		List<Product> list = dao.findAll();
		if(!list.isEmpty())   {

			request.setAttribute("ds", dao.findAll());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ModelList.jsp");
			dispatcher.forward(request, response);
		}else {
		Product sp = new Product();
		sp.setId("PR001"); 
		sp.setDescription(""); 
		sp.setModel("Nokia Lumia");
		sp.setQuantity(10);
		sp.setPrice(90000); 
		sp.setImgURL("/images/dt1.jpg");
		dao.addProduct(sp);
		
		Product sp2 = new Product();
		sp2.setId("PR002"); 
		sp2.setDescription(""); 
		sp2.setModel("Iphone 6");
		sp2.setQuantity(10);
		sp2.setPrice(90000); 
		sp2.setImgURL("/images/dt2.jpg");
		dao.addProduct(sp2);
		
		Product sp3 = new Product();
		sp3.setId("PR003"); 
		sp3.setDescription(""); 
		sp3.setModel("Samsung");
		sp3.setQuantity(10);
		sp3.setPrice(90000); 
		sp3.setImgURL("/images/dt3.jpg");
		dao.addProduct(sp3);
		
		Product sp4 = new Product();
		sp4.setId("PR004"); 
		sp4.setDescription(""); 
		sp4.setModel("Dell");
		sp4.setQuantity(10);
		sp4.setPrice(90000); 
		sp4.setImgURL("/images/dt4.jpg");
		dao.addProduct(sp4);
		
		Product sp5 = new Product();
		sp5.setId("PR005"); 
		sp5.setDescription(""); 
		sp5.setModel("Hp");
		sp5.setQuantity(10);
		sp5.setPrice(90000); 
		sp5.setImgURL("/images/dt5.jpg");
		
		dao.addProduct(sp5);
		
		request.setAttribute("ds", dao.findAll());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ModelList.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
