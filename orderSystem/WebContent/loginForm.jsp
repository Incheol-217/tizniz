<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false" 
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />  
<%
request.setCharacterEncoding("UTF-8");
%>    
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/login/loginCheck.do">
  
        <fieldset>
            <legend> 로그인 </legend>
            <label for="user_id"> 아이디 </label>
            <input type="text" id="ts_id" name="ts_id" size="10" autofocus>

            <label for="user_pwd"> 비밀번호 </label>
            <input type="password" id="ts_pwd" name="ts_pwd"> <br>
            
            <input type="submit" value="로그인">
            <input type="reset" value="다시쓰기"> <br>
            <a href="member.jsp">회원가입</a>
        </fieldset>
        </form>

</body>
</html>