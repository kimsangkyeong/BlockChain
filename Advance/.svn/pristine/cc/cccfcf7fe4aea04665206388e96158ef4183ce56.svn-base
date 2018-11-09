<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>vote</title>
<link rel="stylesheet" href="css/main.css" />
</head>

<body>
<%
    String context = request.getContextPath();
%>
<form name="myForm" action="<%=context%>/u_vote" method="POST">
<input type="hidden" name="id" value="${id}" />
</form>

<ul>
  <li><a href="<%=context%>/u_coin">Coin</a></li>
  <li><a class="active" href="#" onclick="javascript:document.myForm.submit();">설문/투표</a></li>
  <li><a href="<%=context%>/u_reservation">예약</a></li>
  <li style="float:right"><a class="active" href="#about">About</a></li>
</ul>


vote

</body>
</html>