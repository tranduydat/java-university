<%-- 
    Document   : sidebar
    Created on : Jun 30, 2021, 05:27:54 AM
    Author     : DatDuyTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="right" class="span3">
    <div class="sidebar">
        <div class="wrapper share-box">
            <div class="heading">
                <h4>Share this page</h4>
            </div>
            <div class="content">
                <ul>
                    <li>
                        <a id="share-facebook" href="https://www.facebook.com/sharer/sharer.php?u=${pageContext.request.requestURL}">
                            <img src="resources/img/facebook-icon.png" alt="Facebok" style="width: 16px"/>
                            <span>  Share on Facebook</span>
                        </a>
                    </li>
                    <li>
                        <a id="share-twitter" href="https://twitter.com/intent/tweet?text=Share It on Twitter&url=${pageContext.request.requestURL}">
                            <img src="resources/img/twitter-icon.png" alt="Facebok" style="width: 16px"/>
                            <span> Share on Twitter</span>
                        </a>
                    </li>
                    <li>
                        <a id="share-google-plus" href="#">
                            <img src="resources/img/googleplus-icon.png" alt="Facebok" style="width: 16px"/>
                            <span>  Share on Google+</span>
                        </a>
                    </li>    
                </ul>
            </div>
        </div>
    </div>
</div>