<#import "parts/ch_common.ftlh" as c>

<@c.page>
<div class="container mt-5 px-5">

    <div class="mb-4">

        <h2>Confirm order and pay</h2>

    </div>

    <div class="row">

        <div class="col-md-8">



            <h6 class="text-uppercase">Payment details</h6>
            <div class="inputbox mt-3"> <input type="text" name="name" class="form-control" required="required"> <span>Name on card</span> </div>


            <div class="row">

                <div class="col-md-6">
                    <div class="inputbox mt-3 mr-2"> <input type="text" name="cardnumber" class="form-control" required="required"> <i class="fa fa-credit-card"></i> <span>Card Number</span>
                    </div>
                </div>

                <div class="col-md-6">

                    <div class="d-flex flex-row">
                        <div class="inputbox mt-3 mr-2"> <input type="text" name="expiry_card" class="form-control" required="required"> <span>Expiry</span> </div>

                        <div class="inputbox mt-3 mr-2"> <input type="password" name="cvv" class="form-control" required="required"> <span>CVV</span> </div>
                    </div>
                </div>
            </div>



            <div class="mt-4 mb-4">
                <h6 class="text-uppercase">Customer Address</h6>
                <div class="row mt-3">
                    <div class="col-md-6">
                        <div class="inputbox mt-3 mr-2"> <input type="text" name="street_address" class="form-control" required="required" placeholder="Street Address"></div>
                    </div>

                    <div class="col-md-6">
                        <div class="inputbox mt-3 mr-2"> <input type="number" min="1" name="apartment_number" class="form-control" placeholder="Apartment number"></div>
                    </div>

                </div>

                <div class="row mt-2">

                    <div class="col-md-6">
                        <div class="inputbox mt-3 mr-2"> <input type="text" name="number" min="1" class="form-control" placeholder="Floor"> </div>
                    </div>
                </div>
            </div>

            <div class="mt-4 mb-4">
                <h6 class="text-uppercase">Customer Details</h6>
                <div class="row mt-3">
                    <div class="col-md-6">
                        <div class="inputbox mt-3 mr-2"> <input type="text" name="first_name" class="form-control" required="required" placeholder="First Name" >
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="inputbox mt-3 mr-2"> <input type="text" name="last_name" class="form-control" required="required" placeholder="Last Name" >
                        </div>
                    </div>

                    <div class="row mt-2">
                        <div class="col-md-6">
                            <div class="inputbox mt-3 mr-2"> <input type="text" name="phone_number" class="form-control" placeholder="Phone Number"> </div>
                        </div>

                        <div class="col-md-6">
                            <div class="inputbox mt-3 mr-2"> <input type="email" name="email" class="form-control" placeholder="Email" > </div>
                        </div>
                    </div>
                </div>
            </div>




            <div class="mt-4 mb-4 d-flex justify-content-between">
                <a href="/main" class="btn btn-success px-3">Main Page</a>
                <a href="${link}" class="btn btn-success px-3">Pay &#8372;${totalPrice}</a>
            </div>
        </div>

        <div class="col-md-4">

            <div class="card p-3 text-black mb-3">

                <span>You have to pay</span>
                <div class="d-flex flex-row align-items-end mb-3">
                    <h1 class="mb-0 black">&#8372;${totalPrice}</h1>
                </div>
                <div>
                    <form action="/redeemCode" method="post">
                    <input type="text" placeholder="redeem code">
                    <button type="submit" class="btn-success">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</@c.page>