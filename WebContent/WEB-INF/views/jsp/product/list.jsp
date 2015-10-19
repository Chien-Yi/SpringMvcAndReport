<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		  <spring:url value="/product/add" var="urlAddProduct" />	
		  <spring:url value="/product/files" var="urlFileProduct" />
		  
          <h2 class="sub-header">Product List 
          <button class="btn btn-success" onclick="location.href='${urlAddProduct}'">Add product</button>
          <button class="btn btn-info" onclick="location.href='${urlFileProduct}'">Print PDF</button>
          </h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Name</th>
                  <th>ProductNumber</th>
                  <th>SafetyStockLevel</th>
                  <th>ReorderPoint</th>
                  <th>ListPrice</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
             	<c:forEach var="product" items="${products}">
             		 <tr>
						<td>
							${product.name}
						</td>
						<td>
							${product.productNumber}
						</td>
						<td>
							${product.safetyStockLevel}
						</td>
						<td>
							${product.reorderPoint}
						</td>
						<td>
							${product.listPrice}
						</td>
						<td>
							<spring:url value="/product/${product.productId}" var="productUrl" />
				  			<spring:url value="/product/${product.productId}/delete" var="deleteUrl" /> 
				  			<spring:url value="/product/${product.productId}/update" var="updateUrl" />
				  			
			  			  <button class="btn btn-info" 
                                         onclick="location.href='${productUrl}'">Query</button>
						  <button class="btn btn-primary" 
		                                 onclick="location.href='${updateUrl}'">Update</button>
						  <button class="btn btn-danger" 
		                                 onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
						</td>
					</tr>
             	</c:forEach>
              </tbody>
            </table>
          </div>
        <!-- </div>
      </div>
    </div> -->
    
  <jsp:include page="../fragments/footer.jsp" />  

</body>

</html>