<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<spring:url value="/resources/bootstrap-3.3.5/css/bootstrap.css" var="bootstrapCss" />
<spring:url value="/resources/bootstrap-3.3.5/css/bootstrap-theme.css" var="bootstrapThemeCss" />
<spring:url value="/resources/css/dashboard.css" var="dashboard" />
<spring:url value="/product/add" var="urlAddProduct" />	

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${bootstrapThemeCss}" rel="stylesheet" />
<link href="${dashboard}" rel="stylesheet" />


</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">

<div class="container-fluid">
	<div class="navbar-header">
	  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	    <span class="sr-only">Toggle navigation</span>
	    <span class="icon-bar"></span>
	    <span class="icon-bar"></span>
	    <span class="icon-bar"></span>
	  </button>
	  <a class="navbar-brand" href="/SpringMvcAndReport/product/list">Dashboard</a>
	</div>
	<div id="navbar" class="navbar-collapse collapse">
	  <ul class="nav navbar-nav navbar-right">
	    <li><a href="#">Dashboard</a></li>
	    <li><a href="${urlAddProduct}">Add User</a></li>
	    <li><a href="#">Profile</a></li>
	    <li><a href="#">Help</a></li>
	  </ul>
	  <form class="navbar-form navbar-right">
	    <input type="text" class="form-control" placeholder="Search...">
	  </form>
	</div>
</div>

</nav>

<div class="container-fluid">
      <div class="row">
      
      <jsp:include page="menu.jsp" />
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

</body>
</html>