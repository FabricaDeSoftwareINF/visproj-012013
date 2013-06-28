<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>

    <link rel="stylesheet" href="css/bootstrap.min.css" media="all"/>
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" media="all"/>
    <style type="text/css">
    .carousel-inner .item{
    	background-color: #CC001B;
    	height: 768px;
    }
    
    .carousel{
    	margin-bottom:0;
    }
    .nomeDoProjeto{
    	font-size:100px;
    	color:white;
    }
    
    .cabecalho{
    	padding-top:40px;
    }
    .statusDoProjeto, .nomeDoProjeto{
    	display:inline-block;
    }
    </style>   
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="myCarousel" class="carousel slide">
  <ol class="carousel-indicators">
  </ol>
  <!-- Carousel items -->
  <div class="carousel-inner">
  </div>
  <!-- Carousel nav 
  <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
  <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
  -->
</div>
<script type="text/javascript">
var obtenhaImagemStatus = function(status){
	return "img/glyphicons-halflings.png";
};

var atribuirNivelDoProjeto = function(data){
	var cor = 'gray';
	switch(data.nivel){
		case 1:
			cor = 'yellow';
			break;
		case 2:
			cor = 'green';
			break;
		case 3:
			cor = 'red';
			break;
	}
	$(".item[data-codigo='" + data.codigo + "']").css('background-color',cor);
}

var obtenhaResultadoDoProjeto = function(data){	
	var statusProjeto = "<div class='statusDoProjeto'><img src='" + obtenhaImagemStatus(data.status) + "'></div>";
	var nomeProjeto = "<div class='nomeDoProjeto'>" + data.nomeDoProjeto + "</div>";
	var cabecalho = "<div class='cabecalho'>" + statusProjeto + nomeProjeto + "</div>";
	var resultado = "<div class='resultadoDoProjeto'>" + data.resultado + "</div>";
	var item = "<div class='item' data-codigo='" + data.codigo +"'>" + cabecalho + resultado + "</div>";
	return item;
};

var obtenhaIndicador = function(){
	var ultimaPosicao = $(".carousel-indicators li").length;
	
	var classe = "";
	if(!ultimaPosicao){
		ultimaPosicao = 0;
		classe = "class='active'";
	}
	return "<li data-target='#myCarousel' data-slide-to='" + ultimaPosicao + "' " + classe +"></li>";
};

var adicioneNovoItem = function(data){
	var numeroItens = $(".carousel-inner .item").length;	
	$(".carousel-inner").append(obtenhaResultadoDoProjeto(data));	
	$(".carousel-indicators").append(obtenhaIndicador());	
	if(!numeroItens){
		$(".item").css('class','active');
	}
	atribuirNivelDoProjeto(data);
};

$(function(){
	var data = [];
	data.nivel=0;
	data.nomeDoProjeto = "Projeto sem nivel";
	data.resultado = 90;
	data.codigo = 5;
	
	var data2 = [];
	data2.nivel=2;
	data2.nomeDoProjeto = "Projeto satisfatório";
	data2.resultado = 40;
	data2.codigo = 4;
	
	var data3 = [];
	data3.nivel=1;
	data3.nomeDoProjeto = "Projeto pouco satisfatório";
	data3.resultado = 30;
	data3.codigo = 3;
	
	var data4 = [];
	data4.nivel=3;
	data4.nomeDoProjeto = "Projeto insatisfatório";
	data4.resultado = 10;
	data4.codigo = 2;
	
	adicioneNovoItem(data);
	adicioneNovoItem(data2);
	adicioneNovoItem(data4);
	adicioneNovoItem(data3);
	
	$('.carousel').carousel({
		  interval: 2000
		});
	
});

</script>

</body>
</html>