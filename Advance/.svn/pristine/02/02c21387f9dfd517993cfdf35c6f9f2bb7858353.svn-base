<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="java.util.ArrayList"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>coin</title>
<link rel="stylesheet" href="css/main.css" />

<style>
tr:nth-child(even) {
    background-color: #f2f2f2
}
</style>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

</head>

<body>
<%
    String context = request.getContextPath();
%>
<form name="myForm" action="<%=context%>/u_vote" method="POST">
<input type="hidden" name="id" value="${id}" />
</form>

<!-- <div class="box-content"> -->
<ul>
  <li><a href="<%=context%>/u_coin">Coin</a></li>
  <li><a href="#" onclick="javascript:document.myForm.submit();">설문/투표</a></li>
  <li><a href="<%=context%>/u_reservation">예약</a></li>
  <li style="float:right"><a class="active" href="#about">About</a></li>
</ul>
<div class="box-content">
<font class="bold">${name}</font>님 환영합니다.
</div>

</body>
</html>