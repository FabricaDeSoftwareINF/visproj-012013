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
 * EnumStatusDoProjeto
 *
 * Representa o enumerador do status do projeto.
 *
 * A anotação @XmlRootElement significa que o classe é um elemento
 * raiz quando for convertida em um XML.
 *
 */ 
@XmlRootElement
public enum EnumStatusDoProjeto {

	/**
	 * O status sem alterações.
	 */
    SEM_ALTERACOES("Sem alterações"),
    
    /**
     * O status piorou.
     */
    PIOROU("Piorou"),
    
    /**
     * O status melhorou.
     */
    MELHOROU("Melhorou");

    private final String statusDoProjeto;

    private EnumStatusDoProjeto(String statusDoProjeto) {
        this.statusDoProjeto = statusDoProjeto;
    }

    //Método get
    public String getStatusDoProjeto() {
        return this.statusDoProjeto;
    }


}
