<%-- 
    Document   : search
    Created on : Jul 01, 2021, 12:25:37 PM
    Author     : DatDuyTran
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/css/style.css" />
        <title>Search</title>
    </head>
    <body>
        <div>
            <div class="font-sans text-blue">
                <%@include file="components/header.jsp" %>
                <!--Content-->
                <div class="wrap-content">
                    <div class="flex container">
                        <div class="left pa-5">
                            <c:if test="${result.size() == 0}">
                                <p class="not-found">Not found</p>
                            </c:if>
                            <c:forEach var="post" items="${result}">
                                <div>
                                    <p class="text-4 text-blue mt-0 font-bold">
                                        <a class="text-blue" href="post?id=${post.getId()}">${post.getTitle()}</a>
                                    </p>
                                    <img
                                        alt="title"
                                        src="${post.getThumbnail()}"
                                        class="image-article"/>
                                    <p>${post.getExcerpt()}</p>
                                    <p class="text-gray mt-5 items-end text-right">${post.getAuthor().getName()} | <fmt:formatDate pattern="MMM dd yyy - h:mm a" value="${post.getModifiedDate()}"/></p>
                                </div>
                            </c:forEach>
                        </div>
                        <%@include file="components/sidebar.jsp" %>
                    </div>
                </div>
                <!--Footer-->
                <footer class="footer">
                </footer>
            </div>
        </div>
    </body>
</html>

