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
                            int leftSpace = Integer.valueOf(classInfo.getClassstatus());
                            boolean requestPermission = false;
                            if(leftSpace<=0){
                                out.println("<div class='col-sm-6'  style='background-color:#FF0000'>"+true+"(You are automatically put into waitlist!)</div>");
                                requestPermission = true;
                            }else
                                out.println("<div class='col-sm-6'  style='background-color:#00CC66'>"+false+"</div>");

                            // Whether this class meet the prerequisite classes requirements                           
                            out.println("<div class='col-sm-6'>Prerequisite Classes Meet:</div>");
                            if(!classInfo.isCanTake()){
                                requestPermission = true;
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
                            
                            // Generate requestpermission button
                            if(requestPermission){
                                out.println("<div class='col-sm-6'>Request Permission: </div>");
                                out.println("<div class='col-sm-6'><form action = 'RequestPermsServlet' method = 'POST'>");
                                out.println("<input type='hidden' name='class_id' value = '"+classInfo.getClassid()+"'/>");
                                out.println("<input type='hidden' name='stu_id' value = '"+stuRegCheckInfo.getStudentInfo().getStudentid()+"'/>");
                                out.println("<input type='hidden' name='faculty_email' value = '"+classInfo.getFacultyEmail()+"'/>");
                                out.println("<input type = 'submit' value = 'Request'></button>");
                                out.println("</form></div>");
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
