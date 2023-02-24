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
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${FnolList}" var="fnol">
                            <tr>
                                <td>
                                        ${fnol.getFnolId()}
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
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>

        </main>
    </body>
</html>
