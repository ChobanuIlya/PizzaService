<nav class="navbar bg-light">
    <div class="container-fluid">
        <a href="/main" class="navbar-brand"><b>PizzaService</b></a>
        <div class="btn-group" role="group" aria-label="Basic example">
            <div>
                <a href="${link}" type="button" class="btn btn-warning">
                    <img src="images/profile.png">
                </a>
            </div>
            <button class="btn btn-warning" type="button" data-bs-toggle="offcanvas"
                    data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
                <img src="images/cart.png">
            </button>

            <div class="offcanvas offcanvas-end" tabindex="-1" data-bs-backdrop="static" id="offcanvasExample"
                 aria-labelledby="offcanvasExampleLabel">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="offcanvasExampleLabel">Cart</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">

                        <#list cart as key, value>
                    <form action="/cart/removePizza/${key.pizzaName}&${key.price}" method="post">
                        <div class="card">
                            <div class="row no-gutters">
                                <div class="col-sm-7">
                                    <div class="card-body">
                                        <h5 class="card-title"> ${key.pizzaName} 	&#8372;${key.price}</h5>
                                        <p class="card-text" id="quantity">Quantity: ${value}</p>
                                        <button type="submit" class="btn btn-danger">Remove</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                        </#list>

                    <div>Total price: &#8372;${totalPrice}</div>
                    <a href="/check" class="btn btn-success">Checkout</a>
                </div>
            </div>
        </div>
    </div>
</nav>