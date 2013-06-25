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
public class Projeto {

    private GerenteDeProjeto gerenteDeProjeto;
    private EnumStatusDoProjeto statusDoProjeto;
    private Versao versaoAnterior;
    private Versao versaoAtual;
    private Configuracao configuracao;
    private String id;

    public Projeto() {
        this.statusDoProjeto = EnumStatusDoProjeto.SEM_ALTERACOES;
    }   

    /**
	 * @param gerenteDeProjeto
	 * @param statusDoProjeto
	 * @param versaoAnterior
	 * @param versaoAtual
	 * @param configuracao
	 * @param id
	 */
	public Projeto(GerenteDeProjeto gerenteDeProjeto,
			EnumStatusDoProjeto statusDoProjeto, Versao versaoAnterior,
			Versao versaoAtual, Configuracao configuracao, String id) {
		this.gerenteDeProjeto = gerenteDeProjeto;
		this.statusDoProjeto = statusDoProjeto;
		this.versaoAnterior = versaoAnterior;
		this.versaoAtual = versaoAtual;
		this.configuracao = configuracao;
		this.id = id;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Configuracao configuracao) {
        this.configuracao = configuracao;
    }

    public GerenteDeProjeto getGerenteDeProjeto() {
        return gerenteDeProjeto;
    }

    public void setGerenteDeProjeto(GerenteDeProjeto gerenteDeProjeto) {
        this.gerenteDeProjeto = gerenteDeProjeto;
    }

    public EnumStatusDoProjeto getStatusDoProjeto() {
        return statusDoProjeto;
    }

    public void setStatusDoProjeto(EnumStatusDoProjeto statusDoProjeto) {
        this.statusDoProjeto = statusDoProjeto;
    }

    public Versao getVersaoAnterior() {
        return versaoAnterior;
    }

    public void setVersaoAnterior(Versao versaoAnterior) {
        this.versaoAnterior = versaoAnterior;
    }

    public Versao getVersaoAtual() {
        return versaoAtual;
    }

    public void setVersaoAtual(Versao versaoAtual) {
        this.versaoAtual = versaoAtual;
    }


    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false; //nenhum objeto pode ser igual a null
        }
        if (!(obj instanceof Projeto)) { //um projeto s� pode ser igual a outro projeto
            return false;
        }

        final Projeto outroProjeto = (Projeto) obj;

        if (getId() == null) //se n�o houver Id n�o h� como testar os dois projetos
        {
            return false;
        }
        return getId().equals(outroProjeto.getId()); //dois projetos ser�o iguais se seus Id's forem iguais
    }

}
