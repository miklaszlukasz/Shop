<#ftl encoding='UTF-8'>

<html>
<head>

</head>
<body>
<#include "header.ftl" />
<#include "menu.ftl" />
<div class="container">
    add new product
    <fieldset>
        <legend>Create new product</legend>
        <form name="user" action="createNewProduct.ftl" method="post">
            Name: <input type="text" name="name" /> <br/>
            Price: <input type="text" name="price" /> <br/>
            Description <input type="text" name="description" /> <br/>
            <input type="submit" value="Create new product" />
        </form>
    </fieldset>
</div>
<#include "footer.ftl" />
</body>