<%-- 
    Document   : Header
    Created on : Nov 30, 2014, 3:05:49 PM
    Author     : KevinZhou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="generator" content="Bootply" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="CSS/bootstrap.min.css" rel="stylesheet">
        <!--[if lt IE 9]>
                <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <link href="CSS/styles.css" rel="stylesheet">
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.session.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="navbar-header navbar-right">    
                <%  String studentId = (String) session.getAttribute("stuID");
                        if (studentId == null || studentId.equals("")) { %>
                <form class="navbar-form navbar-right" action="StudentLoginServlet">
                    <div class="form-group">
                        <input type="text" id="stuID" class="form-control" placeholder="Student ID" name="stuID">
                        <input type="hidden" name="from" value="${pageContext.request.requestURI}">
                    </div>
                    <button type="submit" class="btn btn-default">Login</button>
                </form>      
                <% } else {%>
                <form class="navbar-form navbar-right" action="StudentLoginServlet">
                    <div class="form-group">
                        <label class="glyphicon glyphicon-user"> Hello, <b><%=studentId%></b></label>
                        <input type="hidden" name="from" value="${pageContext.request.requestURI}">
                        <button type="submit" class="btn btn-default small">Log Out</button>
                    </div>
                </form>
                <% }%>
            </div>
        </div>
        <script type="text/javascript">
            function clearSession() {
                var stuID = $.session.get("stuID");
                if (stuID != null) {
                    $.session.remove("stuID");
                }
            }
        </script>
    </body>
</html>
