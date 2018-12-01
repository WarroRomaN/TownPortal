<#import "perth/common.ftl" as c>
<@c.page>
    <form action="/registration"  method="post" class="form-horizontal">
    <div class="form-group">
        <h1>Sing Up</h1>
    </div>
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" id="username" name="username"
               placeholder="Username">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="text" class="form-control" id="password" name="password"
               placeholder="Password">
    </div>
    <div class="form-group">
        <label for="confirm">Confirm</label>
        <input type="text" class="form-control" id="confirm" name="confirm"
               placeholder="Confirm">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="text" class="form-control" id="email" name="email"
               placeholder="Email">
    </div>
    <div class="form-group">
        <label for="firstName">First name</label>
        <input type="text" class="form-control" id="firstName" name="firstName"
               placeholder="First name">
    </div>
    <div class="form-group">
        <label for="lastName">Last name</label>
        <input type="text" class="form-control" id="lastName" name="lastName"
               placeholder="Last name">
    </div>
    <div class="form-group">
        <label for="birthday">Birthday</label>
        <input type="text" class="form-control" id="birthday" name="birthday"
               placeholder="Birthday">
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-default">Sing Up</button>
    </form>
</@c.page>