<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="../fragments/header.jsp" />

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" 
                                aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>Product Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">productId</label>
		<div class="col-sm-10">${product.productId}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Name</label>
		<div class="col-sm-10">${product.name}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">safetyStockLevel</label>
		<div class="col-sm-10">${product.safetyStockLevel}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">reorderPoint</label>
		<div class="col-sm-10">${product.reorderPoint}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">standardCost</label>
		<div class="col-sm-10">${product.standardCost}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">listPrice</label>
		<div class="col-sm-10">${product.listPrice}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">size</label>
		<div class="col-sm-10">${product.size}</div>
	</div>

<jsp:include page="../fragments/footer.jsp" />  

</body>

</html>