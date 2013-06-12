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
public class Nivel {

    private float valorInicial;
    private float valorFinal;
    private boolean melhorQuandoMaior;


    public Nivel() {


    }

    public boolean isMelhorQuandoMaior() {
        return melhorQuandoMaior;
    }

    public void setMelhorQuandoMaior(boolean melhorQuandoMaior) {
        this.melhorQuandoMaior = melhorQuandoMaior;
    }


    public float getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(float valorFinal) {
        this.valorFinal = valorFinal;
    }

    public float getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(float valorInicial) {
        this.valorInicial = valorInicial;
    }


}
