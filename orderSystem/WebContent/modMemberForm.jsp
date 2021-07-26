<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%> 
<head>
<meta charset="UTF-8">
<title>회원 정보 수정창</title>
<style>
  .cls1 {
     font-size:40px;
     text-align:center;
   }
</style>
</head>
<body>
 <h1 class="cls1">회원 정보 수정창</h1>
<form  method="post" action="${contextPath}/login/modMember.do?ts_id=${memInfo.ts_id}">
 <table align="center" >
   <tr>
     <td width="200"><p align="right" >아이디</td>
     <td width="400"><input   type="text" name="ts_id" value="${memInfo.ts_id}" disabled ></td>
     
   </tr>
 <tr>
     <td width="200"><p align="right" >비밀번호</td>
     <td width="400"><input   type="password" name="ts_pwd" value="${memInfo.ts_pwd} " disabled >
     </td>
   </tr>
   <tr>
     <td width="200"><p align="right">빌딩이름</td>
     <td width="400"><input   type="text" name="ts_bdname" value="${memInfo.ts_bdname}" ></td>
   </tr>
   <tr>
     <td width="200"><p align="right" >빌딩호수</td>
     <td width="400"><input   type="text" name="ts_bdno"  value="${memInfo.ts_bdno}" ></td>
   </tr>
   <tr>
     <td width="200"><p align="right" >전화번호<td>
     <td width="400"><input   type="text"  name="ts_phone" value="${memInfo.ts_phone }" disabled  ></td>
   </tr>
   <tr align="center" >
    <td colspan="2" width="400"><input type="submit" value="수정하기" >
       <input type="reset" value="다시입력" > </td>
   </tr>
 </table>
</form>
</html>