<%-- 
    Document   : BrowseClass
    Created on : Dec 1, 2014, 3:52:29 PM
    Author     : zhouyizhou
--%>
<%@page import="java.util.*"%>
<%@page import="org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList"%>
<%@page import="org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList.Oneenroll"%>
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
        <title>Browse Class</title>
    </head>
    <body>
        <nav class="navbar navbar-default" role="navigation"><%@include file="Header.jsp"%></nav>
            <%
                StuEnrollList stuEnrollList = (StuEnrollList) request.getAttribute("stuEnrollList");
                if (stuEnrollList != null) { 
                    List<Oneenroll> oneEnrolls = stuEnrollList.getOneenroll();
                    for (int i=0; i< oneEnrolls.size(); i++) { %>
                        <label><%=oneEnrolls.get(i).getClassid()%></label>
                    <% }
            %>
                
            <% } else { %>
        <form class="form-group" action="StudentEnrollmentServlet">
            <div class="col-sm-6">
                <input type="hidden" name="from" value="${pageContext.request.requestURI}">
                <button class="btn btn-default pull-left" type="submit">Browse</button>
            </div>                        
        </form>
        <% }
        %>
    </body>
</html>
