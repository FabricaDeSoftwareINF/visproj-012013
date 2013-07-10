<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css" media="all"/>
<link rel="stylesheet" href="css/footer.css" media="all"/>
<link rel="stylesheet" href="css/header.css" media="all"/>
<title><fmt:message key="login"/></title>
<style type="text/css">
	#label{
		width: 50px;
		padding-left: 20px;
		font-weight: bold;
		font-size: 13px;
		padding-bottom: 4px;
	}
	
	#usuario, #senha{
		display: inline-block;
		padding-left: 20px;
	}
	
	#divUsuario{
		padding-top: 25px;
	}
	
	#divUsuario input, #divSenha input{
		width: 277px;
	}
	
	#divLogin{
		margin-left: 28%;
		margin-top: 9%;
		width: 330px;
		max-width: 330px;
		height: 240px;
		max-height: 240px;
		border-width: 1px;
		border: 1px solid lightgrey;
		border-radius: 6px;
		background: #F1F1F1;
		display: inline-block;
	}
	
	#divBotaoLogin{
		padding: 10px 0 0 21px;
	}
	
	.botaoLogin{
		width: 100px;
	}
	
	#logo{
		float: left;
		margin-top: 100px;
		margin-left: 250px;
	}
	
	html, body{ height:100%;}	
	
	#content{
		max-height: 100%;
		height: 500px;
		overflow: hidden;
		margin-left: 28.5px;
		margin-right: 28.5px;
		padding-right: 34px;
		padding-left: 34px;
		padding-top: 23px;
	}
	
	#geral{
		min-height: 100%;
		position: relative;
	}
	
	.labelError{
		color:red;
	}
	
	.controls{
		margin-left: 100px !important;
	}
	
	.control-label{
		width: 80px !important;
	}
	
	.formContent{
		width: 350px;
		background-color: #F1F1F1;
		padding-top: 35px;
		padding-bottom: 6px;
		float: right;
		margin-top: 70px;
		border-radius: 8px;
	}
	
</style>
</head>

<body>

<c:set var="usuario">
    <fmt:message key="login"/>
</c:set>

<c:set var="senha">
    <fmt:message key="senha"/>
</c:set>
<div id="geral">
	<jsp:include page="../header.jsp"></jsp:include>
	<div id="content">
	<div id="logo">
		<img alt="imagem" src="img/visproj.png">
	</div>
	<div class="formContent">
		<form class="form-horizontal" action="<c:url value='/login'/>" method="POST">
		  <div class="control-group">
		  <div class="control-label">
		    <label for="inputUsuario">${usuario}</label>
		    </div>
		    <div class="controls">
		      <input type="text" name='login' id="inputUsuario" placeholder="${usuario}">
		    </div>
		  </div>
		  <div class="control-group">
		  <div class="control-label">
		    <label for="inputSenha">${senha}</label>
		    </div>
		    <div class="controls">
		      <input type="password" name='senha' id="inputSenha" placeholder="${senha}">
		    </div>
		  </div>
		  <div class="control-group">
		    <div class="controls">
		      <button type="submit" class="btn btn-primary">Login</button>
		    </div>
		  </div>
		  <div id="error" class="controls labelError">
		  		<c:forEach var="error" items="${errors}">
		  			${error.message}<br/>
		  		</c:forEach>
            </div>
		</form>
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>	
</div>

</body>
</html>