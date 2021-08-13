<%-- 
    Document   : header
    Created on : Jun 19, 2021, 10:12:05 AM
    Author     : T.DAT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <ul class="menus">
        <li class="menu-item"><a href="home">Home</a></li>
        <c:if test="${sessionScope.accountlogged ne null}">
            <li class="menu-item"><a href="take-quiz">Take Quiz</a></li>
            <c:if test="${sessionScope.accountlogged.roleID == 1}">
                <li class="menu-item"><a href="make-quiz">Make Quiz</a></li>
                <li class="menu-item"><a href="manage-quiz">Manage Quiz</a></li>
            </c:if>
            <li class="menu-item"><a href="logout">Log out</a></li>
        </c:if>
    </ul>
</header>