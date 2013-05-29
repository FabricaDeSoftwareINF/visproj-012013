/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.visproj.model;

import java.util.Set;

/**
 * @author ArturPascualote
 */
public class Configuracao {

    private String equacao;
    private Set<String> metricas;
    private Nivel nivelInsatisfatorio;
    private Nivel nivelPoucoSatisfatorio;
    private Nivel nivelSatisfatorio;
    private String id;


    public Configuracao() {

    }

    public String getEquacao() {
        return equacao;
    }

    public void setEquacao(String equacao) {
        this.equacao = equacao;
    }

    public Set<String> getMetricas() {
        return metricas;
    }

    public void setMetricas(Set<String> metricas) {
        this.metricas = metricas;
    }

    public Nivel getNivelInsatisfatorio() {
        return nivelInsatisfatorio;
    }

    public void setNivelInsatisfatorio(Nivel nivelInsatisfatorio) {
        this.nivelInsatisfatorio = nivelInsatisfatorio;
    }

    public Nivel getNivelPoucoSatisfatorio() {
        return nivelPoucoSatisfatorio;
    }

    public void setNivelPoucoSatisfatorio(Nivel nivelPoucoSatisfatorio) {
        this.nivelPoucoSatisfatorio = nivelPoucoSatisfatorio;
    }

    public Nivel getNivelSatisfatorio() {
        return nivelSatisfatorio;
    }

    public void setNivelSatisfatorio(Nivel nivelSatisfatorio) {
        this.nivelSatisfatorio = nivelSatisfatorio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Configuracao)) {
            return false;
        }

        final Configuracao outraConfiguracao = (Configuracao) obj;

        if (getId() == null) {
            return false;
        }
        return getId().equals(outraConfiguracao.getId());
    }
}
