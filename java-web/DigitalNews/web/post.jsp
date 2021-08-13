<%-- 
    Document   : post
    Created on : Jul 1, 2021, 2:48:10 PM
    Author     : DatDuyTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Digital News</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="resources/css/style.css" />
    </head>
    <body>
        <div class="wrap-all">
            <div class="font-sans text-blue">
                <%@include file="components/header.jsp" %>
                <!--Content-->
                <div class="wrap-content">
                    <div class="container flex">
                        <div class="left pa-5">
                            <p class="text-4 text-blue mt-0 font-bold">${currentPost.getTitle()}</p>
                            <img alt="title" src="${currentPost.getThumbnail()}" class="image-article"/>
                            <p>${fn:replace(currentPost.getContent(), '\\n', '<br/>')}</p>
                            <p class="text-gray mt-5 items-end text-right clock">
                                By ${currentPost.getAuthor().getName()} | <fmt:formatDate pattern="MMM dd yyy - h:mm a" value="${currentPost.getModifiedDate()}"/>
                </p>
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