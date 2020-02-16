<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/calendar.css">
<%@include file="../header.html" %>
<%@include file="../menu.jsp" %>



${user.name}さんの予定
<div class="currentmonth">
${calendar.year}年${calendar.month}月
</div>


<a href="../schedule/schedulein-in.jsp?YEAR=${calendar.year}&MONTH=${calendar.month}&DAY=${calendar.day}">
  <i class="far fa-calendar-plus"></i>今日のスケジュール
</a>

<div id="change">
  <table id="id">
  <td><a href="Calendar.action">今月</a></td>


<td>
  <form action="Calendar.action" method="post">
  <select name="year">
  <c:forEach var="i" begin="0" end="10">
      <option value="${calendar.year +i}">${calendar.year +i}</option>
  </c:forEach>
  </select>
年


</td>
<td>
  <select name="month">
    <c:forEach var="i" begin="1" end="12">
      <option value="${i}">${i}</option>
    </c:forEach>
</select>
  月　
<td><input type="submit" value="確定"></td>
</table>
</div>
</form>


<table id="calendar">
  <thead>
      <tr>
          <th>日曜日</th>
          <th>月曜日</th>
          <th>火曜日</th>
          <th>水曜日</th>
          <th>木曜日</th>
          <th>金曜日</th>
          <th>土曜日</th>
      </tr>

  </thead>
  <%--カレンダー1行目--%>
<tr id= "date">
  <c:if test="${calendar.lastdaycount !=0}">
    <c:forEach var="n" begin="0" end="${calendar.lastdaycount-1}">
    <td id="otherday">${calendar.viewday[n]}</td>
    </c:forEach>
  </c:if>

  <c:forEach  var="i" begin="${calendar.lastdaycount}" end ="6">
  <td>${calendar.viewday[i]}</td>
  </c:forEach>

</tr>
<%--先月の予定 --%>
<tr id="plan">
<c:if test="${calendar.lastdaycount !=0}">
    <c:forEach var="i" begin="0" end="${calendar.lastdaycount-1}">
    <td>
      <c:choose>
        <%--年越さない--%>
        <c:when test="${calendar.month !=1}">
          <a href="../schedule/schedulein-in.jsp?YEAR=${calendar.year}&MONTH=${calendar.month -1}&DAY=${calendar.viewday[i]}">
            <i class="far fa-calendar-plus"></i>
                  </a><br>
            <c:forEach var="schedule" items="${list}">
              <c:if test="${schedule.year == calendar.year &&schedule.month == calendar.month-1 &&schedule.day == calendar.viewday[i] }">
                <a href="../detail/detail.jsp?ID=${schedule.id}&YEAR=${calendar.year}&MONTH=${calendar.month-1}&DAY=${calendar.viewday[i]}">${schedule.name}</a>
            　出勤${schedule.starttime}<br>
              </c:if>
            </c:forEach>
        </c:when>
        <c:otherwise>
          <%--年越す--%>
            <a href="../schedule/schedulein-in.jsp?YEAR=${calendar.year -1}&MONTH=${calendar.month +11}&DAY=${calendar.viewday[i]}">
              <i class="far fa-calendar-plus"></i>
                    </a><br>
              <c:forEach var="schedule" items="${list}">
                <c:if test="${schedule.year == calendar.year-1 &&schedule.month == calendar.month+11 &&schedule.day == calendar.viewday[i] }">
                  <a href="../detail/detail.jsp?ID=${schedule.id}&YEAR=${calendar.year-1}&MONTH=${calendar.month+11}&DAY=${calendar.viewday[i]}">${schedule.name}</a>
              　出勤${schedule.starttime}<br>
                </c:if>
              </c:forEach>
        </c:otherwise>
      </c:choose>
    </td>
    </c:forEach>
</c:if>

<%--今月の予定 --%>
<c:forEach var="i" begin="${calendar.lastdaycount}" end="6">
<td>
  <a href="../schedule/schedulein-in.jsp?YEAR=${calendar.year}&MONTH=${calendar.month}&DAY=${calendar.viewday[i]}">
  <i class="far fa-calendar-plus"></i>
  </a><br>
  <c:forEach var="schedule" items="${list}">
    <c:if test="${schedule.year == calendar.year &&schedule.month == calendar.month && schedule.day == calendar.viewday[i]}">
      <a href="../detail/detail.jsp?ID=${schedule.id}&YEAR=${calendar.year}&MONTH=${calendar.month}&DAY=${calendar.viewday[i]}">${schedule.name}</a>
  　出勤${schedule.starttime}<br>
    </c:if>
  </c:forEach>
