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
  <li><a class="active" href="<%=context%>/u_reservation">예약</a></li>
  <li style="float:right"><a class="active" href="#about">About</a></li>
</ul>


<div class="box-content">
<font class="bold">${userId}</font>님 예약시스템.
</div>

<div class="box-content">
[예약내역]
	<!-- table style="border:1px solid #ccc" -->
	<table class="table-datatable" width=80%>
	    <colgroup>
	        <col width="20%"/>
	        <col width="20%"/>
	        <col width="15%"/>
	        <col width="20%"/>
	    </colgroup>
	    <thead>
	        <tr class="table-datatable">
	            <th class="table-datatable" scope="col">이름</th>
	            <th class="table-datatable" scope="col">대여자</th>
	            <th class="table-datatable" scope="col">상태</th>            
	            <th class="table-datatable" scope="col">대여/반납</th>   
	        </tr>
	    </thead>
	    <tbody>
	        <c:choose>
	            <c:when test="${fn:length(reservationStatus) > 0}">
	                <c:forEach items="${reservationStatus}" var="row">
	                    <tr class="table-datatable">
	                        <!-- <td>${row.name }</td> -->
	                        <td>${row.discription }</td> 
	                        <td align=center>
	                       		<c:if test="${row.use_yn eq 'y'}">
		                            <c:if test="${row.use_id eq 'yongdol'}">yongdol</c:if>
		                            <c:if test="${row.use_id ne 'yongdol'}">*****</c:if>
	                            </c:if>
	                            <c:if test="${row.use_yn eq 'n'}">-</c:if>
	                        </td>	                        
	                        <td align=center>
	                            <c:if test="${row.use_yn eq 'y'}">대여중</c:if>
	                            <c:if test="${row.use_yn eq 'n'}">-</c:if>
	                        </td>
	                        <td align=center>
	                        	<c:if test="${row.use_yn eq 'y'}">
	                        		<c:if test="${row.use_id eq 'yongdol'}">
	                        			<form id="Reservation" name="Reservation" method="post" action="/rent">
											<input type="hidden" name="name" value="${row.name}" />   
		                        			<input type="hidden" name="action" value="return" />
		                        			<input type="submit" class="btn btn-primary"  value="반납" />
		                        		</form>
	                        		</c:if>
		                            <c:if test="${row.use_id ne 'yongdol'}">-</c:if>
	                        	</c:if>
	                        	<c:if test="${row.use_yn eq 'n'}">
									<form id="Reservation" name="Reservation" method="post" action="/rent">
										<input type="hidden" name="name" value="${row.name}" />    
		                        		<input type="hidden" name="action" value="rent" />
		                        		<input type="submit" class="btn btn-default"  value="대여" />
	                        		</form>
                        		</c:if>
	                        </td>
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