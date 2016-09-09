<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>

<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />

<c:forEach var="i" begin="1" end="5">
    Element ${i}<br />
</c:forEach>



<jsp:include page="footer.jsp" />

</body>
</html>
