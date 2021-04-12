<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

<p><b>Simple List:</b><p>

    ${cities}

<p><b>Iterated List:</b><p>

<ol>
    <c:forEach var="city" items="${cities}">

        <li>${city}</li>

    </c:forEach>
</ol>

</body>
</html>
