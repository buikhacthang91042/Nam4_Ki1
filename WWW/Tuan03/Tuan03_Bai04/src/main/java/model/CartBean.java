package model;

import java.util.ArrayList;

public class CartBean {
	private ArrayList<CartItemBean> alCartItems = new ArrayList<CartItemBean>();
	private double dblOrderTotal;
	public int getLineItemCount() {
		return alCartItems.size();
	}
	protected void calculateOrderTotal() {
		double dblTotal = 0;
		for (int i = 0; i < alCartItems.size(); i++) {
			CartItemBean cartItem = (CartItemBean) alCartItems.get(i);
			dblTotal += cartItem.getTotalCost();
		}
		setOrderTotal(dblTotal);
	}
	public void deleteCartItem(String strItemIndex) {
		int iITemIndex = 0;
		try {
			iITemIndex = Integer.parseInt(strItemIndex);
			alCartItems.remove(iITemIndex-1);
			calculateOrderTotal();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void upateCartItem(String srtItemIndex, String strQuantity) {
		double dblTotalCost= 0.0;
		double dblUnitCost= 0.0;
		int iQuantity = 0;
		int iItemIndex= 0;
		CartItemBean cartItem = null;
		try {
			iItemIndex = Integer.parseInt(srtItemIndex);
			iQuantity = Integer.parseInt(strQuantity);
			if(iQuantity > 0) {
				cartItem = alCartItems.get(iItemIndex-1);
				dblUnitCost = cartItem.getUnitCost();
				dblTotalCost = dblUnitCost * iQuantity;
				cartItem.setQuantity(iQuantity);
				cartItem.setTotalCost(dblTotalCost);
				calculateOrderTotal();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
	public CartItemBean getCartItem(int iItemIndex) {
		CartItemBean cartItem = null;
		if(alCartItems.size() > iItemIndex) {
			cartItem =(CartItemBean) alCartItems.get(iItemIndex);
		}
		return cartItem;
	}
	public void addCartItem(String strModelNo, String strDescription, String strUnitCost, String strQuantity) {
		double dblTotalCost = 0.0;
		double dblUnitCost = 0.0;
		int iQuantity = 0;
		CartItemBean cartItem = new CartItemBean();
		try {
			dblUnitCost = Double.parseDouble(strUnitCost);
			iQuantity = Integer.parseInt(strQuantity);
			if(iQuantity>0) {
				dblTotalCost  = dblUnitCost * iQuantity;
				cartItem.setPartNumber(strModelNo);
				cartItem.setModelDescription(strDescription);
				cartItem.setUnitCost(dblUnitCost);
				cartItem.setQuantity(iQuantity);
				cartItem.setTotalCost(dblTotalCost);
				alCartItems.add(cartItem);
				calculateOrderTotal();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void addCartItem(CartItemBean cartItem) {
		alCartItems.add(cartItem);
	}
	public ArrayList<CartItemBean> getCartItems() {
		return alCartItems;
	}
	public void setCartItems(ArrayList<CartItemBean> alCartItems) {
		this.alCartItems = alCartItems;
	}
	public double getOrderTotal() {
		return dblOrderTotal;
	}
	public void setOrderTotal(double dblOrderTotal) {
		this.dblOrderTotal = dblOrderTotal;
	}
	
	
}
