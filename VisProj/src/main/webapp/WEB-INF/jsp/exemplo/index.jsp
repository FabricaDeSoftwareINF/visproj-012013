<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-fileupload.min.js"></script>
    <script type="text/javascript" src="js/jquery.iframe-transport.js"></script>

    <link rel="stylesheet" href="css/bootstrap.min.css" media="all"/>
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" media="all"/>
    <link rel="stylesheet" href="css/bootstrap-fileupload.min.css"/>
    <link rel="stylesheet" href="css/jquery-ui-1.10.3.custom.min.css"/>

    <script type="text/javascript">
    </script>

    <title>Insert title here</title>
</head>
<body>
<div id="pagina" style="width:760px; margin:0 auto;">
    <div id="conteudo" style="padding:5px;padding-top:160px;">
        <form id="formFileupload" style="padding-left:150px" action="<c:url value='upload/file'/>" method="POST"
              enctype="multipart/form-data">
            <label for="fileupload">Arquivo de configuração:</label>

            <div class="fileupload fileupload-new" data-provides="fileupload" id="fileupload">
                <div class="input-append">
                    <div class="uneditable-input span3">
                        <i class="icon-file fileupload-exists"></i>
                        <span class="fileupload-preview"></span>
                    </div>
			    <span class="btn btn-file btn-primary">
				    <span class="fileupload-new">Selecione o arquivo</span>
				    <span class="fileupload-exists">Alterar</span>
				    <input type="file" name="file" id="selecionarArquivo"/>
			    </span>
                    <a href="#" class="btn btn-primary fileupload-exists" data-dismiss="fileupload">Excluir</a>
                </div>
            </div>
            <button href="#" class="btn btn-primary" style="margin-bottom:19px">
                <i class="icon-white icon-upload"></i>Enviar arquivo
            </button>
            <br/>

            <div id="error" class="label label-important">
                <c:forEach var="error" items="${errors}">
                    ${error.category} - ${error.message}<br/>
                </c:forEach>
            </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript">
    var limpeCampo = function () {
        if ($("#error").text().trim().length === 0) {
            $("#error").text("");
        }
    };
    $(function () {
        limpeCampo();
        $("#selecionarArquivo").on("click", function () {
            debugger;
            $("#error").text("");
        });

        debugger;
        $('#formFileupload').fileupload({
            url: 'upload/file',
            maxFileSize: 5000000,
            process: [
                {
                    action: 'load',
                    maxFileSize: 20000000
                },
                {
                    action: 'resize',
                    maxWidth: 1440,
                    maxHeight: 900
                },
                {
                    action: 'save'
                }
            ],
            completed: function (a, b) {
                debugger;
            },
            done: function (e, data) {
                data.context.text('Upload finished.');
                alert('upload finished');
            },
            progressall: function (e, data) {
                var progress = parseInt(data.loaded / data.total * 100, 10);
                $("#progress .barall").css('width', progress + '%');
            }
        });
    });
</script>
</html>