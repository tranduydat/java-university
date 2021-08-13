<%-- 
    Document   : doquiz
    Created on : Jul 16, 2021, 7:20:03 AM
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
                </div>
                <div class="body-test">
                    <div class="time-remaining">
                        Time remaining <span class="time-remaining__red" id="time">
                            <span id="minutes"></span> : <span id="seconds"></span>
                        </span>
                    </div>

                    <form action="" method="POST" id="quiz-form">
                        <input type="hidden" name="pageAfter" id="pageAfter" value="${pageAfter}">
                        <input type="hidden" name="numberOfQuestions" id="numberOfQuestions" value="${numberOfQuestions}">
                        <input type="hidden" name="numberCorrect" value="${numberCorrect}">
                        <div class="question">
                            ${question.content}
                        </div>
                        <div class="answers">
                            <input type="checkbox" name="op1" value="1"> ${question.option1} <br>
                            <input type="checkbox" name="op2" value="1"> ${question.option2} <br>
                            <input type="checkbox" name="op3" value="1"> ${question.option3} <br>
                            <input type="checkbox" name="op4" value="1"> ${question.option4} <br>
                        </div>
                        <button class="body-test__button" type="submit">Next</button>
                    </form>
                </div>
            </div>
        </section>
        <script src="assets/js/form.js"></script>
        <script src="assets/js/countdown.js"></script>
    </body>
</html>
