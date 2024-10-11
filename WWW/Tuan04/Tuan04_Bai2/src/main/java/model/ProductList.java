package model;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
	private static final List<Product> ds = new ArrayList<Product>();
	static {
		initData();
	}
	public static List<Product> queryProducts(){
		System.out.println(ds);
		return ds;
	}
	private static void initData() {
		Product sp = new Product();
		sp.setId("PR001"); 
		sp.setDescription(""); 
		sp.setModel("Nokia Lumia");
		sp.setQuantity(10);
		sp.setPrice(90000); 
		sp.setImgURL("/images/dt1.jpg");
		ds.add(sp);
		
		sp = new Product();
		sp.setId("PR002"); 
		sp.setDescription(""); 
		sp.setModel("Iphone 6");
		sp.setQuantity(10);
		sp.setPrice(90000); 
		sp.setImgURL("/images/dt2.jpg");
		ds.add(sp);
		
		sp = new Product();
		sp.setId("PR003"); 
		sp.setDescription(""); 
		sp.setModel("Samsung");
		sp.setQuantity(10);
		sp.setPrice(90000); 
		sp.setImgURL("/images/dt3.jpg");
		ds.add(sp);
		
		sp = new Product();
		sp.setId("PR004"); 
		sp.setDescription(""); 
		sp.setModel("Dell");
		sp.setQuantity(10);
		sp.setPrice(90000); 
		sp.setImgURL("/images/dt4.jpg");
		ds.add(sp);
		
		sp = new Product();
		sp.setId("PR005"); 
		sp.setDescription(""); 
		sp.setModel("Hp");
		sp.setQuantity(10);
		sp.setPrice(90000); 
		sp.setImgURL("/images/dt5.jpg");
		ds.add(sp);
	}
}
