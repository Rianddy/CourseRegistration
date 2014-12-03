<%-- 
    Document   : DropCourseConfirm
    Created on : Dec 1, 2014, 10:09:36 PM
    Author     : Regina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <nav class="navbar navbar-default" role="navigation"><%@include file="Header.jsp"%></nav>
         <div id="wrap">            
            <div class="divider" id="section1"></div>
                <form name="input" action="StudentRegistration" method="post">
                    <div class="container">
                        <div class="form-group row">
                            <div class="col-sm-6">
                                 
                            </div>
                        </div>
                         <%  String classId = (String) session.getAttribute("clsDropID");
                        if (classId == null || classId.equals("")) {%>
                        
                         <div class="form-group row addclass">
                            <div class="col-sm-6">
                                <TABLE id="dataTable" border="1">
                                    <TR>
                                        
                                        <TD></TD>
                                        <TD> </TD>
                                        <TD> </TD>
                                        <TD> </TD>
                                    </TR>
                                </TABLE>
                            </div>
                        </div>
                         <%} else {%>
                        <% }%>
                       
                     <div class="form-group row">
                            <div class="col-sm-6">
                                <button class="btn btn-default pull-left" type="submit">Submit</button>
                            </div>
                        </div>
                    </div>
                </form>
            
        </div>
    </body>
</html>
