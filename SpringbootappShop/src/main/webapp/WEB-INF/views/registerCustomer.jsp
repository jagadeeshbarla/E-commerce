<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
     <style>
    	h3 {
            color: #4CAF50;
            font-size: 24px;
            margin-bottom: 20px;
        }
        a.home-link {
            position: absolute;
            top: 20px;
            right: 20px;
            color: #4CAF50;
            text-decoration: none;
            font-size: 18px;
            background-color: white;
            padding: 10px 20px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        a.home-link:hover {
            background-color: #45a049;
            transform: scale(1.05);
            color: white;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 12px 24px;
            font-size: 18px;
            cursor: pointer;
            border-radius: 8px;
            width: 50%;
            transition: background-color 0.3s ease;
            margin-top: 20px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
        
        table {
            width: 50%;
            margin-bottom: 20px;
            border-spacing: 10px 15px;
        }
        th, td {
            text-align: left;
            padding: 10px 15px;
            font-size: 16px;
        }
        th {
            background-color: #4CAF50;
            color: #fff;
            font-weight: bold;
            text-align: left;
        }
        td {
            background-color: #f9f9f9;
            border-radius: 5px;
        }
        form:input {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            border-radius: 8px;
            border: 1px solid #ccc;
            margin-top: 8px;
        }
        .error {
            color: red;
            font-size: 12px;
            margin-top: 5px;
        }
        
    </style>
</head>
<body>
    <div class ="Center">
    	<nav>
    		<h3>WELCOME TO CUSTOMER REGISTRATION Page</h3>
    		<a class="home-link" href="${pageContext.request.contextPath}/home/homepage">home</a>
    	</nav>
    	<form:form action="registerCustomer" modelAttribute="customerBean">
    	<div class="table-container">
    	<table>
    		<tr>
    			<th align="left">Enter your Name</th>
    			<td><form:input path="customerName" size="28"/>
    			<form:errors path="customerName" cssClass="error"></form:errors></td>
    		</tr>
    		
    		<tr>
    			<th align="left">Enter your Password</th>
    			<td><form:input path="customerPassword" size="28"/>
    			<form:errors path="customerPassword" cssClass="error"></form:errors></td>
    		</tr>
    		<tr>
    			<th align="left">Enter your Email</th>
    			<td><form:input path="customerEmail" size="28"/>
    			<form:errors path="customerEmail" cssClass="error"></form:errors></td>
    		</tr>
 
    		<tr>
    			<th align="left">Enter your initial Money</th>
    			<td><form:input path="balance" size="28"/>
    			<form:errors path="balance" cssClass="error"></form:errors></td>
    		</tr>
    	</table>
    	</div>
    	<input type="submit" value="Submit customer"/>
    	</form:form>
    </div>
</body>
</html>