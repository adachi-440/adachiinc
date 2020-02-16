<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/register-in.css">
<%@include file="../header.html" %>
<%@include file="../menu.jsp" %>

<div id="resister">
<form action="Register.action" method="post">

    ログインID
    <br>
      <input type="text" name="login" >

    <br>
    パスワード
    <br>
      <input type="password" name="password">

    <br>
    パスワード再入力
    <br>
    <input type="password" name="repassword">

    <br>
    氏名入力
    <br>
    <input type="text" name="name">
    <br>

<c:if test="${password == repassword}">
  <div id="buttom">
  <input type="submit" value="登録">
  </div>
</c:if>
  </form>
      </div>
<%@include file="../footer.html" %>
