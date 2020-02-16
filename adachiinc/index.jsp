<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
<%@include file="header.html" %>

<div id=header>
    Adachi Inc.
  </div>

<div id=login>
  <c:choose>
        <c:when test="${user == null}">
          <a href="login/login-in.jsp">ログイン</a>
          <br>
          <a href="register/register-in.jsp">会員登録</a>
          </c:when>
        <c:otherwise>${user.name}さん
          <br>
        <a href="logout/logout-in.jsp">ログアウト</a>
        <br>
        <a href="menu/Product.action">メニュー</a>
        <div id="menubar">
        <table rules="all">
          <td><a href="calendar/Calendar.action"><i class="fas fa-calendar-plus"></i>スケジュール</td></a>
          <a href="menu/Calculate.action"><i class="fas fa-sign-out-alt"></i>計算</a>
        </table>
      </div>
  </c:otherwise>
</c:choose>
</div>

<%@include file="footer.html" %>
