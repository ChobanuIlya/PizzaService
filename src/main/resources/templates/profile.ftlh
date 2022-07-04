<#import "parts/lg_common.ftlh" as c>

<@c.page>
<div class="container rounded bg-white mt-5 mb-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile Settings</h4>
                </div>
    <form action="/updateCustomer" method="post">
                <div class="row mt-3">
                    <div class="col-md-12"><label class="labels">First Name</label><input type="text" required name="first_name" class="form-control" placeholder="enter new first name" value="${customer.firstName}"></div>
                    <div class="col-md-12"><label class="labels">Last Name</label><input type="text" required name="last_name" class="form-control" placeholder="enter new last name" value="${customer.lastName}"></div>
                    <div class="col-md-12"><label class="labels">Password</label><input type="text" name="password" class="form-control" placeholder="enter new password" value=""></div>
                    <div class="col-md-12"><label class="labels">Address</label><input type="text" required name="address" class="form-control" placeholder="enter new address" value="${customer.address}"></div>
                    <div class="col-md-12"><label class="labels">Email</label><input type="email" required name="email" class="form-control" placeholder="enter email" value="${customer.email}"></div>
                </div>
    <div class="mt-4 mb-4 d-flex justify-content-between">
        <a href="/main" class="btn btn-warning profile-button" type="button">Main Menu</a>
        <a href="/logout" class="btn btn-warning profile-button" type="button">Logout</a>
        <a href="" class="btn btn-warning profile-button" type="button">Order History</a>
        <button class="btn btn-warning profile-button" type="submit">Save Profile</button>
    </div>
    </form>
</div>
</@c.page>
