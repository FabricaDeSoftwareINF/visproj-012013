package br.ufg.inf.visproj.controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.ufg.inf.visproj.model.GerenteDeProjeto;


@Resource
public class ExemploController {
	private final Result result;

	public ExemploController(Result result) {
		this.result = result;
	}

	@Path("/")
	public GerenteDeProjeto index() {
		GerenteDeProjeto gerente = new GerenteDeProjeto();
		gerente.setNome("joão da silva");
		gerente.setEmail("email");
		result.include("variable", "VRaptor!");
		return gerente;
	}
	
}
