<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../menu.jsp" %>

<table width="500">
  <tr>
    <th>出品名</th>
    <th>金額</th>
    <th>購入数</th>
    <th>出品者</th>
  </tr>
<c:forEach var="item" items="${cart}">
  <tr>
    <td>${item.product.name}</td>
    <td>${item.product.price}円</td>
    <td>${item.count}</td>
    <td>${item.product.seller}</td>
    <td>${item.product.id}</td>
    <td><a href="CartRemove.action?ID=${item.product.id}">削除</a>
  </td>
  </tr>
</c:forEach>
</table>
<hr>
${total}円
<%@include file="../footer.html" %>
