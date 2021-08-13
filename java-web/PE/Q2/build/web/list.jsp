<%-- 
    Document   : list
    Created on : Mar 27, 2021, 8:14:44 AM
    Author     : dattran
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>accountid: ${accid}</p>
        <table border="1">
            <tr>
                <th>id</th>
                <th>content</th>
                <th>date</th>
                <th>created_by</th>
            </tr>
        
        <tbody>
            <c:forEach items="${requestScope.listPosts}" var="p">
                <tr>
                    <td>${p.getId()}</td>
                    <td>${p.getContent()}</td>
                    <td><fmt:formatDate value="${p.getDate()}" pattern="M/d/yyyy"/></td>
        <td>${p.getCreated_by()}</td>
    </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
