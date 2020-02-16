<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../menu.jsp" %>
<%@include file="../header.html" %>

<h2>自分が買ったやつ一覧</h2>

<c:forEach var="item" items="${buyer}">
  <tr>
    <td>出品者：${item.seller}</td>
    <td>金額：${item.price}</td>
    <td>購入数：${item.quantity}</td>
    <td>${item.name}</td>
  </tr>
  <br>
</c:forEach>
<hr>
  <h2>売れたやつ一覧</h2>

<c:forEach var="item" items="${seller}">
  <tr>
    <td>購入者：${item.buyer}　　　</td>
    <td>価格：${item.price}　　　</td>
    <td>購入数：${item.quantity}　　　</td>
    <td>商品名${item.name}　　　</td>
  </tr>
  <br>
</c:forEach>
<hr>
<h2>もらえる金額</h2>
  <c:forEach var="user" items="${userlist}">
    ${user.name}からもらえる額は${paid[user.name]}円です
    <br>
  </c:forEach>
  <hr>
    <h2>払わなくてはいけない金額</h2>
  <c:forEach var="user" items="${userlist}">
    ${user.name}に支払う金額は${pay[user.name]}円です
    <br>
  </c:forEach>
  <hr>
  <h2>払わなくてはいけない金額</h2>
  <c:forEach var="user" items="${userlist}">
    <c:choose>
      <c:when test="${pay[user.name]-paid[user.name] > 0}">
        ${user.name}に支払う金額は${pay[user.name]-paid[user.name]}円です。
        <br>
    </c:when>
    <c:when test="${pay[user.name]-paid[user.name] < 0}">
      ${user.name}からもらえる額は${paid[user.name]-pay[user.name]}円です。
      <br>
      </c:when>
    </c:choose>
  </c:forEach>

<%@include file="../footer.html" %>
