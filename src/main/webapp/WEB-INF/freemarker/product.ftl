<#ftl encoding='UTF-8'>

<html>
<head>

</head>
<body>
<#include "header.ftl" />
<#include "menu.ftl" />
<div class="container">
    Id: ${product.id} <br/>
    Name: ${product.name} <br/>
    Price: ${product.description} <br/>
    Description: ${product.id} <br/>
        <form name="int" th:action="/product_${product.id}" method="post" >
            Amount: <input name="amount" value="1" /><br/>
            <input type="submit" value="Add to cart" />
        </form>
</div>
<#include "footer.ftl" />
</body>
</html>