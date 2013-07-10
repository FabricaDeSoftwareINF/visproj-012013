<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div id="${param.idModal}" class="modal hide fade modal-fileUpload">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3><fmt:message key='${param.title}'/></h3>
  </div>
  <form id="${param.idModal}form" action="<c:url value="${param.action}" />" method="POST"
              enctype="multipart/form-data">
  <div class="modal-body">  
            
    <div class="fileupload fileupload-new" data-provides="fileupload" id="fileupload">
                <div class="input-append">
                    <div class="uneditable-input span3">
                        <i class="icon-file fileupload-exists"></i>
                        <span class="fileupload-preview"></span>
                    </div>
			    <span class="btn btn-file btn-primary">
				    <span class="fileupload-new"><fmt:message key="selecione.o.arquivo"/></span>
				    <span class="fileupload-exists"><fmt:message key="alterar"/></span>
				    <input type="file" name="file" id="selecionarArquivo"/>
			    </span>
                    <a href="#" class="btn btn-primary fileupload-exists excluirArquivo" data-dismiss="fileupload"><fmt:message key="excluir"/></a>
                </div>
            </div>            
  </div>
  
  <div class="modal-footer">
    <a href="#" class="btn" data-dismiss="modal">Fechar</a>
    <button href="#" id="${param.idModal}Enviar" class="btn btn-primary"><i class="icon-white icon-upload"></i><fmt:message key="enviar.arquivo"/></button>
  </div>  
  </form>
  <iframe id='${param.idModal}Frame' style='display:none' name='${param.idModal}Frame' src=''></iframe>
</div>

