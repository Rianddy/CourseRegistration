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
                session = request.getSession();
                ArrayList<String> clsDropIDList = new ArrayList<String>();                
                StuEnrollList stuEnrollList = (StuEnrollList) request.getAttribute("stuEnrollList");
                if (stuEnrollList != null) { 
                    List<Oneenroll> oneEnrolls = stuEnrollList.getOneenroll();
                    for (int i=0; i< oneEnrolls.size(); i++) { 
                        clsDropIDList.add(oneEnrolls.get(i).getClassid());
                        %>
                        <form class="form-group" action="StudentDropServlet" method="post">
                            <div class="form-group row">
                                <div class="col-lg-6">
                                    <div class="col-sm-1"><INPUT type="checkbox" name="chk<%=i%>"/></div>
                                    <div class="col-sm-3"><labe>Class ID:</labe><%=oneEnrolls.get(i).getClassid()%></div>
                                    <div class="col-sm-3"><label>Course ID:</label><%=oneEnrolls.get(i).getCourseid()%></div>
                                    <div class="col-sm-5"><label>Enroll time:</label><%=oneEnrolls.get(i).getStuenrolltime()%></div>
                                    <button class="btn btn-default pull-left" type="submit">Drop</button>
                                </div>
                            </div>                            
                            <div class="form-group row">
                                <div class="col-lg-6">
                                    <input type="hidden" name="from" value="${pageContext.request.requestURI}">
                                    
                                </div>
                            </div>
                        </form>
                    <% }
            %>
                
            <%  session.setAttribute("clsDropID", clsDropIDList);
                } else { %>
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
