<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shopapp.SpringbootappShop.beans.CustomerBean" %>
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        th {
            background-color: #4CAF50;
            color: white;
            padding: 12px;
            text-align: left;
        }
        td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }
    	button {
        	color: white;
        	border: none;
        	padding: 10px 20px;
        	cursor: pointer;
        	font-size: 16px;
        	transition: all 0.3s ease; /* Smooth transition effect */
        	border-radius: 8px;
    	}
		button.approve {
        	background-color: green;
    	}
		button.decline {
        	background-color: red;
    	}
		button.approve:hover {
        	background-color: darkgreen; /* Dark green when hovered */
        	opacity: 0.8; /* Slight opacity change */
    	}
		button.decline:hover {
        	background-color: darkred; /* Dark red when hovered */
        	opacity: 0.8; /* Slight opacity change */
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
    		<h3>WELCOME TO ALL CUSTOMER PAGE</h3>
    		<a class="home-link" href="${pageContext.request.contextPath}/logout">logout</a>
    		<a class="home-link" style="right: 120px;" href="${pageContext.request.contextPath}/home/homepage">home</a>
    	</nav>
    	
    	<table border="1" class="classCenter">
    		<tr>
    			<th>Customer id</th>
    			<th>Customer Name</th>
    			<th>Customer Password</th>
    			<th>Customer email</th>
    			<th>Customer Balance</th>
    			<th>Authorization</th>    			
    		</tr>
    		<%
    			List<CustomerBean> customerBeanList = (List<CustomerBean>) request.getAttribute("customerList");
    			for(CustomerBean customerBean : customerBeanList){
    		%>
    			<tr>
    				<td><%= customerBean.getCustomerid()%></td>
    				<td><%= customerBean.getCustomerName()%></td>
    				<td><%= customerBean.getCustomerPassword()%></td>
    				<td><%= customerBean.getCustomerEmail()%></td>
    				<td><%= customerBean.getBalance()%></td>
    				<td>
    					<%
    					String removeCustomer = "removeCustomer?customerBeanid=" + Integer.toString(customerBean.getCustomerid()) + 
    					"&customerBeanEmail=" + customerBean.getCustomerEmail()+
    					"&customerBeanName=" + customerBean.getCustomerName();%>

                        <form:form action="<%= removeCustomer %>">
                            <button type="submit" class="decline">Remove Customer</button>
                        </form:form>
    				</td>
    			</tr>
    		<%
    			}
    		%>
    	</table>
    </div>
</body>
</html>