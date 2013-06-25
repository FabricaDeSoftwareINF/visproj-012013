package br.ufg.inf.visproj.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.IOUtils;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.HeaderParam;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.deserialization.Deserializes;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;
import br.ufg.inf.visproj.model.GerenteDeProjeto;
import br.ufg.inf.visproj.model.Nivel;


@Resource
public class ExemploController {
    private final Result result;
	private final Validator validator;
	private static final String PATH_FOTO = System.getProperty("user.home") + "/Pictures";

	public ExemploController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

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
	
	
	@Post("/upload/file")
	public void atualizarFoto(UploadedFile file) {
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
		//try {			
			//IOUtils.copy(file.getFile(), new FileOutputStream(new File(PATH_FOTO + "/" + file.getFileName())));
		//} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		result.redirectTo(ExemploController.class).index();
	}	
}
