<%-- 
    Document   : makequiz
    Created on : Jul 16, 2021, 7:20:37 AM
    Author     : datdu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Quiz</title>
        <link rel="stylesheet" href="assets/css/style.css">
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
                <div class="make-quiz">
                    <form action="make-quiz" method="POST" onsubmit="return checkForm(this);">
                        <div class="form__row">
                            <label class="form__label" for="question">Question:</label>
                            <textarea name="content" rows="6" class="form__input"></textarea>
                        </div>
                        <div class="form__row">
                            <label class="form__label" for="op1">Option1:</label>
                            <textarea name="option1" rows="3" class="form__input"></textarea>
                        </div>
                        <div class="form__row">
                            <label class="form__label" for="op2">Option2:</label>
                            <textarea name="option2" rows="3" class="form__input"></textarea>
                        </div>
                        <div class="form__row">
                            <label class="form__label" for="op3">Option3:</label>
                            <textarea name="option3" rows="3" class="form__input"></textarea>
                        </div>
                        <div class="form__row">
                            <label class="form__label" for="op4">Option4:</label>
                            <textarea name="option4" rows="3" class="form__input"></textarea>
                        </div>

                        <div class="form__answer">
                            <label for="form__label">Answer(s):</label>
                            <input type="checkbox" name="op1" value="1"> Option 1
                            <input type="checkbox" name="op2" value="1"> Option 2
                            <input type="checkbox" name="op3" value="1"> Option 3
                            <input type="checkbox" name="op4" value="1"> Option 4
                        </div>
                        <div class="form__button">
                            <input type="submit" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <script src="assets/js/form.js"></script>
    </body>
</html>
