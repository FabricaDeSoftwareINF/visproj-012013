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
public enum EnumNivelDoProjeto {

    NENHUM("Nenhum"),
    SATISFATORIO("Satisfatório"),
    POUCO_SATISFATORIO("Pouco satisfatório"),
    INSATISFATORIO("Insatisfatório");


    private final String nivel;

    private EnumNivelDoProjeto(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return this.nivel;
    }
}
