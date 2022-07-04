<#import "parts/common.ftlh" as c>

<@c.page>
    <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-current="true" aria-label="Slide 2"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">

                <img src="images/constructor_bg.png">
                <div class="container">
                    <div class="carousel-caption">
                        <p><a class="btn btn-lg btn-warning" href="/constructor">Make you own pizza!</a></p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img src="images/birthday.png">

                <div class="container">
                    <div class="carousel-caption">
                        <p style="background-color:tomato;"><b>WE HAVE BIRTHDAY DISCOUNTS!</b></p>
                    </div>
                </div>
            </div>
        </div>
        <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <div class="album py-5 bg-light">
    <div class="container">
    <#assign piz = ["Margarita", "Three Cheeses", "Villager", "Super Meat", "Diablo", "Seafarer"]>
<#list piz as p>

    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <div class="col">
            <div class="card shadow-sm">
                <img src="images/margarita.png" width="100%" height="100%">

                <div class="card-body">
                    <p class="card-header"><b>
                            Margarita
                        </b>
                    </p>
                    <p class="card-text">Ingredients: tomato sauce, tomatoes, mozzarella      </p>
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                            <a href="/cart/addPizza/${piz[0]}" type="button" class="btn btn-sm btn-outline-secondary">Add to cart</a>

                        </div>
                        <div>
                            100 UAH
                        </div>
                        <small class="text-muted">500 gramms</small>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card shadow-sm">
                <img src="images/three_cheese.png" width="100%" height="100%">

                <div class="card-body">
                    <p class="card-header"><b>
                            Three Cheeses
                        </b>
                    </p>
                    <p class="card-text">Ingredients: white sauce, mozzarella, cheddar, blue cheese</p>
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                            <a href="/cart/addPizza/${piz[1]}" type="button" class="btn btn-sm btn-outline-secondary">Add to cart</a>
                        </div>
                        <div>
                            170 UAH
                        </div>
                        <small class="text-muted">500 gramms</small>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card shadow-sm">
                <img src="images/villager.png" width="100%" height="100%">

                <div class="card-body">
                    <p class="card-header"><b>
                            Villager
                        </b>
                    </p>
                    <p class="card-text">Ingredients: tomato sauce, mozzarella, mushrooms, chicken, tomatoes</p>
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                            <a href="/cart/addPizza/${piz[2]}" type="button" class="btn btn-sm btn-outline-secondary">Add to cart</a>
                        </div>
                        <div>
                            125 UAH
                        </div>
                        <small class="text-muted">500 gramms</small>
                    </div>
                </div>
            </div>
        </div>

        <div class="col">
            <div class="card shadow-sm">
                <img src="images/supermeat.png" width="100%" height="100%">

                <div class="card-body">
                    <p class="card-header"><b>
                            Super Meat
                        </b>
                    </p>
                    <p class="card-text">Ingredients: tomato sauce, mozzarella, chicken, beef, sausage</p>
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                            <a href="/cart/addPizza/${piz[3]}" type="button" class="btn btn-sm btn-outline-secondary">Add to cart</a>
                        </div>
                        <div>
                            150 UAH
                        </div>
                        <small class="text-muted">500 gramms</small>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card shadow-sm">
                <img src="images/diablo.png" width="100%" height="100%">

                <div class="card-body">
                    <p class="card-header"><b>
                            Diablo
                        </b>
                    </p>
                    <p class="card-text">Ingredients: tomato sauce, mozarella, chorizo, onions      </p>
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                            <a href="/cart/addPizza/${piz[4]}" type="button" class="btn btn-sm btn-outline-secondary">Add to cart</a>
                        </div>
                        <div>
                            125 UAH
                        </div>
                        <small class="text-muted">500 gramms</small>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card shadow-sm">
                <img src="images/seafarer.png" width="100%" height="100%">

                <div class="card-body">
                    <p class="card-header"><b>
                            Seafarer
                        </b>
                    </p>
                    <p class="card-text">Ingredients: white sauce, mozzarella, shrimps, olives    </p>
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                            <a href="/cart/addPizza/${piz[5]}" type="button" class="btn btn-sm btn-outline-secondary">Add to cart</a>
                        </div>
                        <div>
                            200 UAH
                        </div>
                        <small class="text-muted">500 gramms</small>
                    </div>
                </div>
            </div>
        </div>
        <#break>
        </#list>
</@c.page>