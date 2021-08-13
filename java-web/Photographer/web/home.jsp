<%-- 
    Document   : home
    Created on : Jun 27, 2021, 01:24:44 AM
    Author     : DatDuyTran
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/6860e9de9d.js" crossorigin="anonymous"></script>
        <title>Home</title>
        <link rel="icon" sizes="194x194" href="resources/img/favicon.png">
    </head>
    <body>
        <%@include file="components/header.jsp"%>
        <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
            <div class="container">
                <div class="row-fluid content-inner">
                    <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                        <div class="wrapper ">
                            <div class="content">
                                <div class="row-fluid layout5-row  margins-topbottom padding-all ">
                                    <div class="sections-wrapper">
                                        <div class="span12 ">
                                            <div class="outer-margin-on first last">
                                                <div class="section article margins-on">
                                                    <div class="content">
                                                        <div class="img-simple span12 ">
                                                            <div class="image">
                                                                <a data-ss="imagemodal" data-href="${featuredImage.imageURL}" rel="group" title="Lorem ipsum dolor sit amet" has-arrows="False"><img src="${featuredImage.imageURL}"></a>
                                                            </div>
                                                            <div class="image-caption">
                                                                <p class="sub2">${featuredImage.caption}</p>
                                                            </div> 
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid layout5-row  margins-topbottom padding-all ">
                                    <div class="sections-wrapper">
                                        <div class="span12 ">
                                            <div class="outer-margin-on first last">
                                                <div class="section margins-on">
                                                    <div class="content">
                                                        <ul class="thumbnails column-article-section">
                                                            <c:forEach var="gallery" items="${listOfGalleries}" >
                                                                <li class="span4">
                                                                    <div class="img-simple span12 ">
                                                                        <div class="image">
                                                                            <a data-ss="imagemodal" data-href="${gallery.thumbnail}" rel="group" has-arrows="False"><img src="${gallery.thumbnail}"></a>
                                                                        </div>
                                                                    </div>
                                                                    <h4>
                                                                        <a href="gallery?id=${gallery.id}">View ${gallery.title}</a>
                                                                    </h4>
                                                                    <p>${gallery.description}</p>
                                                                </li>
                                                            </c:forEach>
                                                        </ul>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row-fluid layout5-row  margins-topbottom padding-all ">
                                    <div class="sections-wrapper">
                                        <div class="span12 ">
                                            <div class="outer-margin-on first last">
                                                <div class="section article margins-on">
                                                    <style>    .wordwrapfix {
                                                            word-wrap:break-word;
                                                        }
                                                    </style>
                                                    <div class="heading wordwrapfix">
                                                        <h3>About me</h3>
                                                    </div>
                                                    <div class="content">
                                                        <p><span>${author.aboutMe}</span></p>    </div>
                                                </div>
                                            </div>
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
        <%@include file="components/footer.jsp"%>
    </body>
</html>
