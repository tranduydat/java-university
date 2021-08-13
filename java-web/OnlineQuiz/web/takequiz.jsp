<%-- 
    Document   : takequiz
    Created on : Jul 16, 2021, 7:22:10 AM
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
                    <div class="new-test">
                        <form action="take-quiz" method="POST">
                            <label for="numberOfQuestions">Enter number of question:</label> <br>
                            <input type="number" id="numberOfQuestions" name="numberOfQuestions" > <br>
                            ${message}
                            <button>Start</button>
                        </form>
                    </div> 
                </div>
            </div>
        </section>
        <script>
            localStorage.removeItem("minutes");
            localStorage.removeItem("seconds");
        </script>
    </body>
</html>
