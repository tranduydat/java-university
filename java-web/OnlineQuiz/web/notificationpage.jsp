<%-- 
    Document   : notificationpage
    Created on : Jul 16, 2021, 7:21:19 AM
    Author     : datdu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Quiz</title>
        <link rel="stylesheet" href="assets/css/style.css">
    </head>
    <body>
        <section class="main">
            <%@include file="components/header.jsp" %>
            <div class="body">
                <div class="body-title">
                    ${page} PAGE: ${message}
                </div>
            </div>
        </section>
    </body>
</html>