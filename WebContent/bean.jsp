<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="person" scope="application" class="isep.lab1.bean.Person"/>
	
	<jsp:setProperty property="firstname" value='<%=request.getParameter("firstname")%>' name="person"/>
	<jsp:setProperty property="lastname" value='<%=request.getParameter("lastname")%>' name="person"/>
	<jsp:setProperty property="birthdate" value='<%=request.getParameter("birthdate")%>' name="person"/>
	<jsp:setProperty property="sex" value='<%=request.getParameter("sex")%>' name="person"/>
	
	<jsp:getProperty property="firstname" name="person"/>
	<jsp:getProperty property="lastname" name="person"/>
	<jsp:getProperty property="birthdate" name="person"/>
	<jsp:getProperty property="sex" name="person"/>
</body>
</html>