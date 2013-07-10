<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/custom.modernizr.js"></script>   

    <link rel="stylesheet" href="css/bootstrap.min.css" media="all"/>
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" media="all"/>
    <style type="text/css">
    @media all{
    
	    .carousel-inner>.item{
	    	background-color: #CC001B;
	    	height: 728px;
	    }
	    
	    .carousel.slide{
	    }
	    
	    .carousel{
	    	margin-bottom:0;
	    }
	    .nomeDoProjeto{
	    	color:white;
	    	font-size:200%;
	    	text-overflow: ellipsis;
			white-space: nowrap;
			width: 935px;
			height:70px;
			overflow: hidden;
			padding-top:10px;
			padding-bottom:10px;
			font-weight:100;
	    }
	    
	    .cabecalho{
	    	padding: 10% 0 0 12.5%;
	    	width:85%; 
	    	max-width: 100%;
	    }
	    
	    .statusDoProjeto{
	    	margin-right:4%;
	    }
	    
	    .statusDoProjeto img{
	    	padding-bottom: 100%;
	    }
	    .statusDoProjeto, .cabecalho .hNomeDoProjeto{
	    	display:inline-block;
	    }
	    
	    .cabecalho .hNomeDoProjeto{
	    }
	    
	    #myCarousel .carousel-control{
	    	display:none;
	    }
	    
	    #myCarousel:hover .carousel-control{
	    	display:block;
	    }
	    
	    #menu{
	    	background-color:black;
	    	height:30px;
	    }
	    
	    body{
	    background-color:black;
	    }
    }
    
    </style>   
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="projetos"/></title>
</head>
<body>
<div id="menu"></div>
<div id="myCarousel" class="carousel slide">
  <ol class="carousel-indicators">
  </ol>
   <!--Carousel items -->
  <div class="carousel-inner">
  </div>
  <!-- Carousel nav -->
  <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
  <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
  
</div>
<script type="text/javascript">

var obtenhaImagemStatus = function(status){
	var imagem = "";
	switch(status){
		case 1:
			imagem = "<img src='img/arrow_bottom_48.png'/>";
			break;
		case 2:
			imagem = "<img src='img/arrow_top_48.png'/>";
			break;
	}
	
	return imagem;
};

var atribuirNivelDoProjeto = function(data){
	var cor = 'gray';
	switch(data.nivel){
		case 1:
			cor = '#E5E500'; //amarelo
			break;
		case 2:
			cor = '#00E500'; //verde
			break;
		case 3:
			cor = '#E50000'; // vermelho
			break;
	}
	$(".item[data-codigo='" + data.codigo + "']").css('background-color',cor);
}

var obtenhaResultadoDoProjeto = function(data){	
	var statusProjeto = "<div class='statusDoProjeto'>" + obtenhaImagemStatus(data.status) + "</div>";
	var nomeProjeto = "<div class='nomeDoProjeto'>" + data.nomeDoProjeto + "</div>";
	var cabecalho = "<div class='cabecalho'>" + statusProjeto + "<h1 class='hNomeDoProjeto'>" + nomeProjeto + "</h1></div>";
	var resultado = "<div class='resultadoDoProjeto'>" + data.resultado + "</div>";
	var item = "<div class='item' data-codigo='" + data.codigo +"'>" + cabecalho + resultado + "</div>";
	return item;
};

var obtenhaIndicador = function(){
	var ultimaPosicao = $(".carousel-indicators li").length;
	
	var classe = "";
	if(!ultimaPosicao){
		ultimaPosicao =0 ;
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

$("#myCarousel").on("slide",function(a,b,c,d){
	debugger;
});

$("#myCarousel").on("slid",function(a,b,c,d){
	debugger;
	var ultimoCodigo = $($(this).find('.item')[$(this).find('.item').length-1]).data("codigo");
	var codigoAtual = $(this).find('.active').data("codigo");
	if(ultimoCodigo == codigoAtual){
		var a = "dispara Ajax";
	};
});

$(function(){
	var data = [];
	data.nivel=0;
	data.status=0;
	data.nomeDoProjeto = "Projeto sem nivel";
	data.resultado = 90;
	data.codigo = 5;
	
	var data2 = [];
	data2.status=1;
	data2.nivel=2;
	data2.nomeDoProjeto = "Projeto satisfatório";
	data2.resultado = 40;
	data2.codigo = 4;
	
	var data3 = [];
	data3.status=1;
	data3.nivel=1;
	data3.nomeDoProjeto = "Projeto pouco satisfatório byuvuyvyuvuyvyu";
	data3.resultado = 30;
	data3.codigo = 3;
	
	var data4 = [];
	data4.status=2;
	data4.nivel=3;
	data4.nomeDoProjeto = "Projeto insatisfatório";
	data4.resultado = 10;
	data4.codigo = 2;
	
	adicioneNovoItem(data);
	adicioneNovoItem(data2);
	adicioneNovoItem(data4);	
	adicioneNovoItem(data3);
	
	debugger;
	$('.carousel').carousel({
		  interval: 2000
		})
	
});

</script>


<!-- Check for Zepto support, load jQuery if necessary -->
</body>
</html>