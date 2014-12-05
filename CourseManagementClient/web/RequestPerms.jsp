<%-- 
    Document   : RequestPerms
    Created on : Dec 3, 2014, 11:22:08 AM
    Author     : KevinZhou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Course Registration</title>
        <meta name="generator" content="Bootply" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="CSS/bootstrap.min.css" rel="stylesheet">
        <!--[if lt IE 9]>
                <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <link href="CSS/styles.css" rel="stylesheet">
        <script src="js/jquery.min.js"></script>
        <title>Servlet RequestPermission</title>
    </head>
    <body>
        <nav class="navbar navbar-default" role="navigation"><%@include file="Header.jsp"%></nav>
        <div id="wrap">
            <%
                String status = (String) request.getAttribute("stas");
                if (status != null) {
            %>
            <div class="form-group">
                <div class="col-sm-6"><%=status%></div>
            </div>
            <% } %>
        </div>
    </body>
</html>
