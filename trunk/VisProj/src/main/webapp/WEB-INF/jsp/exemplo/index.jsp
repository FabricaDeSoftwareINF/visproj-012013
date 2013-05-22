<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
    Nome:             <input type="text" name="gerenteDeProjeto.nome" value='${gerenteDeProjeto.nome}' /><br/>
    Email:    <input type="text" name="gerenteDeProjeto.email" value=${gerenteDeProjeto.email} /><br/>
    <input type="submit" value="Salvar" />
</form>
It works!! ${variable} ${linkTo[IndexController].index}
</body>
</html>