/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.visproj.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ArturPascualote
 */
@XmlRootElement
public class GerenteDeProjeto {

    private String nome;
    private String email;

    public GerenteDeProjeto() {
    }    
    
    public GerenteDeProjeto(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}


	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    


}