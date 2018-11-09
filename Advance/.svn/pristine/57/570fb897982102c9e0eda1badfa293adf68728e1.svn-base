<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <li><a href="/u_coin">Coin</a></li>
  <li><a class="active" href="#" onclick="javascript:document.myForm.submit();">설문/투표</a></li>
  <li><a href="/u_reservation">예약</a></li>
  <li style="float:right"><a class="active" href="#about">About</a></li>
</ul>


<div class="box-content">
[투표하기] 
  <br/><br/><br/>
  <form name="voting" action="<%=context %>/u_voting" method="POST">   
    <table class="table-datatable">
    <tr>
      <th align="center" class="table-datatable">♣♣♣♣ &nbsp&nbsp&nbsp&nbsp ${BallotContent.getIteminfo()} &nbsp&nbsp&nbsp&nbsp ♣♣♣♣ </th>
    </tr>
    </table>
    <br/><br/>
    <table class="table-datatable">
    <tr><td>
	    <c:if test="${not empty BallotItemContents}">
	      <c:forEach var="BallotItemContent" items="${BallotItemContents}">
			<tr align="left"><td><h4> <input type="radio" name="voteinfo"  value="${BallotItemContent.getBcandidate()}"> ${BallotItemContent.getItem()} <br/> </h4></td></tr>
	  	  </c:forEach>
	    </c:if>
    </td></tr>
    <tr><td>&nbsp</td></tr>
    <tr><td> <input type="submit" value="투표하기"> </td></tr>
    <input type="hidden" name="id" value="${id}" />
    <input type="hidden" name="vaid" value="${vaid}" />
    <input type="hidden" name="personbchacnt" value="${personbchacnt}" />
    </table>
  </form>  
</center>


</body>
</html>