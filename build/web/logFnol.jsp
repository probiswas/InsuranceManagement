<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FNOL</title>
        <link href="css/signin.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    
    <body class="text-center" style="flex-flow: column;padding-top:0;width: 100%">
        <main class="form-signin w-100 m-auto">

            <form action="FileFnol" method="post">

                <img class="mb-4" src="https://s3-us-west-2.amazonaws.com/cbi-image-service-prd/modified/d6b0e553-40e5-4fcc-aae9-46e950dcb071.png" alt="" width="300" height="100">
                <h1 class="h3 mb-3 fw-normal">First Notice of Loss</h1>
                
                <div class="form-floating">
                    <input type="text" class="form-control" value="${User.emailAddress}" placeholder="Email Address" name="emailAddress" readonly>
                    <label for="floatingInput">Email Address</label>
                </div>

                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="first name" name="policyNumber" required>
                    <label for="floatingInput">Policy Number</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="last name" name="vehicleNumber" required>
                    <label for="floatingInput">Vehicle Number</label>
                </div>
                <div class="form-floating">
                    <textarea type="text" class="form-control" id="floatingInput" placeholder="address" name="description" required></textarea>
                    <label for="floatingInput">Description</label>
                </div>
                
                <button class="w-100 btn btn-lg btn-primary" type="submit">Save</button>

            </form>
        </main>

    </body>

</html>
