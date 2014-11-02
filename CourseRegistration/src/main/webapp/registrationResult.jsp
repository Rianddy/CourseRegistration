<%-- 
    Document   : registrationResult
    Created on : Nov 1, 2014, 6:55:50 PM
    Author     : KevinZhou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <h1>Registration result</h1>
        <%
            if (request.getAttribute("studentRegistration") != null) {
                StudentRegistration studentRegistration = request.getAttribute("studentRegistration");   
                classCollection = request.getAttribute("classCollection");
            }
            for(oneRegistrationSuccess: oneRegistrationSuccesses) {
                if( Arrays.asList(classCollection).contains(oneRegistrationSuccess.classid) ) { 
                    out.print("<label>");
                    out.print(oneRegistrationSuccess.coursename);
                    out.print("</label>");%> 
                    <label>succeed</label>
                <% }                    
            }
        %>
    </body>
</html>
