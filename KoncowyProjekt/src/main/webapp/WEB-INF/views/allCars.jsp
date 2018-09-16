<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>"/>
<title>Best Cars</title>
</head>
<%@    include file="header.jsp"%>

<body class="img">


<div class="container">
	<div class="row">
	<h1 class="text-center" >All cars</h1>
		<div class="table-responsive">
            <table id="main-table" class="table exotic-table">
                <thead>
                    <tr class="text-center">
                        <th scope="col">Rank</th>
					      <th scope="col">Brand</th>
					      <th scope="col">Model</th>
					      <th scope="col">City</th>
						<th scope="col">Photo</th>
                        <th scope="col">Delete</th>
                        <th scope="col">Like</th>
                    </tr>
                </thead>
                <tbody class="text-center">
                <c:forEach items="${cars}" var="car" varStatus="count">
                    <tr>
                         <td>${count.index+1}</td>
				      <td>${car.username}</td>
				      <td>${car.brand}</td>
				      <td>${car.model}</td>
						<td> <img src="${car.city}"></td>
                        <td>    <span class="glyphicon glyphicon-trash"></span>&nbsp; Delete</td>
                        <td>        <a href="<c:url value="/mainPage"/>"> <span class="glyphicon glyphicon-thumbs-up"></span>&nbsp; Cars u liked</a></td>

                    </tr>
                    </c:forEach>
                </tbody>
            </table>
		</div>
	</div>
</div>

<script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover({title: "Payment Modes",html: true, placement: "left"});
});
</script>



</body>
</html>