<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../menu.jsp" %>

<c:forEach var="schedule" items="${list}">
${message}
${schedule.year}
</c:forEach>
<%@include file="../footer.html" %>
