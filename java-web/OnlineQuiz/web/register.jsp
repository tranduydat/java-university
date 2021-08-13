<%-- 
    Document   : register
    Created on : Jul 16, 2021, 7:21:34 AM
    Author     : datdu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="assets/css/style.css">
    </head>
    <body>
        <c:if test="${sessionScope.accountlogged ne null}">
            <c:redirect url = "/" />
        </c:if>
        <section class="main">
            <%@include file="components/header.jsp" %>
            <div class="body">
                <div class="body-title">
                    Registration Form
                </div>
                <div class="body-form">
                    <form action="register" method="POST">
                        <div class="form__row">
                            <label class="form__label" for="name"> Username: </label>
                            <input class="form__input" type="text" id="name" name="username" required pattern=".*\S+.*" maxlength="20">
                        </div>
                        <div class="form__row">
                            <label class="form__label" for="pass"> Password: </label>
                            <input class="form__input" type="password" id="pass" name="password" required pattern=".*\S+.*" maxlength="20">
                        </div>

                        <div class="form__row">
                            <label class="form__label"> User Type: </label>
                            <select name="role-name">
                                <option value="teacher">Teacher</option>
                                <option value="student">Student</option>
                            </select>
                        </div>

                        <div class="form__row">
                            <label class="form__label" for="email"> Email: </label>
                            <input class="form__input" type="email" id="email" name="email" required pattern=".*\S+.*" maxlength="40">
                        </div>
                        <div class="form__button">
                            <button>Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </body>
</html>