</td>
</c:forEach>
</tr>


<%--カレンダー2,3,4行目--%>
<c:forEach var="m" begin="0" end="2">

<tr id="date">
<c:forEach var="l" begin="7" end="13">
    <td>${calendar.viewday[l+7*m]}
    </td>
</c:forEach>
  </tr>
      <tr id="plan">
        <c:forEach var="i" begin="7" end="13">
        <td>
          <a href="../schedule/schedulein-in.jsp?YEAR=${calendar.year}&MONTH=${calendar.month}&DAY=${calendar.viewday[i+7*m]}">
          <i class="far fa-calendar-plus"></i>
          </a><br>

          <c:forEach var="schedule" items="${list}">
            <c:if test="${schedule.year == calendar.year &&schedule.month == calendar.month && schedule.day == calendar.viewday[i+7*m]}">
              <a href="../detail/detail.jsp?ID=${schedule.id}&YEAR=${calendar.year}&MONTH=${calendar.month}&DAY=${calendar.viewday[i]}">${schedule.name}</a>
          　出勤${schedule.starttime}<br>
            </c:if>
          </c:forEach>
        </td>
        </c:forEach>
      </tr>
</c:forEach>


<%--カレンダー5行目--%>
<%--35マスパターン--%>
<c:choose>
  <c:when test="${calendar.curdaycount <= 36}">
<%--今月の日付 --%>
<tr id= "date">
  <c:forEach var="n" begin="28" end="${calendar.curdaycount-2}">
  <td>${calendar.viewday[n]}</td>
  </c:forEach>

<%--来月の日付 --%>
  <c:forEach var="n" begin="${calendar.curdaycount-1}" end="34">
  <td id="otherday">${calendar.viewday[n]}</td>
  </c:forEach>

<%--今月の予定 --%>
  <tr id="plan">
    <c:forEach var="i" begin="28" end="${calendar.curdaycount-2}">
      <td>
        <a href="../schedule/schedulein-in.jsp?YEAR=${calendar.year}&MONTH=${calendar.month}&DAY=${calendar.viewday[i]}">
        <i class="far fa-calendar-plus"></i>
        </a><br>

        <c:forEach var="schedule" items="${list}">
          <c:if test="${schedule.year == calendar.year &&schedule.month == calendar.month && schedule.day == calendar.viewday[i]}">
            <a href="../detail/detail.jsp?ID=${schedule.id}&YEAR=${calendar.year}&MONTH=${calendar.month}&DAY=${calendar.viewday[i]}">${schedule.name}</a>
        　出勤${schedule.starttime}<br>
          </c:if>
        </c:forEach>
      </td>
    </c:forEach>

  <%--来月の予定--%>
    <c:forEach var="i" begin="${calendar.curdaycount-1}" end="34">
      <td>
      <c:choose>
        <%--年越さない--%>
        <c:when test="${calendar.month !=12}">
          <a href="../schedule/schedulein-in.jsp?YEAR=${calendar.year}&MONTH=${calendar.month+1}&DAY=${calendar.viewday[i]}">
          <i class="far fa-calendar-plus"></i>
          </a><br>
          <c:forEach var="schedule" items="${list}">
            <c:if test="${schedule.year == calendar.year &&schedule.month == calendar.month+1 && schedule.day == calendar.viewday[i]}">
              <a href="../detail/detail.jsp?ID=${schedule.id}&YEAR=${calendar.year}&MONTH=${calendar.month+1}&DAY=${calendar.viewday[i]}">${schedule.name}</a>
          　出勤${schedule.starttime}<br>
            </c:if>
          </c:forEach>
        </c:when>
        <%--年越す--%>
        <c:otherwise>
          <a href="../schedule/schedulein-in.jsp?YEAR=${calendar.year+1}&MONTH=${calendar.month-11}&DAY=${calendar.viewday[i]}">
          <i class="far fa-calendar-plus"></i>
          </a><br>
          <c:forEach var="schedule" items="${list}">
            <c:if test="${schedule.year == calendar.year+1 &&schedule.month == calendar.month-11 && schedule.day == calendar.viewday[i]}">
              <a href="../detail/detail.jsp?ID=${schedule.id}&YEAR=${calendar.year+1}&MONTH=${calendar.month-11}&DAY=${calendar.viewday[i]}">${schedule.name}</a>
          　出勤${schedule.starttime}<br>
            </c:if>
          </c:forEach>
        </c:otherwise>
      </c:choose>
      </td>
    </c:forEach>
  </tr>



