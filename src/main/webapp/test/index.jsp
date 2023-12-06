<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>List Product for Home Page</h1>
        <c:forEach items="${listProduct}" var="t">
            <p>${t.id}</p>
            <p>${t.title}</p>
            <p>${t.brandName}</p>
            <p>${t.capacity}</p>
            <p>${t.display}</p>
            <p>${t.color}</p>
            <p>${t.price}</p>
            <p>${t.description}</p>
            <p>${t.sold}</p>
            <p>${t.stock}</p>
            <p>${t.status}</p>
        </c:forEach>
    </body>
</html>
