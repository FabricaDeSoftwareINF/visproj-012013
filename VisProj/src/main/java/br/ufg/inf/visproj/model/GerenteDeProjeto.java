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
 * GerenteDeProjeto
 *
 * Representa a entidade Gerente de projeto.
 *
 * A anotação @XmlRootElement significa que o classe é um elemento
 * raiz quando for convertida em um XML.
 *
 */ 
@XmlRootElement
public class GerenteDeProjeto {

    private String nome;
    private String email;

    public GerenteDeProjeto() {
    }    
    
    /**
     * 
     * @param nome O nome do gerente.
     * @param email O email do gerente.
     */
    public GerenteDeProjeto(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}


	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    


}
