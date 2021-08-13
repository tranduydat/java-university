<%-- 
    Document   : header
    Created on : Jun 30, 2021, 05:27:30 AM
    Author     : DatDuyTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container-fluid header-wrapper " id="header"> <!-- this is the Header Wrapper -->
    <div class="container">
        <div class="navbar navbar-compact">
            <div class="navbar-inner">
                <div class="container">
                    <!-- .btn-navbar is used as the toggle for collapsed navbar content -->
                    <a rel="nofollow" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse" title="Toggle menu">
                        <span class="menu-name">Menu</span>
                        <span class="menu-bars">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </span>
                    </a>

                    <!-- Everything you want hidden at 940px or less, place within here -->
                    <div class="nav-collapse collapse">
                        <ul class="nav" id="topMenu" data-submenu="horizontal">
                            <li class="${isHome ? 'active' : ''}" style="">
                                <a rel="nofollow" href="home">My front page</a>
                            </li>
                            <c:forEach var="gallery" items="${listOfGalleries}">
                                <li class="${galleryID == gallery.id ? 'active' : ''}">
                                    <a rel="nofollow" href="gallery?id=${gallery.id}">${gallery.title}</a>
                                </li>
                            </c:forEach>
                            <li class="${isContact ? 'active' : ''}" style="">
                                <a rel="nofollow" href="contact">Contact</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- this is the Menu content -->
        <div class="title-wrapper">
            <div class="title-wrapper-inner">
                <a rel="nofollow" class="logo " href="/home">
                    <i class="fas fa-camera-retro"></i>
                </a>
                <div class="title ">
                    PHOTOGRAPHER
                </div>
                <div class="subtitle">
                    Welcome to this website
                </div>
            </div>
        </div>  <!-- these are the titles -->
    </div>
</div>
<!--
<div class="pre-header">
    <div class="pre-header-content">
        <ul>
            <li>
                <a href="home">My front page</a>
            </li>
<c:forEach var="gallery" items="${listOfGalleries}">
    <li>
        <a href="gallery?id=${gallery.id}">
    <c:choose>
        <c:when test="${gallery.id == id}"><strong>${gallery.name}</strong></c:when>
        <c:otherwise>${gallery.title}</c:otherwise>
    </c:choose>
</a>
</li>
</c:forEach>   
<li>
    <a href="Contact">Contact</a>
</li>
</ul>
</div>
</div>
<header class="header"> 
<div class="header-content">
<a><img src="resources/img/logo-icon.png" /></a>
<div class="app-title">
<div class="app-name">
    <a href="home">PHOTOGRAPHER</a>
</div>
<div class="app-welcome">
    Welcome to this website.
</div>
</div>
</div>
</header>-->