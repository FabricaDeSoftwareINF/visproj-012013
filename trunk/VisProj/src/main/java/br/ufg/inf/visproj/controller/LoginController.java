package br.ufg.inf.visproj.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

@Resource
public class LoginController {

	private final Result result;
	private final Validator validator;

	/**
	 * 
	 * @param result O result das requisições responsável pelo direcionamento de páginas.
	 * @param validator O validador padrão do framework vraptor.
	 * 
	 * @see Result
	 * @see Validator 
	 */
	public LoginController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}
	
	@Path("/home")
	public void home(){		
	}
	
	@Post
	@Path("/login")
	public void realizarLogin(String login, String senha){
		if(login.equals(senha)){
			System.out.println("funfa " + "-" + login + "-" + senha);
		}
		System.out.println("n funfa " + "-" + login + "-" + senha);
		final boolean autenticado = login.equals(senha) && !login.equals("");
		validator.checking(new Validations(){
			{				
				that(autenticado,"erro", "login.senha.invalidos");				
			}
		});
		
		validator.onErrorForwardTo(this).home();
		result.redirectTo(ProjetoController.class).home();
	}
}
