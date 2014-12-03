<%-- 
    Document   : index
    Created on : Dec 1, 2014, 1:09:27 PM
    Author     : KevinZhou
--%>
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
    </head>
    <body>
        <nav class="navbar navbar-default" role="navigation"><%@include file="Header.jsp"%></nav>
        <div id="wrap">            
            <div class="divider" id="section1"></div>
                <form name="input" action="StudentRegistration" method="post">
                    <div class="container">
                        <!--div class="form-group row">
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="stuID" name="stuID" placeholder="Student ID"> 
                            </div>
                        </div-->
                        <%  List<org.netbeans.xml.schema.classxmlschema.Class> clsRegID = (List) session.getAttribute("clsRegID");                             
                        %>
                        <div class="form-group row addclass">
                            <div class="col-sm-6">
                                <TABLE id="dataTable" border="1">                                    
                                        <%  if (clsRegID != null) {
                                            for (int i=0; i<clsRegID.size(); i++) {
                                        %>
                                        <TR>
                                        <TD><INPUT type="checkbox" name="chk"/></TD>
                                        <TD> <%=i+1%> </TD>
                                        <TD> <INPUT type="text" name="class<%=i%>" placeholder="classID" value="<%=clsRegID.get(i).getClassid()%>" text="<%=clsRegID.get(i).getClassid()%>"/> </TD>
                                        <TD> <INPUT type="text" name="PremssionCode<%=i%>" placeholder="Premission Code"/> </TD>
                                        </TR>
                                        <% } 
                                        } %>                                    
                                </TABLE>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-6">
                                <INPUT type="button" value="Add Row" onclick="addRow('dataTable')" /> 
                                <INPUT type="button" value="Delete Row" onclick="deleteRow('dataTable')" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-6">
                                <button class="btn btn-default pull-left" type="submit">Submit</button>
                            </div>
                        </div>
                    </div>
                </form>
                <form class="form-group" action="StudentEnrollmentServlet" method="post">
                    <div class="container">
                        <div class="form-group row">
                            <div class="col-sm-6">
                                <input type="hidden" name="from" value="${pageContext.request.requestURI}">
                                <button class="btn btn-default pull-left" type="submit">Browse</button>
                            </div>
                        </div>
                    </div>
                </form>
            <script type="text/javascript">
                $(document).ready(function() {  
                           
                });
                function addRow(tableID) {
 
                    var table = document.getElementById(tableID);

                    var rowCount = table.rows.length;
                    var row = table.insertRow(rowCount);

                    var cell1 = row.insertCell(0);
                    var element1 = document.createElement("input");
                    element1.type = "checkbox";
                    element1.name="chkbox[]";
                    cell1.appendChild(element1);

                    var cell2 = row.insertCell(1);
                    cell2.innerHTML = rowCount + 1;

                    var cell3 = row.insertCell(2);
                    var element2 = document.createElement("input");
                    element2.type = "text";
                    element2.name = "class" + rowCount;
                    element2.placeholder = "classID";
                    cell3.appendChild(element2);

                    var cell4 = row.insertCell(3);
                    var element3 = document.createElement("input");
                    element3.type = "text";
                    element3.name = "PremissionCode" + rowCount;
                    element3.placeholder = "Premission Code";
                    cell4.appendChild(element3);
                }

                function deleteRow(tableID) {
                    try {
                    var table = document.getElementById(tableID);
                    var rowCount = table.rows.length;

                    for(var i=0; i<rowCount; i++) {
                        var row = table.rows[i];
                        var chkbox = row.cells[0].childNodes[0];
                        if(null != chkbox && true == chkbox.checked) {
                            table.deleteRow(i);
                            rowCount--;
                            i--;
                        }


                    }
                    }catch(e) {
                        alert(e);
                    }
                }

            </script>
        </div>
    </body>
</html>
