<#import "parts/lg_common.ftlh" as c>

<@c.page>
    <!-- Custom styles for this template -->
    <link href="css/signup.css" rel="stylesheet">
    </head>
    <body class="text-center">

    <main class="form-signin w-100 m-auto">
        <form action="/registration" method="post">
            <img class="mb-4" src="images/pizza_lg.png" alt="" width="100%" height="100%">
            <h1 class="h3 mb-3 fw-normal">Registration</h1>

            <div class="form-floating">
                <input required name="first_name" class="form-control" placeholder="John">
                <label>First name</label>
            </div>
            <div class="form-floating">
                <input  name="last_name" class="form-control" placeholder="Johnson">
                <label>Last name</label>
            </div>
            <div class="form-floating">
                <input required type="tel"   name="phone_number" class="form-control" placeholder="0685681841">
                <label>Phone number</label>
            </div>
            <div class="form-floating">
                <input required type="password" minlength="8" maxlength="32" name="password" class="form-control" placeholder="Password">
                <label>Password</label>
            </div>
            <div class="form-floating">
                <input name="address" class="form-control" placeholder="Green str.">
                <label>Address</label>
            </div>
            <div class="form-floating">
                <input type="email" name="email" class="form-control" placeholder="Example@mail.com">
                <label>Email</label>
            </div>
            <div class="form-floating">
                <input type="date" name="bdate" class="form-control" >
                <label>Birthday</label>
            </div>
            <button style="background-color: goldenrod; border-color: darkred" class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>

        </form>
        <p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
    </main>
</@c.page>