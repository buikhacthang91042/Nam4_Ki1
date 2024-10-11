package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RegistrationForm
 */
import java.io.IOException;

import entities.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RegistrationForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationForm() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String fname = request.getParameter("txtFName");
        String lname = request.getParameter("txtLName");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String email = request.getParameter("txtEmail");
        String mobileNumber = request.getParameter("txtMobileNumber");
        String gender = request.getParameter("gender");
        String address = request.getParameter("txtAddress");
        String city = request.getParameter("txtCity");
        String pinCode = request.getParameter("txtPinCode");
        String state = request.getParameter("txtState");
        String country = request.getParameter("txtCountry");
        String[] hobbies = request.getParameterValues("chkHobbies");
        String course = request.getParameter("txtCourse");

        Student sv = new Student();
        sv.setFirstName(fname);
        sv.setLastName(lname);
        sv.setEmail(email);
        sv.setMobileNumber(mobileNumber);
        sv.setGender(gender);
        sv.setAddress(address);
        sv.setCity(city);
        sv.setPinCode(pinCode);
        sv.setState(state);
        sv.setCountry(country);
        
       
        String birthdate = day + " " + month + " " + year;
        sv.setDateOfBirth(birthdate);
        
        if (hobbies != null) {
            StringBuilder hobbiesList = new StringBuilder();
            for (String hobby : hobbies) {
                hobbiesList.append(hobby).append(", ");
            }
            
            if (hobbiesList.length() > 0) {
                hobbiesList.setLength(hobbiesList.length() - 2);
            }
            sv.setHobbies(hobbiesList.toString());
        }

       
        request.setAttribute("student", sv);
        RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
        rd.forward(request, response);
    }
}
