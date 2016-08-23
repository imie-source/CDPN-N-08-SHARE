<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div style="display: inline-block;">
			<table>
				<c:forEach items="${persons}" var="person">
					<tr>
						<td>${person.nom}
						<td>
						<td>${person.prenom}
						<td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div style="display: inline-block;">
			<form method="post">
				<div>
					<label>nom</label><input type="text" name="lastName">
				</div>
				<div>
					<label>prenom</label><input type="text" name="firstName">
				</div>
				<input type="submit" value="add">
			</form>
		</div>
	</div>


</body>
</html>