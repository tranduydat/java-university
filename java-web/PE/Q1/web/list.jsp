<%-- 
    Document   : list
    Created on : Mar 27, 2021, 7:46:20 AM
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
        <table border="1">
            <thead>
                <tr>
                    <th>Post ID</th>
                    <th>Content</th>
                    <th>Posted Date</th>
                    <th>is Enable</th>
                    <th>Posted By</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="i">
                    <tr>
                        <td>${i.getId()}</td>
                        <td>${i.getContent()}</td>
                        <td><fmt:formatDate value="${i.getDate()}" pattern="M/d/yyyy"/></td>
                        <td><input type="checkbox" value="${i.getId()}" <c:if test="${i.isIsEnabled()}">checked</c:if>></td>
                        <td>${i.getCreated_by()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
