<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

</head>
<body>

<form action="mem" method="post">
<table>
	<tr>
		<td	>
			name<input type="text" name="m_name" value="${param.mem_name }" >
		</td>
	</tr>
	<tr>
		<td	>
			account<input type="text" name="m_account" value="${param.mem_account }" >
		</td>
	</tr>
	<tr>
		<td	>
			password<input type="text" name="m_pwsd" value="${param.mem_password }" >
		</td>
	</tr>
	<tr>
		<td>
		<input type="submit"  value="Correct">
		<input type="hidden" name="method" value="newMember">
		</td>
	</tr>
</table>
</form>

</body>
</html>