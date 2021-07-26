<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% request.setCharacterEncoding("utf-8"); %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/login/addMember.do">
<fieldset>
            <legend> 회원가입 </legend>
            <ul>
                <li> <label class="reg" for="ts_id"> 아이디 <em> * </em> </label>
                    <input type="text" id="ts_id" name="ts_id" size="20" autocomplete="on" required>
                </li>
                <li> <label class="reg" for="ts_pwd"> 비밀번호 <em> * </em> </label>
                    <input type="password" id="ts_pwd" name="ts_pwd" size="20" required>
                </li>
                
                <li> <label class="reg" for="ts_bdname"> 건물이름 <em> * </em> </label>
                    <input type="text" id="ts_bdname" name="ts_bdname" size="20" required>
                </li>
                <li> <label class="reg" for="ts_bdno"> 건물 호수 <em> * </em> </label>
                    <input type="text" id="ts_bdno" name="ts_bdno" size="20" required>
                </li>
                <li> <label class="reg" for="new_phone"> 전화 번호 </label>
                    <input type="tel" id="ts_phone" name="ts_phone" size="20" required>
                </li>
            </ul>
        </fieldset>
         

        <fieldset class="sendform">
            <input type="submit" value="가입하기">
            <input type="reset" value="다시쓰기">
            
        </fieldset>
</form>

</body>
</html>