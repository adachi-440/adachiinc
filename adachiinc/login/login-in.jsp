<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../menu.jsp" %>
<style>
#id{
  width: 100px;
  margin: 40px;

}
#id input{
  width:auto;
  padding: 20px;
}
</style>


<form action="Login.action" method="post">
  <p id="login">
  ID
  <br>
  <input type="text" name="login" >
  <br>
  PASSWORD
  <br>
  <input type="password" name="password">
  <br>
  <input type="submit" value="ログイン">
  </p>
</form>

<p id=forget>
アカウント登録は
<a href="../register/register-in.jsp">こちら
</a>
</p>
<%@include file="../footer.html" %>
