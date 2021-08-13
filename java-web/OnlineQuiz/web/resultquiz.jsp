<%-- 
    Document   : resultquiz
    Created on : Jul 16, 2021, 7:21:48 AM
    Author     : datdu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take Quiz</title>
        <link rel="stylesheet" href="assets/css/style.css">
    </head>
    <body>
        <section class="main">
            <%@include file="components/header.jsp" %>
            <div class="body">
                <div class="takequiz-title">
                    <c:if test="${sessionScope.accountlogged ne null}">
                        Welcome: <span class="takequiz-title__name">${sessionScope.accountlogged.username}</span>
                    </c:if>
                    <c:if test="${score >= 0.5}">
                        Your score <span class="takequiz-title__name">${score*100/10} (${score*1000/10}%) - Passed</span> 
                    </c:if>
                    <c:if test="${score < 0.5}">
                        Your score <span class="takequiz-title__name">${score*100/10} (${score*1000/10}%) - Not Passed</span> 
                    </c:if>
                </div>
                <div class="body-test">
                    <form action="take-quiz">
                        Take another test <button type="submit">Start</button>
                    </form> 
                </div>
            </div>
        </section>
    </body>
</html>