<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<style type="text/css">
    <%@include file="css/style.css" %>
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript"> <%@include file="js/confirm.js" %> </script>
<h2 align="center">My Cart</h2>
<table id="confirmorders" align="center">
<tr>
<th>OrderId</th>
<th>ProductName</th>
<th>Quantity</th>
<th>Price</th>
<th>Barcode</th>
<th>Modifyorder</th>
</tr>
<c:forEach items="${cartorders}" var="cart">
<tr id="qty ${cart.barcodeid}" class="orders" >
<td>${cart.oid}</td>
<td>${cart.pname}</td>
<td>

<div class="sp-quantity">
    <div class="sp-minus fff"> <a class="ddd"  id="${cart.barcodeid}" href="#">-</a>
    </div>
    <div class="sp-input">
        <input type="text" class="quntity-input" value="${cart.qty}" />
    </div>
    <div class="sp-plus fff"> <a class="ddd" id="${cart.barcodeid}" href="#">+</a>
    </div>
</div>



</td>
<td id="qty${cart.barcodeid}">${cart.price}</td>
<td>${cart.barcodeid}</td>
<td><a id="edit" href="edit">EDIT</a>/<a id="delete" href="delete">Delete</a><td>	
</tr>
</c:forEach>
<tr class="total">
<td>
</td>
<td>
</td>
<td>
Total
</td>
<td>
</td>
</tr>
<tr>
<td>
<input type="submit" id="checkout" value="confirm checkout"/>
</td>
<td>
<input type="submit" id="addProduct" value="Add product"/>
</td>
</tr>
</table>

</body>
</html>