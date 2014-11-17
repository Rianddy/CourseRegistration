<%-- 
    Document   : RegistrationResult
    Created on : Nov 8, 2014, 6:45:10 PM
    Author     : KevinZhou
--%>
<%@page import="Model.RegClassInfo"%>
<%@page import="webservice.prereqmeet.StudentClass.ClassPrereq"%>
<%@page import="webservice.prereqmeet.StudentClass"%>
<%@page import="webservice.basic.Student"%>
<%@page import="org.netbeans.xml.schema.studentregcheck.ClassList;"%>
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
                    Student student = (Student) request.getAttribute("StudentInformation");
                    ArrayList<RegClassInfo> regClassInfoList = (ArrayList<RegClassInfo>) request.getAttribute("RegClassInfoList");
                    ClassList cl = (ClassList)request.getAttribute("ClassList");
                %>
                <div class="col-sm-6">Student ID:</div>
                <div class="col-sm-6"><%=student.getStuid()%></div>            
            </div>
            <%
                    for(RegClassInfo regClassInfo : regClassInfoList) {
                        StudentClass studentClass = regClassInfo.getStudentClass();                       
            %>
            <div class="form-group row">
                    <div class="col-sm-6">Class ID:</div>
                    <div class="col-sm-6"><%=regClassInfo.getClassID()%></div>
                    <div class="col-sm-6">Class Valid:</div>
                    <%
                        if(regClassInfo.isClassValid()){
                            out.println("<div class='col-sm-6'>"+true+"</div>");
                            out.println("<div class='col-sm-6'>Class Full</div>");
                            out.println("<div class='col-sm-6'>"+regClassInfo.isIsFull()+"</div>");
                            
                            // Whether this class meet the prerequisite classes requirements                           
                            out.println("<div class='col-sm-6'>Prerequisite Classes Meet:</div>");
                            if(!studentClass.isCanTake()){
                                out.println("<div class='col-sm-6' style='background-color:#FF0000'>"+false+"</div>");
                                out.println("<div class='col-sm-6' style='background-color:#FF0000'>Prerequisite Classes:</div>");
                                out.println("<div class='col-sm-6' style='background-color:#FF0000'>");
                                for(ClassPrereq classPrereq:studentClass.getClassPrereq()){
                                    out.println("classPrereq.getClassid()");
                                }
                                out.println("</div>");
                            }else{
                                out.println("<div class='col-sm-6'>"+studentClass.isCanTake()+"</div>"); 
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
