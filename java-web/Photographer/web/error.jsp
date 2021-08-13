<%-- 
    Document   : error
    Created on : Jun 27, 2021, 01:24:19 AM
    Author     : DatDuyTran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Error</title>
        <link rel="icon" sizes="194x194" href="resources/img/favicon.png">
    </head>
    <body>
        <%@include file="components/header.jsp"%>
        <div class="main-body">
            <div class="main-body-content">
                <h1>${errorMessage}</h1>
            </div>
        </div>
        <%@include file="components/footer.jsp"%>
    </body>
</html>
