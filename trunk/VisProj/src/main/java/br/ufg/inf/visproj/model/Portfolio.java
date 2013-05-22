/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.visproj.model;

import java.util.List;

/**
 *
 * @author ArturPascualote
 */
public class Portfolio {
    
    private List<Projeto> listaDeProjetos;

    public Portfolio() {
    }

    public List<Projeto> getListaDeProjetos() {
        return listaDeProjetos;
    }

    public void setListaDeProjetos(List<Projeto> listaDeProjetos) {
        this.listaDeProjetos = listaDeProjetos;
    }
    
    
}
