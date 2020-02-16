<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../menu.jsp" %>
<form action=ProductAdd.action method="post">
  <input type="text" name="name" placeholder="出品名">
    <br>
    <br>
  <input type="text" name="price" placeholder="金額">
    <br>
    <br>
  <input type="text" name="quantity" placeholder="個数">
    <br>
    <br>
  <input type="submit" value="確定">
</form>

<%@include file="../footer.html" %>
