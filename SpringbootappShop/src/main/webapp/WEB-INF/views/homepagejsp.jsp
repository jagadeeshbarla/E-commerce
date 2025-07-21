<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        a {
            display: block;
            margin: 10px 0;
            padding: 12px;
            text-decoration: none;
            color: white;
            background-color: #4CAF50;
            border-radius: 8px;
            font-size: 18px;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        a:hover {
            background-color: #45a049;
            transform: scale(1.05);
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
        
    </style>
</head>
<body>
    <div class ="Center">
    	<nav>
    		<h3>WELCOME TO INVENTORY PAGE</h3>
    		<a class="home-link" href="${pageContext.request.contextPath}/logout">logout</a>
    		<a class="home-link" style="right: 120px;" href="${pageContext.request.contextPath}/home/homepage">home</a>
    	</nav>
    	
    	<br>
    	<a href="${pageContext.request.contextPath}/home/GotoCustomer">CUSTOMER</a>
    	<a href="${pageContext.request.contextPath}/home/GotoManager">MANAGER</a>
    	<a href="${pageContext.request.contextPath}/home/GotoAdmin">ADMIN</a>
    	<a href="${pageContext.request.contextPath}/home/loadRegisterCustomer">NEW CUSTOMER</a>
    	<a href="${pageContext.request.contextPath}/home/loadRegisterManagerPending">NEW MANAGER</a>
    	
    </div>
</body>
</html>
