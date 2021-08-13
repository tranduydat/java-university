<%-- 
    Document   : sidebar
    Created on : May 22, 2021, 12:22:40 PM
    Author     : DatDuyTran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="right py-5 pl-3 pr-5">
    <!--The most recent news-->
    <div>
        <p class="text-4 font-bold mt-0 text-blue">Digital News</p>
        <p>${latestPost.getExcerpt()}</p>
    </div>
    <!--Search news by new title-->
    <div>
        <p class="text-4 font-bold">Search</p>
        <form class="flex" method="get" action="search">
            <input type="text" class="border-dotted search" name="keyword">
            <input type="submit" class="text-blue border-none bg-none" value="Go">
        </form>
    </div>
    <!--Top 5 most recent news-->
    <div>
        <p class="text-4 font-bold">Last Articles</p>
        <ul class="list-reset">
            <c:forEach var="post" items="${listOfLatestPosts}">
                <li class="mt-5"><a href="post?id=${post.getId()}" class="text-blue underline">${post.getTitle()}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>