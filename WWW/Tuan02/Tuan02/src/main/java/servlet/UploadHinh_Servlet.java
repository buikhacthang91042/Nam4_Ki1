package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;

/**
 * Servlet implementation class UploadHinh_Servlet
 */
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024,
		maxFileSize =  1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 10
)
public class UploadHinh_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadHinh_Servlet() {
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		InputStream layDuongDanHinhAnh = null;
		Part filePart = request.getPart("photo");
		String fileUpLoadName = "";
		if(filePart != null && filePart.getSubmittedFileName() != null
			&& !filePart.getSubmittedFileName().isEmpty())
		{
			fileUpLoadName = filePart.getSubmittedFileName();
			layDuongDanHinhAnh = filePart.getInputStream();
			}
		
			
		
		Connection con = null;
		String message = null;
		String filePath = "C:/Nam4_HK1/WWW/UploadFIle/" + fileUpLoadName + ".jpg";
		try {
		con= DBConnection.getConnection();
		String sql = "Insert into contacts (first_name, last_name, photo) values (?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);
		if(layDuongDanHinhAnh != null) {
			stmt.setBlob(3, layDuongDanHinhAnh);
		}
		int row = stmt.executeUpdate();
		if (row > 0) {
			System.out.println("File uploaded and saved into database");
			}
		String sqlSelect = "SELECT photo FROM contacts WHERE first_name=? AND last_name=?";
				stmt = con.prepareStatement(sqlSelect);
				stmt.setString(1, firstName);
				stmt.setString(2, lastName);
				ResultSet result = stmt.executeQuery();
				if (result.next()) {
				Blob blob = result.getBlob("photo");
				InputStream inputStream = blob.getBinaryStream();
				OutputStream outputStream = new FileOutputStream(filePath);
				int bytesRead = -1;
				byte[] buffer = new byte[1024];
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
				}
				inputStream.close();
				outputStream.close();}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (con != null) {
				try {
				con.close();
				} catch (SQLException ex) {
				ex.printStackTrace();
				}
			}
			response.getWriter().println("Upload thành công");
		}}}
		


