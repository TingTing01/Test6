<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ page import="java.util.*" %>
<%@ page import="mem.model.*" %>

<%
	memDAO md =new memDAO();
	List<memVO> list =md.findAll();
	pageContext.setAttribute("list", list);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show all member</title>
</head>
<body>
<table border="1">
	<tr>
		<th>1</th>
		<th>2</th>
		<th>3</th>
		<th>3</th>
	</tr>
	<c:forEach var="memVO" items="${list }">
		<tr>
			<td>${memVO.mem_id }</td>
			<td>${memVO.mem_name }</td>
			<td>${memVO.mem_account }</td>
			<td>${memVO.mem_password }</td>
		</tr>	
</c:forEach>
</table>




</body>
</html>