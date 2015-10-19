<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<spring:url value="/resources/bootstrap-3.3.5/js/bootstrap.js" var="bootstrapJs" />
</head>
<body>


		</div>
      </div>
    </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${bootstrapJs}"></script>
<script type="text/javascript">
	function post(path, params, method) {
		method = method || "post"; 
	
		var form = document.createElement("form");
		form.setAttribute("method", method);
		form.setAttribute("action", path);
	
		for ( var key in params) {
			if (params.hasOwnProperty(key)) {
				var hiddenField = document.createElement("input");
				hiddenField.setAttribute("type", "hidden");
				hiddenField.setAttribute("name", key);
				hiddenField.setAttribute("value", params[key]);
	
				form.appendChild(hiddenField);
			}
		}
	
		document.body.appendChild(form);
		form.submit();
	}

</script>

</body>

</html>