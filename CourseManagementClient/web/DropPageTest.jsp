<%-- 
    Document   : DropPageTest
    Created on : Nov 13, 2014, 10:40:13 PM
    Author     : Edison
    comment    :Just used to test the drop ws. can delete later
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drop page test</title>
    </head>
    <body>
        <form action ="DropClassServlet" method="POST">
            <p>Student ID</p>
            <input type ="text" value = "studentID" name ="studentID">
            <p>Class ID</p>
            <input type ="text" value ="classID_1" name ="classID_1">
            <input type ="text" value ="classID_2" name ="classID_2">
            <input type ="submit" id ="submitButton" name ="submitButton" value ="submit">
        </form>
    </body>
</html>
