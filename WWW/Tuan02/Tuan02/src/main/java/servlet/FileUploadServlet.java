package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Servlet implementation class FileUploadServlet
 */
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024,
		maxFileSize =  1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 10
)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String path = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		path = getServletContext().getInitParameter("FilePath");
		File luuFile = new File(path);
		if(!luuFile.exists()) {
			luuFile.mkdirs();
		}
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
		try {
			for (Part moifile : request.getParts()) {
				if(moifile == null || moifile.getSubmittedFileName() == null || moifile.getSubmittedFileName().isEmpty()) {
					continue;
				}
				String fileName = moifile.getSubmittedFileName();
				InputStream dauVaoCuaFile = moifile.getInputStream();
				Files.copy(dauVaoCuaFile,Paths.get(path + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
				
			}
			response.getWriter().println("Upload thành công");
		} catch (Exception e) {
			// TODO: handle 
			e.printStackTrace();
		}
	}

}
