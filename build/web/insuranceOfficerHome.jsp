<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

    <body>
        <jsp:include page="menu.jsp"></jsp:include>
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
                                    <td>
                                        <a style="text-decoration: none;" href='ChangeStatusInsuranceOfficer?fnolId=${fnol.getFnolId()}&status=3'>
                                                <button class="btn btn-success">Accept</button>
                                        </a>
                                        <a style="text-decoration: none;" href='ChangeStatusInsuranceOfficer?fnolId=${fnol.getFnolId()}&status=0'>
                                            <button class="btn btn-danger">Reject</button>
                                        </a>
                                    </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>

        </main></body>
</html>
