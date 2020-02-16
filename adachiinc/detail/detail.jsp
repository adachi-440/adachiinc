<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../menu.jsp" %>
${user.name}さんの${param.YEAR}年${param.MONTH}月${param.DAY}日の予定${schedule.id}


<c:forEach var="schedule" items="${list}"><br>
  <c:if test="${schedule.year == param.YEAR && schedule.month == param.MONTH && schedule.day == param.DAY}">
  <table border="3" width="600">
  <tr align="center">
    <th>開始時間</th>
    <th>終了時間</th>
    <th>予定</th>
    <th>メモ</th>
  </tr>
  <tr align="center">
    <td>${schedule.starttime}</td>
    <td>${schedule.endtime}</td>
    <td>${schedule.plan}</td>
    <td>${schedule.memo}</td>
  </tr>
</table>
</c:if>
</c:forEach>

<p><a href="schedule-add.jsp?ID=${param.ID}">変更</a></p>
<p><a href="../schedule/ScheduleDrop.action?ID=${param.ID}">削除</a></p>

<%@include file="../footer.html" %>
