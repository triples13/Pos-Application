<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript"> <%@include file="js/pos.js" %> </script>

<h2 align="center">Hello please Enter the product barcode</h2>
<div id="form">
<form align="center" action="/pos/getorder" method="post">
<input type="text" name="bid"/>
<input type="submit" id="button" value="submit"/>
</form>
</div>

<div id="producttable">
<c:if test="${!empty productlist}">
<table id="product"  align="center">
<tr>
<th>Barcode</th>
<th>ProductName</th>
<th>Price</th>
<th>ADD</th>
</tr>
<tr>
<td>
${productlist.barcode_id}
</td>
<td>
${productlist.product_name}
</td>
<td>
${productlist.price}
</td>
<td>
<!--<c:url value="/addproduct" var="addProductUrl">
   <c:param name="barcodeid" value="${productlist.barcode_id}"/>
 </c:url>
 -->
<a id="submit" href="#"/>Add Cart
</td>

</tr>

</table>
</c:if>
</div>


<div id="cart">
<h2 align="center">Cart List</h2>
<table id="order" align="center">
<tr id="firstrow">
<th>OrderId</th>
<th>ProductName</th>
<th>Quantity</th>
<th>Price</th>
<th>Barcode</th>
</tr>
</table>
</div>

</body>
</html>