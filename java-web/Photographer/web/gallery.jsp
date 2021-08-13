<%-- 
    Document   : gallery
    Created on : Jun 27, 2021, 01:24:29 AM
    Author     : DatDuyTran
--%>

<%@page import="model.ImageList"%>
<%@page import="model.Image"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/slide.css" rel="stylesheet" type="text/css"/>
        <title>Gallery Detail</title>
        <link rel="icon" sizes="194x194" href="resources/img/favicon.png">
    </head>
    <body>
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <%@include file="components/header.jsp"%>

            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper photo-album photo-album-exhibition">
                                <div class="heading">
                                    <h1 class="page-title">${gallery.title}</h1>
                                </div>

                                <div class="content"> <!-- Slideshow -->
                                    <div class="section">
                                        <div class="content">
                                            <div class="slideshow-container">
                                                <c:set var="numberOfImages" scope="page" value="${imageList.images.size()}"/>
                                                <c:forEach items="${imageList.images}" var="image" varStatus="loopStatus">
                                                    <div class="mySlides fade">
                                                        <img src="${image.imageURL}" alt="${image.caption}" style="width: 100%">
                                                    </div>
                                                </c:forEach>
                                                <button class="btn-change-state" onclick="changeState()"><i id="#changeStateBtn" value="pause" class="fas fa-play"></i></button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="section"> 
                                        <div class="content">
                                            <c:set var="beginIndex" value="0" scope="page"/>
                                            <c:forEach begin="1" end="${numberOfImageLines}" varStatus="loopStatus">
                                                <ul class="thumbnails" data-ss="">
                                                    <c:forEach items="${imageList.getImages()}" var="image" begin="${beginIndex}" end="${beginIndex + 3}" varStatus="loopImageStatus">
                                                        <li class="span3">
                                                            <div>
                                                                <div class="thumbnail">&nbsp;
                                                                    <a rel="nofollow" id="${loopImageStatus.index}">
                                                                        <img id="${loopImageStatus.index}" src="${image.imageURL}" alt="${image.caption}" onclick="galleryImageOnClick(this.id)">
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </li>
                                                        <c:set var="beginIndex" value="${beginIndex + 1}" scope="page"/>
                                                    </c:forEach>
                                                </ul>
                                            </c:forEach>

                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <%@include file="components/sidebar.jsp"%>
                    </div>        
                </div>
            </div>
        </div>
        <script>
            var slideIndex = 1;
            displaySlide(slideIndex, false);
            var slides;
            var isPause = true;

            function nextSlide(n) {
                displaySlide(slideIndex += n);
            }

            function displaySlide(n) {
                var i;
                slides = document.getElementsByClassName("mySlides");

                if (!isPause) {
                    for (i = 0; i < slides.length; i++) {
                        slides[i].style.display = "none";
                    }

                    slideIndex++;

                    if (slideIndex > slides.length) {
                        slideIndex = 1;
                    }

                    slides[slideIndex - 1].style.display = "block";
                    setTimeout(displaySlide, 2000);
                } else {
                    if (slideIndex > slides.length) {
                        slideIndex = 1;
                    }
                    if (n < 0) {
                        slideIndex = slides.length;
                    }
                    for (i = 0; i < slides.length; i++) {
                        slides[i].style.display = "none";
                    }
                    slides[slideIndex - 1].style.display = "block";
                }
            }

            function galleryImageOnClick(id) {
                for (i = 0; i < slides.length; i++) {
                    slides[i].style.display = "none";
                }
                slides[id].style.display = "block";
            }

            function changeState() {
                if (isPause) {
                    document.getElementById("#changeStateBtn").className = "fas fa-pause";
                    isPause = false;
                    displaySlide(slideIndex);
                } else {
                    document.getElementById("#changeStateBtn").className = "fas fa-play";
                    isPause = true;
                }
            }
        </script>
        <%@include file="components/footer.jsp"%>
    </div>
</body>
</html>
