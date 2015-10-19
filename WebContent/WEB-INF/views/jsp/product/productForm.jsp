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

<spring:url value="/product" var="productActionUrl" />

<c:choose>
	<c:when test="${userForm['new']}">
		<h1>Add User</h1>
	</c:when>
	<c:otherwise>
		<h1>Update User</h1>
	</c:otherwise>
</c:choose>
<br />

<form:form class="form-horizontal" method="post" 
                modelAttribute="productForm" action="${productActionUrl}">

		<form:hidden path="productId" />
		
		<spring:bind path="name">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Name</label>
			<div class="col-sm-10">
				<form:input path="name" type="text" class="form-control" 
                                id="name" placeholder="Name" />
				<form:errors path="name" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="productNumber">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">productNumber</label>
			<div class="col-sm-10">
				<form:input path="productNumber" type="text" class="form-control" 
                                id="productNumber" placeholder="productNumber" />
				<form:errors path="productNumber" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="safetyStockLevel">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">safetyStockLevel</label>
			<div class="col-sm-10">
				<form:input path="safetyStockLevel" type="text" class="form-control" 
                                id="safetyStockLevel" placeholder="safetyStockLevel" />
				<form:errors path="safetyStockLevel" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="reorderPoint">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">reorderPoint</label>
			<div class="col-sm-10">
				<form:input path="reorderPoint" type="text" class="form-control" 
                                id="reorderPoint" placeholder="reorderPoint" />
				<form:errors path="reorderPoint" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="standardCost">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">standardCost</label>
			<div class="col-sm-10">
				<form:input path="standardCost" type="text" class="form-control" 
                                id="standardCost" placeholder="standardCost" />
				<form:errors path="standardCost" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="listPrice">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">listPrice</label>
			<div class="col-sm-10">
				<form:input path="listPrice" type="text" class="form-control" 
                                id="listPrice" placeholder="listPrice" />
				<form:errors path="listPrice" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="size">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">size</label>
			<div class="col-sm-10">
				<form:input path="size" type="text" class="form-control" 
                                id="size" placeholder="listPrice" />
				<form:errors path="size" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<div class="form-group">
		  <div class="col-sm-offset-2 col-sm-10">
			<c:choose>
			  <c:when test="${userForm['new']}">
			     <button type="submit" class="btn-lg btn-primary pull-right">Add
                             </button>
			  </c:when>
			  <c:otherwise>
			     <button type="submit" class="btn-lg btn-primary pull-right">Update
                             </button>
			  </c:otherwise>
			</c:choose>
		  </div>
		</div>
		
</form:form>

<jsp:include page="../fragments/footer.jsp" />  

</body>