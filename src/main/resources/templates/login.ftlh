<#import "parts/lg_common.ftlh" as c>

<@c.page>
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
    <body class="text-center">

    <main class="form-signin w-100 m-auto">
        <img class="mb-4" src="images/pizza_lg.png" alt="" width="100%" height="100%">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
        <form action="/j_spring_security_check" method="post">
            <div class="form-floating">
                <input type="text" name="login" class="form-control" id="floatingInput"
                       placeholder="0685681841">
                <label for="floatingInput">Phone number</label>
            </div>
            <div class="form-floating">
                <input type="password" name="password" class="form-control" id="floatingPassword"
                       placeholder="Password">
                <label for="floatingPassword">Password</label>
            </div>
            <div class="btn-group-vertical">
                <button style="background-color: goldenrod; border-color: darkred" class="w-100 btn btn-lg btn-primary"
                        type="submit">Sign in</button>
                <a href="/registration" style="background-color: goldenrod; border-color: darkred" class="w-100 btn btn-lg btn-primary"
                   type="submit">Register
                </a>
            </div>
        </form>
    </main>
    </body>
</@c.page>
