<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VisProj</title>
	<link rel="stylesheet" href="../css/footer.css" media="all"/>
	<link rel="stylesheet" href="../css/header.css" media="all"/>
	<link rel="stylesheet" href="../css/bootstrap.min.css" media="all"/>
    <link rel="stylesheet" href="../css/bootstrap-responsive.min.css" media="all"/>
    <link rel="stylesheet" href="../css/bootstrap-fileupload.min.css"/>
    <link rel="stylesheet" href="../css/jquery-ui-1.10.3.custom.min.css"/>
    <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap-fileupload.min.js"></script>
    <script type="text/javascript" src="../js/jquery.iframe-transport.js"></script>
	
<style type="text/css">
	#geral{
			min-height: 100%;
			position: relative;
		}
	#content{
			max-height: 100%;
			height: 500px;
			overflow: hidden;
	}
	
	#logo{
		float: left;
		margin-top: 100px;
		margin-left: 250px;
	}
	
	html, body{ height:100%;}
	
	.logoff {
		float: right;
	    padding-right: 10px;
	    padding-top: 10px;
	    text-decoration: underline;
	}
	
	.icon-white{
		background-image: url("../img/glyphicons-halflings-white.png");
	}
	
	.modal form{
		margin:0;
	}
</style>
</head>
<body>
<c:set  var="idConfiguracao" value="configuracao"></c:set>
<c:set  var="idProjeto" value="projeto"></c:set>

<div id="geral">
<div id="content">
<a class="logoff" href="#" style="">Sair</a>
<div class="navbar">
  <div class="navbar-inner">
    <a class="brand" href="#">VisProj</a>
    <ul class="nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#${idConfiguracao}" data-toggle="modal">Configuração</a></li>
      <li><a href='#${idProjeto}' data-toggle='modal'>Dados do projeto</a></li>
    </ul>
  </div>
</div>

<div id="logo">
		<img alt="imagem" src="../img/visproj.png">
	</div>
	<jsp:include page="../modalFileUpload.jsp">
	<jsp:param name="title" value="arquivo.de.configuracao" />
	<jsp:param name="idModal" value="${idConfiguracao}" />
	<jsp:param name="action" value="../upload/file" />
</jsp:include>
<jsp:include page="../modalFileUpload.jsp">
	<jsp:param name="title" value="arquivo.de.dados.projeto" />
	<jsp:param name="idModal" value="${idProjeto}"/>
	<jsp:param name="action" value="../upload/file" />
</jsp:include>
</div>


<jsp:include page="../footer.jsp"></jsp:include>
</div>
<script type="text/javascript">


	$('.modal-fileUpload').on('hidden', function () {
		debugger;
		  $(".excluirArquivo").trigger("click");
		});
		
	$("#configuracaoFrame").load(function(a,b){
		debugger;
		//pegar os dados do results e jogar na tela ou fechar a tela.
	});		
	
	$("#configuracaoEnviar").on("click", function(event){
		debugger;
		$("#content #configuracao form").attr('target', 'configuracaoFrame');
		$("#content #configuracao form").submit();		
	});
	
	$("#projetoFrame").load(function(a,b){
		//pegar os dados do results e jogar na tela ou fechar a tela.
	});	
	
	$("#projetoEnviar").on("click", function(event){
		$("#content #projeto form").attr('target', 'projetoFrame');
		$("#content #projeto form").submit();		
	});
	
</script>
</body>
</html>