<#ftl encoding='UTF-8'>

<html>
<head>

</head>
<body>
<#include "header.ftl" />
<#include "menu.ftl" />
<div class="container">
    Your cart
    <table style="border-collapse: collapse">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Amount</th>
        </tr>
        <#list model['cartItems'] as cartItem>
        <tr>
            <td>${cartItem.product.id}</td>
            <td>${cartItem.product.name}</td>
            <td>${cartItem.product.price}</td>
            <td>${cartItem.amount}</td>
        </tr>
    </#list>
    </table>
    Total price: ${model.totalPrice}

    <form name="cart" action="cart.ftl" method="post">
        <input type="submit" value="Submit order" />
    </form>
</div>
<#include "footer.ftl" />
</body>
</html>