<%-- 
    Document   : CheckPermsReq
    Created on : Dec 3, 2014, 3:00:14 PM
    Author     : KevinZhou
--%>
<%@page import="team.soa.cms.msgqueueservice.ClassPrereqOfMessageSerialObj"%>
<%@page import="team.soa.cms.msgqueueservice.StuClassInfoMQSerialObj"%>
<%@page import="java.util.*"%>
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
        <title>Faculty check Permission Request</title>
    </head>
    <body>
        <%
            List<StuClassInfoMQSerialObj> permsMsgList = (List) request.getAttribute("PermsMsgList");
            String permsId = (String) request.getAttribute("permsId");
            if (permsMsgList != null && permsId != null) {
                List<ClassPrereqOfMessageSerialObj> preReqClassList = permsMsgList.get(0).getClassInfo().getPrereqClasses();
        %>
        <h1>Permission Request from <%= permsMsgList.get(0).getStudentInfo().getEmail()%> </h1>
        <div class="form-group row">
            <div class="col-sm-6">Class ID: <%= permsMsgList.get(0).getClassInfo().getClassid()%></div>
        </div>            

        <% if (preReqClassList != null && preReqClassList.size() > 0) {
                out.println("<label>Pre Request Classes:</label>");

                for (int i = 0; i < preReqClassList.size(); i++) {
                    out.println("<div class='form-group row'>");
                    out.println("<div class='col-sm-6'>CourseID</div>");
                    out.println("<div class='col-sm-6'>" + preReqClassList.get(i).getCourseid() + "</div>");
                    out.println("<div class='col-sm-6'>MeetReq?</div>");
                    String background = preReqClassList.get(i).isReqMet() ? "" : "style='background-color:#FF0000'";
                    out.println("<div class='col-sm-6' " + background + ">" + preReqClassList.get(i).isReqMet() + "</div>");
                    out.println("</div>");
                }
            }
        %> 

        <a href='ConfirmPermsSerlvet?status=accept&permsId=<%=permsId%>'>Accept </a>
        <a href='ConfirmPermsSerlvet?status=reject&permsId=<%=permsId%>'>Reject </a>
        <% }%>
    </body>
</html>