</c:when>


<%--42マスパターン--%>
<%--5段目--%>
  <c:otherwise>
  <tr id= "date">
      <c:forEach var="n" begin="28" end="34">
      <td>${calendar.viewday[n]}</td>
      </c:forEach>
  </tr>
  <%--今月の予定--%>
  <tr id="plan">
    <c:forEach var="i" begin="28" end="34">
    <td>
      <a href="../schedule/schedulein-in.jsp?YEAR=${calendar.year}&MONTH=${calendar.month}&DAY=${calendar.viewday[i]}">
      <i class="far fa-calendar-plus"></i>
      </a><br>

      <c:forEach var="schedule" items="${list}">
        <c:if test="${schedule.year == calendar.year &&schedule.month == calendar.month && schedule.day == calendar.viewday[i]}">
          <a href="../detail/detail.jsp?ID=${schedule.id}&YEAR=${calendar.year}&MONTH=${calendar.month}&DAY=${calendar.viewday[i]}">${schedule.name}</a>
      　出勤${schedule.starttime}<br>
        </c:if>
      </c:forEach>
    </td>
    </c:forEach>
</tr>

<%--6段目--%>
<%--今月の日付--%>
  <tr id="date">
  <c:forEach var="n" begin="35" end="${calendar.curdaycount-2}">
    <td>${calendar.viewday[n]}</td>
  </c:forEach>
<%--来月の日付--%>
<c:forEach var="n" begin="${calendar.curdaycount-1}" end="41">
  <td id="otherday">${calendar.viewday[n]}</td>
  </c:forEach>
</tr>

<tr id="plan">
  <%--今月の予定--%>
  <c:forEach var="i" begin="35" end="${calendar.curdaycount-2}">
    <td>
      <a href="../schedule/schedulein-in.jsp?YEAR=${calendar.year}&MONTH=${calendar.month}&DAY=${calendar.viewday[i]}">
      <i class="far fa-calendar-plus"></i>
      </a><br>
      <c:forEach var="schedule" items="${list}">
        <c:if test="${schedule.year == calendar.year &&schedule.month == calendar.month && schedule.day == calendar.viewday[i]}">
          <a href="../detail/detail.jsp?ID=${schedule.id}&YEAR=${calendar.year}&MONTH=${calendar.month}&DAY=${calendar.viewday[i]}">${schedule.name}</a>
      　出勤${schedule.starttime}<br>
        </c:if>
      </c:forEach>
    </td>
  </c:forEach>

<%--来月の予定--%>
  <c:forEach var="i" begin="${calendar.curdaycount-1}" end="41">

    <td>
    <c:choose>
      <c:when test="${calendar.month !=12}">
        <a href="../schedule/schedulein-in.jsp?YEAR=${calendar.year}&MONTH=${calendar.month+1}&DAY=${calendar.viewday[i]}">
        <i class="far fa-calendar-plus"></i>
        </a><br>
            <c:forEach var="schedule" items="${list}">
              <c:if test="${schedule.year == calendar.year &&schedule.month == calendar.month+1 &&schedule.day == calendar.viewday[i]}">
                <a href="../detail/detail.jsp?ID=${schedule.id}&YEAR=${calendar.year}&MONTH=${calendar.month}&DAY=${calendar.viewday[i]}">${schedule.name}</a>
            　出勤${schedule.starttime}<br>
              </c:if>
            </c:forEach>
      </c:when>
      <c:otherwise>
        <a href="../schedule/schedulein-in.jsp?YEAR=${calendar.year+1}&MONTH=${calendar.month-11}&DAY=${calendar.viewday[i]}">
        <i class="far fa-calendar-plus"></i>
      </a><br>
            <c:forEach var="schedule" items="${list}">
              <c:if test="${schedule.year == calendar.year+1 &&schedule.month == calendar.month-11 &&schedule.day == calendar.viewday[i]}">
                <a href="../detail/detail.jsp?ID=${schedule.id}&YEAR=${calendar.year}&MONTH=${calendar.month}&DAY=${calendar.viewday[i]}">${schedule.name}</a>
            　出勤${schedule.starttime}<br>
              </c:if>
            </c:forEach>
      </c:otherwise>
    </c:choose>
    </td>
  </c:forEach>
</tr>

  </c:otherwise>
</c:choose>
</table>

<%@include file="../footer.html" %>
