/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.visproj.model;

/**
 * @author ArturPascualote
 */
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
