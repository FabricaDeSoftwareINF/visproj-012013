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
public enum EnumStatusDoProjeto {

    SEM_ALTERACOES("Sem alterações"),
    PIOROU("Piorou"),
    MELHOROU("Melhorou");

    //Campo
    private final String statusDoProjeto;

    private EnumStatusDoProjeto(String statusDoProjeto) {
        this.statusDoProjeto = statusDoProjeto;
    }

    //Método get
    public String getStatusDoProjeto() {
        return this.statusDoProjeto;
    }


}
