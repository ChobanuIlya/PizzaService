<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container shadow min-vh-100 py-2">
        <div class="row">
            <div class="col">
                <form action="/constructor/create" method="post">
                    <h2 class="font-weight-light">Pizza Constructor</h2>
                    <p>
                        Name:
                        <input type="text" name="pizza_name" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                    </p>
                    <p>
                        Size: <select class="form-select" name="size" aria-label="Default select example">
                            <option value="25">25cm -25&#8372;</option>
                            <option value="30">30cm</option>
                            <option value="35">35cm +25&#8372;</option>
                        </select>
                    </p>
                    <p>
                        Dough type: <select class="form-select" name="dough_type" aria-label="Default select example">
                            <option value="Thin">Thin</option>
                            <option value="Thick">Thick</option>
                            <option value="Hotdog">Hotdog +25&#8372;</option>
                            <option value="Cheesy">Cheesy +25&#8372;</option>
                        </select>
                    </p>
                    <p>
                        Sauce: <select class="form-select" name="sauce" aria-label="Default select example">
                            <option value="Tomato Sauce">Tomato Sauce</option>
                            <option value="White Sauce">White Sauce</option>
                        </select>
                    </p>
                    <p>
                        Ingredient #1: <select class="form-select" name="ingredient1" aria-label="Default select example">
                            <option value="Cheddar">Cheddar +25&#8372;</option>
                            <option value="Blue Cheese">Blue Cheese +25&#8372;</option>
                            <option value="Chicken">Chicken +25&#8372;</option>
                            <option value="Beef">Beef +25&#8372;</option>
                            <option value="Shrimp">Shrimp +35&#8372;</option>
                            <option value="Sausage">Sausage +25&#8372;</option>
                            <option value="Chorizo">Chorizo +25&#8372;</option>
                            <option value="Mushroom">Mushroom +15&#8372;</option>
                            <option value="Onion">Onion +15&#8372;</option>
                            <option value="Pickles">Pickles +15&#8372;</option>
                            <option value="Olive">Olives +15&#8372;</option>
                            <option value="Tomatoes">Tomatoes +15&#8372;</option>
                        </select>
                    </p>
                    <p>
                        Ingredient #2: <select class="form-select" name="ingredient2" aria-label="Default select example">
                            <option selected>Nothing</option>
                            <option value="Cheddar">Cheddar +25&#8372;</option>
                            <option value="Blue Cheese">Blue Cheese +25&#8372;</option>
                            <option value="Chicken">Chicken +25&#8372;</option>
                            <option value="Beef">Beef +25&#8372;</option>
                            <option value="Shrimp">Shrimp +35&#8372;</option>
                            <option value="Sausage">Sausage +25&#8372;</option>
                            <option value="Chorizo">Chorizo +25&#8372;</option>
                            <option value="Mushroom">Mushroom +15&#8372;</option>
                            <option value="Onion">Onion +15&#8372;</option>
                            <option value="Pickles">Pickles +15&#8372;</option>
                            <option value="Olive">Olives +15&#8372;</option>
                            <option value="Tomatoes">Tomatoes +15&#8372;</option>
                        </select>
                    </p>
                    <p>
                        Ingredient #3: <select class="form-select" name="ingredient3" aria-label="Default select example">
                            <option selected>Nothing</option>
                            <option value="Cheddar">Cheddar +25&#8372;</option>
                            <option value="Blue Cheese">Blue Cheese +25&#8372;</option>
                            <option value="Chicken">Chicken +25&#8372;</option>
                            <option value="Beef">Beef +25&#8372;</option>
                            <option value="Shrimp">Shrimp +35&#8372;</option>
                            <option value="Sausage">Sausage +25&#8372;</option>
                            <option value="Chorizo">Chorizo +25&#8372;</option>
                            <option value="Mushroom">Mushroom +15&#8372;</option>
                            <option value="Onion">Onion +15&#8372;</option>
                            <option value="Pickles">Pickles +15&#8372;</option>
                            <option value="Olive">Olives +15&#8372;</option>
                            <option value="Tomatoes">Tomatoes +15&#8372;</option>
                        </select>
                    </p>
                    <p>
                        Ingredient #4: <select class="form-select" name="ingredient4" aria-label="Default select example">
                            <option selected>Nothing</option>
                            <option value="Cheddar">Cheddar +25&#8372;</option>
                            <option value="Blue Cheese">Blue Cheese +25&#8372;</option>
                            <option value="Chicken">Chicken +25&#8372;</option>
                            <option value="Beef">Beef +25&#8372;</option>
                            <option value="Shrimp">Shrimp +35&#8372;</option>
                            <option value="Sausage">Sausage +25&#8372;</option>
                            <option value="Chorizo">Chorizo +25&#8372;</option>
                            <option value="Mushroom">Mushroom +15&#8372;</option>
                            <option value="Onion">Onion +15&#8372;</option>
                            <option value="Pickles">Pickles +15&#8372;</option>
                            <option value="Olive">Olives +15&#8372;</option>
                            <option value="Tomatoes">Tomatoes +15&#8372;</option>
                        </select>
                    </p>
                    <div class="mt-4 mb-4 d-flex justify-content-between">
                        <a href="/main" class="btn btn-success px-3">Main Page</a>
                        <button type="submit" class="btn btn-success px-3">Add to cart</button>
                    </div>
                </form>
            </div>
        </div>
    </div>


</@c.page>