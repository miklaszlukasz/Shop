<#ftl encoding='UTF-8'>

<html>
<head>

</head>
<body>
<#include "header.ftl" />
<#include "menu.ftl" />
<div class="container">
    <table class="products">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
        <#list model["products"] as product>
            <tr>
                <td><a href="/product_${product.id}">${product.id}</a></td>
                <td>${product.name}</td>
                <td>${product.price}</td>
            </tr>
        </#list>

    </table>
</div>
<#include "footer.ftl" />
</body>
</html>