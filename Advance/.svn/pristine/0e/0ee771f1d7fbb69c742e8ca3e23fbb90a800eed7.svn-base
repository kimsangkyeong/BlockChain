<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>관리자 메뉴 목록</title>
</head>
<body>
<h1>
	Admin 관리 화면 !!  
</h1>
<%
    String context = request.getContextPath();
%>
  <form  action="<%=context %>/usercreate" method=post>
     <table width = 30% border = 0 >
       <tr>
         <td align = right width =30%>
            userid :
         </td>
         <td align= left width = 70%>
            <input type="text" name="id" size=40 value="${inputId}">
         </td>
       </tr>
       <tr>
         <td align = right>
			메뉴1 : 
         </td>
         <td align = left>
            <a href="<%=context %>/admin/usermenu"> 사용자 등록화면으로 이동하기 </a>
         </td>
       </tr>
       <tr>
         <td align = right>
			메뉴2 : 
         </td>
         <td align = left>
            <input type="radio" name="menu1" size=50 value="주민 투표 관리화면으로 이동하기">"주민 투표 관리화면으로 이동하기"</input>
         </td>
       </tr>
       <tr>
         <td align = right>
			메뉴3 : 
         </td>
         <td align = left>
            <input type="radio" name="menu1" size=50 value="주민 투표 집계 화면으로 이동하기">"주민 투표 집계 화면으로 이동하기"</input>
         </td>
       </tr>
       <tr>
         <td colspan=2 align=right>
           <input type="submit" value="선택메뉴로 이동하기">
         </td>
       </tr>
     </table> 
  </form> 
</body>
</html>
