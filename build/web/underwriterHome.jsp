<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script src="jquery-3.6.3.min.js"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <link href="css/product.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <title>Status</title>
    </head>
    <jsp:include page="menu.jsp"></jsp:include>
    <body>
        <main>
                <br>
                <div class="table-body">
                    <table id="table-id" class="table table-bordered table-hover" style="margin-top: -9.5px;">
                        <thead>
                            <tr>
                                <th scope = "col">
                                    FNOL Id
                                </th>
                                <th scope = "col">
                                    User Id
                                </th>
                                <th scope = "col">
                                    First Name
                                </th>
                                <th scope = "col">
                                    Last Name
                                </th>
                                <th scope = "col">
                                    Policy Number
                                </th>
                                <th scope = "col">
                                    Vehicle Number
                                </th>
                                <th scope = "col">
                                    Description
                                </th>
                                <th scope = "col">
                                    Status
                                </th>
                                <th scope = "col">
                                    DMV Info
                                </th>
                                <th scope = "col">
                                    Action
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${FnolList}" var="fnol">
                            <tr>
                                <td>
                                        ${fnol.getFnolId()}
                                    </td>
                                    <td>
                                        ${fnol.getUserId()}
                                    </td>
                                    <td>
                                        ${fnol.getFirstName()}
                                    </td>
                                    <td>
                                        ${fnol.getLastName()}
                                    </td>
                                    <td>
                                        ${fnol.getPolicyNumber()}
                                    </td>
                                    <td>
                                        ${fnol.getVehicleNumber()}
                                    </td>
                                    <td>
                                        ${fnol.getDescription()}
                                    </td>
                                    <td>
                                        ${fnol.getStatus()}
                                    </td>
<!--                                    <td>
                                        <a style="text-decoration: none;" href='ViewDmvInformation?userId=${fnol.getUserId()}'>
                                                <button class="btn btn-primary">View</button>
                                        </a>
                                    </td>-->
                                    <td>
                                        <span style="text-decoration: none;" onclick="show(${fnol.getUserId()})">
                                                <button class="btn btn-primary">View</button>
                                        </span>
                                    </td>
                                    <td>
                                        <a style="text-decoration: none;" href='ChangeStatusUnderwriter?fnolId=${fnol.getFnolId()}&status=2'>
                                                <button class="btn btn-success">Accept</button>
                                        </a>
                                        <a style="text-decoration: none;" href='ChangeStatusUnderwriter?fnolId=${fnol.getFnolId()}&status=0'>
                                            <button class="btn btn-danger">Reject</button>
                                        </a>
                                    </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    
                </table>
                    
            </div>
                <div id="info" style="float:left;"></div>
                    <div id="dmv"style="float:left;"></div>
                    <div id="insurance"style="float:left;"></div>

                
                
        </main>
        <script>
            function show(id)
            {
                $.ajax({
                                        url: 'ViewDmvInformation',
                                        data: {
                                                userId: id
                                        },
                                        success: function (responseText) {
                                                $("#info").addClass("w-25 border");
                                                $("#info").html(responseText);
                                                $("#dmvbutton").click(
                                                        function(){
                                                            $("#dmv").html(text);
                                                            $("#dmv").addClass("w-25 border");
                                                
                                                            }
                                                        );
                                                $("#ibutton").click(
                                                        function(){
                                                            $("#insurance").html(text2);
                                                            $("#insurance").addClass("w-25 border");
                                                
                                                            }
                                                        );
                                        },
                                        failure: function () {
                                                alert("Failed");
                        
                                        }
                                });
            }
            let text = "<p><strong>Driver Name</strong>: Pratik Biswas\n\
        <br><strong>Accident history</strong>: None\n\
        <br><strong>DL Number</strong>: 1234\n\
        <br><strong>Policy Number</strong>: 1234</p>"
        let text2 = "<p><strong>Driver Name</strong>: Pratik Biswas\n\
        <br><strong>Insurance</strong>: Valid\n\
        <br><strong>Policy ammount</strong>: 1000\n\
        <br><strong>Policy Number</strong>: 1234</p>"
        </script>
    </body>
</html>
