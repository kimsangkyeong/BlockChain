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
<form name="myBallot" action="<%=context%>/u_ballot" method="POST">
<input type="hidden" name="id" value="${id}" />
<input type="hidden" name="vaid" value="none" />          <!-- �ϵ��ڵ��Ͽ���. summit �� ���� ������ �� �ֵ��� javascript ���� �ʿ� -->
<input type="hidden" name="ballotid" value="none" />  <!-- �ϵ��ڵ��Ͽ���. summit �� ���� ������ �� �ֵ��� javascript ���� �ʿ� -->
</form>

<script>
  function myBallotSubmit(vaId, ballotId){
//	  alert('before -> ' + document.myBallot.vaid.value + ':' + document.myBallot.ballotid.value);
	  document.myBallot.vaid.value = vaId;
	  document.myBallot.ballotid.value = ballotId;
//	  alert(document.myBallot.vaid.value + ':' + document.myBallot.ballotid.value);
 	  document.myBallot.submit();
	  return true;
  }
</script>
<ul>
  <li><a href="/u_coin">Coin</a></li>
  <li><a class="active" href="#" onclick="javascript:document.myForm.submit();">����/��ǥ</a></li>
  <li><a href="/u_reservation">����</a></li>
  <li style="float:right"><a class="active" href="#about">About</a></li>
</ul>


<div class="box-content">
[��ǥ���] 
  <table class="table-datatable">
    <tr>
      <th class="table-datatable" width="7%" align="center">����</th>
      <th class="table-datatable" width="24%" align="center">��ǥ����</th>
      <th class="table-datatable" width="38%" align="center">�� ����</th>
      <th class="table-datatable" width="10%" align="center">��ǥ���</th>
      <th class="table-datatable" width="7%" align="center">����</th>
      <th class="table-datatable" width="10%" align="center">Ȯ��</th>
    </tr>      
  <c:if test="${not empty contents}">
    <c:forEach var="content" items="${contents}">
      <tr>
		<td width="7%" align="center">${content.getVaid()}</td>
		<td width="24%" align="left">&nbsp&nbsp${content.getTitle()}</td>
		<td width="38%" align="left">&nbsp&nbsp${content.getDesp()}</td>
        <c:choose>
          <c:when test="${content.getVoterange() eq 'A'}">
             <td width="10%" align="center">��ü�ֹ�</td>
          </c:when>
          <c:otherwise>
             <td width="10%" align="center">${content.getVoterange()}���ֹ� </td>    
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${content.getVoteflag() eq 'Y' }">
            <td width="7%" style="color:blue" align="center">��ǥ�Ϸ�</td>
            <td width="10%" align="center"></td>
          </c:when>  
          <c:otherwise>
            <td width="7%" style="color:red"" align="center">�� ��ǥ</td>
            <td width="10%" align="center"><input type="button" onclick="myBallotSubmit('${content.getVaid()}','${content.getBallotid()}')" value="��ǥ�ϱ�"></td>
          </c:otherwise>  
        </c:choose>		
	  </tr>
	</c:forEach>
  </c:if>  
  </table>
</div>


</body>
</html>