<#ftl encoding='UTF-8'>

<html>
<head>

</head>
<body>
<#include "header.ftl" />
<#include "menu.ftl" />
<div class="container">
    <table class="products" style="border-collapse: collapse">
        <tr>
            <th>Id</th>
            <th>Date</th>
            <th>Price</th>
        </tr>
    <#list model["orders"] as order>
        <tr>
            <td>${order.id}</td>
            <td>${order.orderDate}</td>
            <td>${order.price}</td>
        </tr>
    </#list>

    </table>
</div>
<#include "footer.ftl" />
</body>
</html>