<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DMV Information</title>
    </head>
    <body>
<!--        <h5>User ID: ${DmvInofrmation.getUserId()}</h5>
        <h5>Name: ${DmvInofrmation.getFirstName()} ${DmvInofrmation.getLastName()}</h5>
        <h5>Vehicle Number: ${DmvInofrmation.getVehicleNumber()}</h5>
        <h5>Policy Number: ${DmvInofrmation.getPolicyNumber()}</h5>
        <h5>Accident Report: ${DmvInofrmation.getAccidentReport()}</h5>-->

        <p><strong>User ID:</strong> ${DmvInofrmation.getUserId()}</p>
        <p><strong>Name:</strong> ${DmvInofrmation.getFirstName()} ${DmvInofrmation.getLastName()}</p>
        <p><strong>Vehicle Number:</strong> ${DmvInofrmation.getVehicleNumber()}</p>
        <p><strong>Policy Number:</strong> ${DmvInofrmation.getPolicyNumber()}</p>
        <p><strong>Accident Report:</strong> ${DmvInofrmation.getAccidentReport()}</p>
        <button id="dmvbutton" class="btn btn-primary">DMV Info</button>
        <button id="ibutton" class="btn btn-warning">Insurance</button><br><br>
        <a style="text-decoration: none;" href='ChangeStatusUnderwriter?fnolId=6&status=2'>
            <button class="btn btn-success">Accept</button>
        </a>
        <a style="text-decoration: none;" href='ChangeStatusUnderwriter?fnolId=6&status=0'>
            <button class="btn btn-danger">Reject</button>
        </a>
    </body>
</html>
