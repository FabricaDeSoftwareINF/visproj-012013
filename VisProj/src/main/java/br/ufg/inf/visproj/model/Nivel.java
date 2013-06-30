 /**
  * Esse documento é parte do código fonte e artefatos relacionados 
  * ao projeto VisProj, em desenvolvimento pela Fábrica de Software
  * da UFG.
  * 
  *  Links relevantes:
  *  Fábrica de Software: http://fs.inf.ufg.br/
  *  Instituto de Informática UFG: http://www.inf.ufg.br
  *
  * Copyleft © UFG.
  * 
  * Licenciado sobre a licença GNU-GPL v3
  *  * Você pode obter uma cópia da licença em 
http://www.gnu.org/licenses/gpl.html
  * 
  * A menos que especificado ou exigido por legislação local, o software é 
  * fornecido "da maneira que está", sem garantias ou condições de qualquer 
  * tipo, nem expressas nem implícitas. Em caso de dúvidas referir a licença 
GNU-GPL.
  */ 

package br.ufg.inf.visproj.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Nivel
 *
 * Representa a entidade nível do projeto.
 *
 * A anotação @XmlRootElement significa que o classe é um elemento
 * raiz quando for convertida em um XML.
 *
 */ 
@XmlRootElement
public class Nivel {

    private float valorInicial;
    private float valorFinal;
    private boolean melhorQuandoMaior;


    public Nivel() {
    }   

    /**
	 * @param valorInicial
	 * @param valorFinal
	 * @param melhorQuandoMaior
	 */
	public Nivel(float valorInicial, float valorFinal, boolean melhorQuandoMaior) {
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.melhorQuandoMaior = melhorQuandoMaior;
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
