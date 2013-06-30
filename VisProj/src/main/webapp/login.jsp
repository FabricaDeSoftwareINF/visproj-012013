<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css" media="all"/>
<title><fmt:message key="login"/></title>
</head>
<body>

<c:set var="login">
    <fmt:message key="login"/>
</c:set>

<c:set var="senha">
    <fmt:message key="senha"/>
</c:set>
<input type="text"  placeholder="${login}"></input>
<input type="password"  placeholder='${senha}'></input>
</body>
</html>