<%-- 
    Document   : index
    Created on : Nov 1, 2014, 6:33:36 PM
    Author     : KevinZhou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Class registration</h1>
        <form name="register" action="StudentRegistration" method="post">
            <input type="text" class="form-control" id="studentID" name="studentID" placeholder="studentID">
            <input type="text" class="form-control" id="class1" name="class1" placeholder="class1">
            <input type="text" class="form-control" id="class2" name="class2" placeholder="class2">
            <input type="text" class="form-control" id="class3" name="class3" placeholder="class3">
            <button class="btn btn-default pull-right" type="submit">Register</button>
        </form>
    </body>
</html>
