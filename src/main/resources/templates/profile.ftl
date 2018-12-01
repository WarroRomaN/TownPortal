<#import "perth/common.ftl" as c>
<#assign  security=JspTaglibs["http://www.springframework.org/security/tags"] />
<@c.page>
    <@security.authorize access="isAuthenticated()">
        logged in as <@security.authentication property="principal.username" />
    </@security.authorize>
    <@security.authorize access="! isAuthenticated()">
        Not logged in
    </@security.authorize>
</@c.page>