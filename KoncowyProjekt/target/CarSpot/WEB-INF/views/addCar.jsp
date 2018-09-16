<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>
<script src="<c:url value="/resources/js/scripts.js"/>"></script>

<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADD NEW CAR</title>
</head>
<%@    include file="header.jsp"%>
<body>
<div class="container">
    
    	<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  
			  	<div class="panel-body">
			    	<form:form  method="post" modelAttribute="car" role="form">
                    <fieldset>
			    	  	<div class="form-group">
						<label for="username" class="col-md-6 control-label">Car Brand</label>
			    		    <form:input class="form-control" path="username" placeholder="brand..."  type="text"/>
			    		</div>
			    		<label for="brand" class="col-md-6 control-label">Car Model</label>
			    		<div class="form-group">
			    		    <form:input class="form-control" path="brand" placeholder="model..."  type="text"/>
			    		</div>
						<label for="model" class="col-md-6 control-label">Where was photo taken?</label>
						<div class="form-group">
							<form:input class="form-control" path="model" placeholder="city.." type="text"/>
						</div>

			    		<label for="city" class="col-md-6 control-label">Link to photo</label>
			    		<div class="form-group">
			    		    <form:input class="form-control" path="city" placeholder="link"  type="text"/>
			    		</div>
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Add new car">
			    	</fieldset>
			      	</form:form>
			    </div>
			</div>
		</div>
	</div>
</div>

</body>
</html>