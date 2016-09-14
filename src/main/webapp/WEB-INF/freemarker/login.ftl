<#ftl encoding='UTF-8'>

<html>
<head>

</head>
<body>
<#include "header.ftl" />
<#include "menu.ftl" />
<div class="container">
    login
    <fieldset>
        <legend>Add User</legend>
        <form name="user" action="/login" method="post">
            Login: <input type="text" name="username" /> <br/>
            Password: <input type="text" name="pasword" /> <br/>
            <input type="submit" value="Login" />
        </form>
    </fieldset>
</div>
<#include "footer.ftl" />
</body>
</html>