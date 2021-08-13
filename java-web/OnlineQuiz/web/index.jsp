<%-- 
    Document   : index
    Created on : Jul 16, 2021, 7:20:22 AM
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
                <c:if test="${sessionScope.accountlogged == null}">
                    <div class="body-title">
                        Login Form
                    </div>
                    <div class="body-form">
                        <form action="login" method="POST">
                            <div class="form__row">
                                <label class="form__label" for="name"> Username: </label>
                                <input class="form__input" type="text" id="name" name="username" required pattern=".*\S+.*" maxlength="20">
                            </div>
                            <div class="form__row">
                                <label class="form__label" for="password"> Password: </label>
                                <input class="form__input" type="password" id="password" name="password" required pattern=".*\S+.*" maxlength="20">
                            </div>
                            <div class="form__button">
                                <button>Sign in</button>
                                <a href="register">Register</a>
                            </div>
                            <div style="padding-top: 1rem; color: red">
                                ${ms}
                            </div>
                        </form>
                    </div>
                </c:if>
                <c:if test="${sessionScope.accountlogged != null}">
                    <div class="takequiz-title">
                        <div style="padding-top: 1rem">
                            Welcome: <span class="takequiz-title__name">${sessionScope.accountlogged.username}</span>
                        </div>
                        <div style="padding-top: 1rem">
                            Your email: <span class="takequiz-title__name">${sessionScope.accountlogged.email}</span>
                        </div>  
                        <div style="padding-top: 1rem">
                            Your role: 
                            <span class="takequiz-title__name">
                                <c:if test="${sessionScope.accountlogged.roleID == 1}">
                                    Teacher
                                </c:if>
                                <c:if test="${sessionScope.accountlogged.roleID == 2}">
                                    Student
                                </c:if>
                            </span>
                        </div> 
                    </div>
                </c:if>
            </div>
        </section>
    </body>
</html>