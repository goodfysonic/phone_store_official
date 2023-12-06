<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${sessionScope.loggedAccount.avatar==null}">
                <img src="https://cdn-icons-png.flaticon.com/512/6596/6596121.png" alt="User">
	    </c:when>
            <c:otherwise>
                <img src="${sessionScope.loggedAccount.avatar}" alt="User">
                <p>${sessionScope.loggedAccount.fullName}</p>
            </c:otherwise>    
        </c:choose>
    </body>
</html>
