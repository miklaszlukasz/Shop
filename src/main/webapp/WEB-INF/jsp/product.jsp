<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${name}</title>
</head>
<body>

<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />
Id: ${id} <br/>
Name: ${name} <br/>
Price: ${price} <br/>
Description: ${description}
<jsp:include page="footer.jsp" />

</body>
</html>