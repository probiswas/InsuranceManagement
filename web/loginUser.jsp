
<!doctype html>
<html lang="en">
    <head>
        <title>Sign in - User</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">
        
    </head>

    <body class="text-center">
        

        <main class="form-signin w-100 m-auto">
            <form action="LoginUser" method="post">
                <img class="mb-4" src="https://s3-us-west-2.amazonaws.com/cbi-image-service-prd/modified/d6b0e553-40e5-4fcc-aae9-46e950dcb071.png" alt="" width="300" height="100">
                <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

                <div class="form-floating">
                    <input name="emailAddress" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating">
                    <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
                <p class="mt-5 mb-3 text-muted">&copy; 2017?2022</p>
            </form>
        </main>



    </body>
</html>
