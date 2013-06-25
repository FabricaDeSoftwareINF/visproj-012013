/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.visproj.model;

/**
 *
 * @author ArturPascualote
 */
public class ResultadoDoProjeto {
    
    private EnumNivelDoProjeto nivelDoProjeto;
    private EnumStatusDoProjeto statusDoProjeto;
    private float resultadoDaEquacao;

    public EnumNivelDoProjeto getNivelDoProjeto() {
        return nivelDoProjeto;
    }

    public void setNivelDoProjeto(EnumNivelDoProjeto nivelDoProjeto) {
        this.nivelDoProjeto = nivelDoProjeto;
    }

    public float getResultadoDaEquacao() {
        return resultadoDaEquacao;
    }

    public void setResultadoDaEquacao(float resultadoDaEquacao) {
        this.resultadoDaEquacao = resultadoDaEquacao;
    }

    public EnumStatusDoProjeto getStatusDoProjeto() {
        return statusDoProjeto;
    }

    public void setStatusDoProjeto(EnumStatusDoProjeto statusDoProjeto) {
        this.statusDoProjeto = statusDoProjeto;
    }
    
    
    
}
