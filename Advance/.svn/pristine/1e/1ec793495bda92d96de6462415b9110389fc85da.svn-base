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
  <li><a class="active" href="<%=context%>/u_coin">Coin</a></li>
  <li><a href="#" onclick="javascript:document.myForm.submit();">설문/투표</a></li>
  <li><a href="<%=context%>/u_reservation">예약</a></li>
  <li style="float:right"><a class="active" href="#about">About</a></li>
</ul>


<div class="box-content">
<font class="bold">${userId}</font>님의 현재잔액은 <font class="bold">${balance}</font>P 입니다.
</div>

<div class="box-content">
[이체하기] 
	<form id="CoinSend" name="CoinSend" method="post" action="/CoinSend">
		<div class="dropdown">
		  <select name=to_id>
		  	<option value=kimsw89>피트니스센터
		  	<option value=jlovej>엘레강스 헤어
		  	<option value=purecap>김상경(301동802호)
		  </select>
		</div>
		<input type=text name=value>P
		<input type="submit" class="btn btn-danger"  value="Send!" />
	</form>
	<i>${serverTime}</i>
</div>


<div class="box-content">
[최근 거래 내역]
	<!-- table style="border:1px solid #ccc" -->
	<table class="table-datatable" width=80%>
	    <colgroup>
	        <col width="30%"/>
	        <col width="30%"/>
	        <col width="20%"/>
	        <col width="20%"/>
	    </colgroup>
	    <thead>
	        <tr class="table-datatable">
	            <th class="table-datatable" scope="col">from</th>
	            <th class="table-datatable" scope="col">to</th>
	            <th class="table-datatable" scope="col">value</th>            
	            <th class="table-datatable" scope="col">날짜</th>   
	        </tr>
	    </thead>
	    <tbody>
	        <c:choose>
	            <c:when test="${fn:length(coinHist) > 0}">
	                <c:forEach items="${coinHist}" var="row">
	                    <tr class="table-datatable">
	                        <td>
		                        <c:if test="${row.from_id eq 'yongdol'}">yongdol</c:if>
		                        <c:if test="${row.from_id ne 'yongdol'}">${row.from_name}</c:if>
	                        </td>
	                        <td>
		                        <c:if test="${row.to_id eq 'yongdol'}">yongdol</c:if>
		                        <c:if test="${row.to_id ne 'yongdol'}">${row.to_name}</c:if>	                        
	                        </td> 
	                        <td align=right>${row.value}</td>	                        
	                        <td align=right>${row.dateTime}</td>
	                    </tr>
	                </c:forEach>
	            </c:when>
	            <c:otherwise>
	                <tr>
	                    <td colspan="4">조회된 결과가 없습니다.</td>
	                </tr>
	            </c:otherwise>
	        </c:choose>
	         
	    </tbody>
	</table>
</div>

</body>
</html>