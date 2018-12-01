<#import "perth/common.ftl" as c>
<@c.page>
    <form action="/login" method="post" class="form-horizontal">
    <div class="form-group">
        <h1>Sing In</h1>
    </div>
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Username">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-default">Sing In</button>
    </form>
</@c.page>