<%-- 
    Document   : managequiz
    Created on : Jul 16, 2021, 7:20:58 AM
    Author     : datdu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Quiz</title>
        <link rel="stylesheet" href="assets/css/style.css">
        <style>
            td {
                padding: 0.5rem 0;
            }
        </style>
    </head>
    <body>
        <c:if test="${sessionScope.accountlogged ne null}">
            <c:if test="${sessionScope.accountlogged.roleID ne 1}">
                <c:redirect url = "/404"/>
            </c:if>
        </c:if>
        <section class="main">
            <%@include file="components/header.jsp" %>
            <div class="body">
                <div class="manage-title">
                    Number of questions: <span class="manage-title__number">${numberOfQuestions}</span>
                </div>
                <div class="body-table">
                    <table>
                        <tr>
                            <th style="width: 65%;">Question</th>
                            <th style="width: 20%;">Date Created</th>
                        </tr>
                        <c:forEach items="${listOfQuestions}" var="question">
                            <tr> 
                                <td>${question.content}</td>
                                <td><fmt:formatDate pattern="dd-MMM-yyy" value="${question.createdAt}" /></td>    
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </section>
    </body>
</html>
