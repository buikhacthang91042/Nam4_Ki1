package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CartBean;

import java.io.IOException;

/**
 * Servlet implementation class CartController
 */
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
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
		String strAction = request.getParameter("action");
		if(strAction != null && !strAction.equals("")) {
			if(strAction.equals("add")){
				addToCart(request);
			}else if(strAction.equals("Update")) {
				updateCart(request);
			}else if(strAction.equals("Delete")) {
				deleteCart(request);
			}
		}
		response.sendRedirect("/Tuan03_Bai04/ShoppingCart.jsp");
	}
	protected void deleteCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String strItemIndex = request.getParameter("itemIndex");
		CartBean cartBean = null;
		Object objCartBean = session.getAttribute("cart");
		if(objCartBean != null) {
			cartBean = (CartBean) objCartBean;
		}else {
			cartBean = new CartBean();
			
		}
		cartBean.deleteCartItem(strItemIndex);
	}
	protected void updateCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String strQuantity = request.getParameter("quantity");
		String strItemIndex = request.getParameter("itemIndex");
		CartBean cartBean = null;
		Object objCartBean = session.getAttribute("cart");
		if(objCartBean != null) {
			cartBean = (CartBean) objCartBean;
		}else {
			cartBean = new CartBean();
			
		}
		cartBean.upateCartItem(strItemIndex, strQuantity);
	}
	protected void addToCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String strModelNo = request.getParameter("modelNo");
		String strDescription = request.getParameter("description");
		String strPrice = request.getParameter("price");
		String strQuantity = request.getParameter("quantity");
		CartBean cartBean = null;
		Object objCartBean = session.getAttribute("cart");
		if(objCartBean != null) {
			cartBean = (CartBean) objCartBean;
		}else {
			cartBean = new CartBean();
			session.setAttribute("cart", cartBean);
		}
		cartBean.addCartItem(strModelNo, strDescription, strPrice, strQuantity);
	}

}
