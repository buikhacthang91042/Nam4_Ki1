<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BuiKhacThang_ 21127151</title>
<style>
	body, footer {
		background-color: #9FD7F9;
		color: white;
		
		
	}
	div {
		display:flex;
		height: max-content;
		margin-top: 10px;
		align-items: center;
	}
	span {
	margin-left: 10px;
}
input[type="text"] {
	margin-left: 20px;
}
select {
margin-left: 20px;
}
textarea {
margin-left: 50px;
}
.bangCap {
margin-top: 50px;
}
table{
	margin-left: 50px;
}
.btn{
	display: flex;
	margin-top: 30px;
	margin-left: 80px
	
}
.btn button{
	margin-left: 10px;
	width: 100px;
	height: 50px;
	
}
</style>
</head>
<body>

<form action="RegistrationForm" name="formDangKy" method="GET">
<div>
    <label for="txtFName">First name:</label>
    <input type="text" id="txtFName" name="txtFName" maxlength="30" required>
	<span>(max 30 character a-z and A-Z)</span>
	<br>
	</div>
	<div>
    <label for="txtLName">Last name:</label>
    <input type="text" id="txtLName" name="txtLName" maxlength="30" required>
	<span>(max 30 character a-z and A-Z)</span>
	<br>
	</div>
	<div>
    <label for="dob">Date of birth:</label>
   <select id="day" name="day" required>
        <option value="">Day:</option>
   
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="3">4</option>
        <option value="3">5</option>
        <option value="3">6</option>
        <option value="3">7</option>
        <option value="3">8</option>
       
    </select>

    <select id="month" name="month" required>
        <option value="">Month:</option>
        
        <option value="1">January</option>
        <option value="2">February</option>
        <option value="3">March</option>
       
    </select>

    <select id="year" name="year" required>
        <option value="">Year:</option>
       
        <option value="1990">2000</option>
        <option value="1991">2001</option>
        <option value="1992">2003</option>
       
    </select>

	<br>
	</div>
	<div>
    <label for="email">Email:</label>
    <input type="text" id="email" name="txtEmail" required>
<br>
</div>
<div>
    <label for="mobile">Mobile number:</label>
    <input type="tel" id="mobile" name="txtMobileNumber" pattern="[0-9]{10}" required>
	<span>(10 digits number)</span>
	<br>
	</div>
	<div>
    <label for="gender">Gender:</label>
    
  <input type="radio" id="male" name="gender" value="male" required>
  <label for="male">Male</label>
	
  <input type="radio" id="female" name="gender" value="female" required>
  <label for="female">Female</label>
	<br>
	</div>
	<div>
	<label for="address">Address:</label>
    <textarea id="address" name="txtAddress" rows="3" required></textarea>
	</div>
    <div>
    <label for="city">City:</label>
    <input type="text" id="city" name="txtCity" maxlength="30" required>
	<span>(max 30 character a-z and A-Z)</span>
	<br>
	</div>
	<div>
    <label for="pinCode">Pin code:</label>
    <input type="text" id="pinCode" name="txtPinCode" pattern="[0-9]{6}" required>
	<span>(6 digits number)</span>
<br>
</div>
<div>
    <label for="state">State:</label>
    <input type="text" id="state" name="txtState" maxlength="30" required>
	<span>(max 30 character a-z and A-Z)</span>
<br>
</div>
<div>
    <label for="country">Country:</label>
    <input type="text" id="country" name="txtCountry" value="India" required>
<br>
</div>
<div>
    <label for="hobbies">Hobbies:</label>
    <input type="checkbox" name="chkHobbies" value="Drawing"> Drawing
    <input type="checkbox" name="chkHobbies" value="Singing"> Singing
    <input type="checkbox" name="chkHobbies" value="Dancing"> Dancing
    <input type="checkbox" name="chkHobbies" value="Sketching"> Sketching
    <input type="checkbox" name="chkHobbies" value="Others"> Others
	<input type="text">
	</div>
	
    <div class = "bangCap">
    <label for="qualification">Qualifications:</label>
  <table>
    <tr>
        <th>SL.No.</th>
        <th>Examination</th>
        <th>Board</th>
        <th>Percentage</th>
        <th>Year of Passing</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Class X</td>
        <td><input type="text" maxlength="10" ></td>
        <td><input type="text" maxlength="6" ></td>
        <td><input type="text" ></td>
    </tr>
    <tr>
        <td>2</td>
        <td>Class XII</td>
        <td><input type="text" maxlength="10" ></td>
        <td><input type="text" maxlength="6" ></td>
        <td><input type="text" ></td>
    </tr>
    <tr>
        <td>3</td>
        <td>Graduation</td>
        <td><input type="text" maxlength="10" ></td>
        <td><input type="text" maxlength="6" ></td>
        <td><input type="text" ></td>
    </tr>
    <tr>
        <td>4</td>
        <td>Masters</td>
        <td><input type="text" maxlength="10" ></td>
        <td><input type="text" maxlength="6" ></td>
        <td><input type="text" ></td>
    </tr>
</table>
 </div>
 	<div>
    <label for="course">Course applies for:</label>
   <label for="BCA">BCA</label>
  <input type="radio" id="BCA" name="txtCourse" value="BCA" >
  
  <label for="B.Corn">B.Corn</label>
  <input type="radio" id="B.Corn" name="txtCourse" value="B.Corn" >
  
<label for="B.Sc">B.Sc</label>
  <input type="radio" id="B.Sc" name="txtCourse" value="B.Sc" >
  <label for="B.A">B.A</label>
  <input type="radio" id="B.A" name="txtCourse" value="B.A" >

	<br>
	</div>
	<div class="btn">
	<button  type="submit">Gửi</button>
    <button  type="reset">Đặt lại</button>
	</div>
	
</form>
</body>

</html>

