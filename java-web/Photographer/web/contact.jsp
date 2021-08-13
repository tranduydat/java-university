<%-- 
    Document   : contact
    Created on : Jun 27, 2021, 01:24:09 AM
    Author     : DatDuyTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Contact</title>
        <link rel="icon" sizes="194x194" href="resources/img/favicon.png">
    </head>
    <body>
        <%@include file="components/header.jsp"%>
        <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
            <div class="container">
                <div class="row-fluid content-inner">
                    <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                        <div class="wrapper map-page">
                            <div class="heading">
                                <h1 class="page-title">Contact</h1>
                            </div>

                            <div class="content">
                                <div class="section">
                                    <div class="content">

                                        <div class="row-fluid map-page-info">
                                            <div class="span6">
                                                <div class="item">
                                                    <div class="heading">
                                                        <h4 class="item-title map-page-title">PHOTOGRAPHER</h4>
                                                    </div>
                                                    <div class="content">
                                                        <div class="country">
                                                            <p>Address: ${author.address}<br>City: ${author.city}<br>Country: ${author.country}</p>
                                                        </div>

                                                        <div class="row-fluid">
                                                            <div class="span2">
                                                                Tel: 
                                                            </div>    
                                                            <div class="span10">
                                                                ${author.phone}
                                                            </div>    
                                                        </div>
                                                        <div class="row-fluid">
                                                            <div class="span2">
                                                                Email: 
                                                            </div>    
                                                            <div class="span10">
                                                                ${author.email}
                                                            </div>    
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="span6">
                                                <div class="item">
                                                    <div class="heading">
                                                        <h4 class="item-title map-page-title"></h4>
                                                    </div>
                                                    <div class="content">

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="section">
                                    <div class="content">
                                        <div class="map-container">
                                            <iframe
                                                width="600"
                                                height="450"
                                                style="border:0"
                                                loading="lazy"
                                                allowfullscreen
                                                src="https://www.google.com/maps/embed/v1/place?key=AIzaSyDIgX8Aj1m0oTEsbXVsb-H98KNApIVJCks&q=${mapAddress}">
                                            </iframe>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <%@include file="components/sidebar.jsp"%>
                </div>        
            </div>
        </div>
        <script src="https://kit.fontawesome.com/6860e9de9d.js" crossorigin="anonymous"></script>
        <%@include file="components/footer.jsp"%>
    </body>
</html>
