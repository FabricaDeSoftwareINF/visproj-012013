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
import java.util.Set;

/**
 * Configuracao
 *
 * Representa a configuração do projeto.
 *
 * A anotação @XmlRootElement significa que o classe é um elemento
 * raiz quando for convertida em um XML.
 *
 */ 
@XmlRootElement
public class Configuracao {

    private String equacao;
    private Set<String> metricas;
    private Nivel nivelInsatisfatorio;
    private Nivel nivelPoucoSatisfatorio;
    private Nivel nivelSatisfatorio;
    private String id;


    public Configuracao() {
    }

    /**
	 * @param equacao
	 * @param metricas
	 * @param nivelInsatisfatorio
	 * @param nivelPoucoSatisfatorio
	 * @param nivelSatisfatorio
	 * @param id
	 */
	public Configuracao(String equacao, Set<String> metricas,
			Nivel nivelInsatisfatorio, Nivel nivelPoucoSatisfatorio,
			Nivel nivelSatisfatorio, String id) {
		this.equacao = equacao;
		this.metricas = metricas;
		this.nivelInsatisfatorio = nivelInsatisfatorio;
		this.nivelPoucoSatisfatorio = nivelPoucoSatisfatorio;
		this.nivelSatisfatorio = nivelSatisfatorio;
		this.id = id;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
