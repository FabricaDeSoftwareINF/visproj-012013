 /**
  * Esse documento é parte do código fonte e artefatos relacionados 
  * ao projeto VisProj, em desenvolvimento pela Fábrica de Software
  * da UFG.
  * 
  *  Links relevantes:
  *  Fábrica de Software: http://fs.inf.ufg.br/
  *  Instituto de Informática UFG: http://www.inf.ufg.br
  *
  * Copyleft © UFG.
  * 
  * Licenciado sobre a licença GNU-GPL v3
  *  * Você pode obter uma cópia da licença em 
http://www.gnu.org/licenses/gpl.html
  * 
  * A menos que especificado ou exigido por legislação local, o software é 
  * fornecido "da maneira que está", sem garantias ou condições de qualquer 
  * tipo, nem expressas nem implícitas. Em caso de dúvidas referir a licença 
GNU-GPL.
  */ 

package br.ufg.inf.visproj.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;
import br.ufg.inf.visproj.model.GerenteDeProjeto;

/**
 * Repositorio
 *
 * Esta classe tem o propósito de persistir ou obter dados do
 * repositório de arquivos e converter no objeto correspondente.
 *
 * A anotação @Resource do framework vraptor significa que a 
 * classe é um controller.
 *
 */ 
@Resource
public class ExemploController {
	
    private final Result result;
	private final Validator validator;

	public ExemploController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	/**
	 * 
	 * index - É o método que retorna a página padrão inicial do projeto.
	 * 
	 * @since 22/05/2013
	 */ 
	@Get
	@Path("/index.html")
	public void index() {
		GerenteDeProjeto gerente = new GerenteDeProjeto();
		gerente.setNome("joão da silva");
		gerente.setEmail("email");
		result.include("variable", "VRaptor!");
		System.out.println(Results.representation());
		result.use(Results.representation()).from(gerente).serialize();
	}
	
	/**
	 * atualizarConfiguracao - é o método que atualiza a configuração do projeto.
	 * 
	 * @param file
	 * 
	 * @since 13/06/2013
	 */ 
	@Post("/upload/file")
	public void atualizarConfiguracao(UploadedFile file) {
		//System.out.println("AKI MSM" + "    " + file);
		final boolean arquivoValido = file != null && file.getContentType().startsWith("image");
		validator.checking(new Validations(){
			{				
				that(arquivoValido,"erro", "arquivo.invalido");				
			}
		});
		System.out.println(file.getFileName());
		validator.onErrorRedirectTo(ExemploController.class).index();
		result.use(Results.representation()).from("teste").serialize();
		result.redirectTo(ExemploController.class).index();
	}	
}
