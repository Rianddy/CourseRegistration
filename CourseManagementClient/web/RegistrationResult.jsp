<%-- 
    Document   : RegistrationResult
    Created on : Nov 8, 2014, 6:45:10 PM
    Author     : KevinZhou
--%>
<%@page import="org.netbeans.xml.schema.studentregcheck.ClassPrereq"%>
<%@page import="org.netbeans.xml.schema.studentregcheck.ClassInfo"%>
<%@page import="org.netbeans.xml.schema.studentregcheck.ClassList"%>
<%@page import="org.netbeans.xml.schema.studentregcheck.StuRegCheckInfo"%>

<%@page import="java.util.*"  %>

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
    </head>
    <body>
        <h1>Registration Result</h1>
        <div class="container">
            <div class="form-group row">
                <%
                    StuRegCheckInfo stuRegCheckInfo = (StuRegCheckInfo) request.getAttribute("StuRegCheckInfo");
                %>
                <div class="col-sm-6">Student ID:</div>
                <div class="col-sm-6"><%=stuRegCheckInfo.getStudentInfo().getStudentid()%></div>            
            </div>
                <%
                    ClassList clazzInfo =  stuRegCheckInfo.getClazzInfo();
                    for(ClassInfo classInfo : clazzInfo.getClazz()) {
                        
                %>
            <div class="form-group row">
                    <div class="col-sm-6">Class ID:</div>
                    <div class="col-sm-6"><%=classInfo.getClassid()%></div>
                    <div class="col-sm-6">Class Valid:</div>
                    <%
                        if(classInfo.isClassvalid()){
                            out.println("<div class='col-sm-6'>"+true+"</div>");
                            out.println("<div class='col-sm-6' >Class Full</div>");
                            if((Integer.valueOf(classInfo.getClassstatus())<=0))
                                out.println("<div class='col-sm-6'  style='background-color:#FF0000'>"+true+"</div>");
                            else
                                out.println("<div class='col-sm-6'  style='background-color:#00CC66'>"+false+"</div>");

                            // Whether this class meet the prerequisite classes requirements                           
                            out.println("<div class='col-sm-6'>Prerequisite Classes Meet:</div>");
                            if(!classInfo.isCanTake()){
                                out.println("<div class='col-sm-6' style='background-color:#FF0000'>"+false+"</div>");
                                out.println("<div class='col-sm-6' >Prerequisite Courses:</div>");
                                out.println("<div class='col-sm-6' ");
                                for(ClassPrereq classPrereq:classInfo.getPrereqClasses()){
                                    out.println("<span style='background-color:#FF0000'>"+classPrereq.getCourseid()+"</span>");
                                }
                                out.println("</div>");
                            }else{
                                out.println("<div class='col-sm-6' style='background-color:#00CC66'>"+classInfo.isCanTake()+"</div>"); 
                            }
                        }else{
                            out.println("<div class='col-sm-6' style='background-color:#FF0000 '>"+false+"</div>");
                        } 
                    %>
            </div>
            <%
                    }
            %>
        </div>
    </body>
</html>
