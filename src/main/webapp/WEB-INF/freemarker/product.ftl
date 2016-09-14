<#ftl encoding='UTF-8'>

<html>
<head>

</head>
<body>
<#include "header.ftl" />
<#include "menu.ftl" />
<div class="container">
    ${product.id} <br/>
    ${product.name} <br/>
    ${product.price} <br/>
    ${product.description} <br/>
        <form name="product" th:action="product_${product.id}" method="post">
            <input type="" name="name" />
            Amount: <input type="text" id="amount" name="amount" value="1" /><br/>
            <input type="submit" value="Add to cart" />
        </form>
</div>
<#include "footer.ftl" />
</body>
</html>