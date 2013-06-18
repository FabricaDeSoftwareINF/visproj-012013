/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.visproj.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.Map;

/**
 * @author ArturPascualote
 */
@XmlRootElement
public class Versao {
    private Calendar data;
    private float resultadoDaEquacao;
    private Map<String, Float> metricas;
    private EnumNivelDoProjeto nivel;

    public Versao() {

        this.nivel = EnumNivelDoProjeto.NENHUM;

    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Map<String, Float> getMetricas() {
        return metricas;
    }

    public void setMetricas(Map<String, Float> metricas) {
        this.metricas = metricas;
    }

    public EnumNivelDoProjeto getNivel() {
        return nivel;
    }

    public void setNivel(EnumNivelDoProjeto nivel) {
        this.nivel = nivel;
    }

    public float getResultadoDaEquacao() {
        return resultadoDaEquacao;
    }

    public void setResultadoDaEquacao(Float resultadoDaEquacao) {
        this.resultadoDaEquacao = resultadoDaEquacao;
    }


}
