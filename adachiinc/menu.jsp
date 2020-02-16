<%@page contentType="text/html; charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css">
<%@include file="../header.html" %>
<div id=header>
    <a id="menu1" href="/adachiinc">Adachi inc.</a>
    <a id="menu2" href="../calendar/Calendar.action" style="font-size:20px;"><i class="fas fa-calendar-times"></i>スケジュール</a>
    <a id="menu2" href="../logout/logout-in.jsp" style="font-size:20px;"><i class="fas fa-sign-out-alt"></i>ログアウト</a>
    <a id="menu2" href="../menu/top.jsp" style="font-size:20px;"><i class="fas fa-sign-out-alt"></i>メニュー</a>
    <a id="menu2" href="../menu/calculation.jsp" style="font-size:20px;"><i class="fas fa-sign-out-alt"></i>計算</a>

  </div>

<hr>
<%@include file="../footer.html" %>
