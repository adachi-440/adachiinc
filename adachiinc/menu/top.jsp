<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../menu.jsp" %>

<a href="insert-in.jsp">出品</a>
<form action="Product.action" method="post">
  <input type="text" name="keyword">
  <input type="submit" value="検索">
</form>
<hr>
<table width="500">
  <tr>
    <th>出品名</th>
    <th>金額</th>
    <th>在庫</th>
    <th>出品者</th>
  </tr>
<c:forEach var="product" items="${lineup}">
  <tr>
    <td>${product.name}</td>
    <td>${product.price}円</td>
    <td>${product.quantity}</td>
    <td>${product.seller}</td>
    <td>${product.id}</td>
    <td><form action="CartAdd.action?ID=${product.id}" method="post">
    <select name="counter">
      <c:forEach var="i" begin="1" end="${product.quantity}">
        <option value="${i}">${i}</option>
      </c:forEach>
    </select>
    <button type="submit">カートに追加</button>
  </form>
  </td>
  </tr>
</c:forEach>
</table>
<%@include file="../footer.html" %>
