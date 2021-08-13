<%-- 
    Document   : wall
    Created on : Mar 27, 2021, 8:38:23 AM
    Author     : dattran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${listOfPosts}" var="p">
            +${p.getContent()}<br>
            <c:forEach items="${p.getListOfComments()}" var="c">
                -${c.getContent()}<br>
            </c:forEach>
            <form action="" method="post">new comment for ${p.getLower()}:
                <input type="hidden" name="pid" value="${p.getId()}">
                <input type="text" name="content">  <input type="submit" value="Submit">
            </form>
        </c:forEach>
    </body>
</html>
