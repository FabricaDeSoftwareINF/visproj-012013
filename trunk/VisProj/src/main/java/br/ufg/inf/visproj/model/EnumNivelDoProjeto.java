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
 * EnumNivelDoProjeto
 *
 * Representa o enumerador do nível do projeto.
 *
 * A anotação @XmlRootElement significa que o classe é um elemento
 * raiz quando for convertida em um XML.
 * 
 */ 
@XmlRootElement
public enum EnumNivelDoProjeto {

	/**
	 * O nível nenhum.
	 */
    NENHUM("Nenhum"),
    
    /**
     * O nível satisfatório.
     */
    SATISFATORIO("Satisfatório"),
    
    /**
     * O nível pouco satisfatório.
     */
    POUCO_SATISFATORIO("Pouco satisfatório"),
    
    /**
     * O nível insatisfatório.
     */
    INSATISFATORIO("Insatisfatório");


    private final String nivel;

    private EnumNivelDoProjeto(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return this.nivel;
    }
}
