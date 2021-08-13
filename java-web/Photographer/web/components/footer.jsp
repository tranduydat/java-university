<%-- 
    Document   : footer
    Created on : Jun 30, 2021, 05:27:11 AM
    Author     : DatDuyTran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  


<div class="container-fluid footer-wrapper" id="footer"> <!-- this is the Footer Wrapper -->
    <div class="container">
        <div class="footer-info">
            <div class="footer-powered-by">
                <a rel="nofollow" href="http://www.simplesite.com/">Created with SimpleSite</a>
            </div>
        </div>
        <div class="footer-page-counter" style="display: block;">
            <div class="button">
                <%
                    String[] array = new String[5];
                    String strNumberOfViews = (String) session.getAttribute("strNumberOfViews");
                    array = strNumberOfViews.split("");
                    for (String str : array) {
                %>
                <span class="footer-page-counter-item"><%= str%></span>
                <%}%>
            </div>
        </div>
        <script src="https://kit.fontawesome.com/6860e9de9d.js" crossorigin="anonymous"></script>
        <div id="css_simplesite_com_fallback" class="hide"></div>
    </div>
</div>