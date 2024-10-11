<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        .form-container {
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            width: 400px;
            margin: auto;
        }
        .form-container h2 {
            text-align: center;
        }
        .form-row {
            display: flex;
            width:400px;
            margin: 5px 0px;
             
        }
        .form-container input, .form-container select {
            width: 368px;
            padding: 10px;
            margin: 5px 10px;
        }
        .form-container input.half-width, .form-container select.half-width {
            width: 220px; /* Adjust width to fit three inputs in a row */
        }
        .gender-row {
            display: flex;
            align-items: center; /* Aligns radio buttons with labels */
            margin: 10px 0;
        }
        .form-container button {
            width: 400px;
            padding: 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        
        .gender {
        	display: flex;
        	flex-direction: row;
        	width:345px;
        	margin: 5px, 2px ;
        	
        }
        input[type = "radio"]{
        	width:20px;
        	
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>User Registration Form</h2>
    <form action="Servlet_DangKiTK" method="post">
        <div class="form-row">
            <input type="text" class="half-width" name="firstName" placeholder="First Name" required>
            <input type="text" class="half-width" name="lastName" placeholder="Last Name" required>
        </div>
        <input type="email" placeholder="Your Email" name="email" required>
        <input type="email" placeholder="Re-enter Email" required>
        <input type="password" placeholder="New Password" name="password" required>
        <br>
        <label for="birthday" style="margin-top:20px" >Birthday</label>
        <div class="form-row">
            <select class="half-width" name="month">
                <option>Month</option>
                <option value="1">January</option>
        <option value="2">February</option>
        <option value="3">March</option>
       
            </select>
            <select class="half-width" name="day">
                <option>Day</option>
                  <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="3">4</option>
        <option value="3">5</option>
        <option value="3">6</option>
        <option value="3">7</option>
        <option value="3">8</option>
            </select>
            <select class="half-width" name="year">
                <option>Year</option>
              <option value="1990">2000</option>
        <option value="1991">2001</option>
        <option value="1992">2003</option>
            </select>
        </div>

        <div class="gender">
        <input type="radio" name="gender" value="female"> 
            <label>
                Female              
            </label>
            <input type="radio" name="gender" value="male"> 
            <label>
            Male               
            </label>
        </div>

        <button type="submit">Sign Up</button>
    </form>
</div>

</body>
</html>
