<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${name}</h5>
            <p class="card-text">
            <div>
                Ingredients:
                <#list ingredients as ingredient>
                    ${ingredient}
                </#list>
            </div>
            <div>
                Weight: ${weight}
            </div>
            <div>
                Size: ${size}
            </div>
            <div>
                Price: ${price}
            </div>

            </p>

            <a href="/constructor/addCustomerPizza" type="button" class="btn btn-success">Add to cart</a>
        </div>
    </div>
</@c.page>