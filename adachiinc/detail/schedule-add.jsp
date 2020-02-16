<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../menu.jsp" %>

<table>
<form action="../schedule/ScheduleAdd.action?ID=${param.ID}" method="post">
  <br>
    <div>
<select name="shour">
  <c:forEach var="i" begin="0" end="23">
    <option value="${i}">${i}</option>
  </c:forEach>
</select>時

<select name="smin">
  <c:forEach var="i" begin="0" end="59">
    <option value="${i}">${i}</option>
  </c:forEach>
</select>分
<br>

<select name="ehour">
  <c:forEach var="i" begin="0" end="23">
    <option value="${i}">${i}</option>
  </c:forEach>
</select>時

<select name="emin">
  <c:forEach var="i" begin="0" end="59">
    <option value="${i}">${i}</option>
  </c:forEach>
</select>分

</select>

<br>
  予定<input type="text" name="plan">
<br>
<textarea name="memo" rows="10" cols="100"></textarea>

<input type="submit" value="確定">
</div>
</form>
</table>

<%@include file="../footer.html" %>
