<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import=" java.util.*,sec01.ex01.*"%>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% request.setCharacterEncoding("utf-8"); %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<c:choose>
   <c:when test='${msg=="addMember" }'>
      <script>
         window.onload=function(){
            alert("회원을 등록했습니다.");
         }
      </script>
   </c:when>
   <c:when test='${msg=="modified" }'>
      <script>
        window.onload=function(){
          alert("회원 정보를 수정했습니다.");
        }
      </script>
   </c:when>
   <c:when test= '${msg=="deleted" }'>
      <script>
         window.onload=function(){
            alert("회원 정보를 삭제했습니다.");
        } 
      </script>
</c:when>
</c:choose>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table align="center" border="1" >
      <tr align="center" bgcolor="lightgreen">
         <td width="7%" ><b>아이디</b></td>
         <td width="7%" ><b>비밀번호</b></td>
         <td width="7%" ><b>빌딩이름</b></td>
         <td width="7%"><b>빌딩호수</b></td>
         <td width="7%" ><b>전화번호</b></td>
         <td width="7%" ><b>수정</b></td>
		 <td width="7%" ><b>삭제</b></td>
         
   </tr>
   
   <c:choose>
    <c:when test="${empty  membersList}" >
      <tr>
        <td colspan=5>
          <b>등록된 회원이 없습니다.</b>
       </td>  
      </tr>
   </c:when>  
   <c:when test="${!empty membersList}" >
      <c:forEach  var="mem" items="${membersList }" >
        <tr align="center">
          <td>${mem.ts_id }</td>
          <td>${mem.ts_pwd }</td>
          <td>${mem.ts_bdname}</td>     
          <td>${mem.ts_bdno }</td>     
          <td>${mem.ts_phone}</td>
          <td><a href="${contextPath}/login/modMemberForm.do?ts_id=${mem.ts_id }">수정</a></td>
		   <td><a href="${contextPath}/login/delMember.do?ts_id=${mem.ts_id }">삭제</a></td>
               
       </tr>
     </c:forEach>
</c:when>
</c:choose>
   </table>  
<a href="${contextPath }/member.jsp">회원 추가하기</a>

</body>
</html>