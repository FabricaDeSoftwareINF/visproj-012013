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
import java.util.Calendar;
import java.util.Map;

/**
 * Versao
 *
 * Representa a entidade Versao do projeto.
 *
 * A anotação @XmlRootElement significa que o classe é um elemento
 * raiz quando for convertida em um XML.
 *
 */ 
@XmlRootElement
public class Versao {
    private Calendar data;
    private float resultadoDaEquacao;
    private Map<String, Float> metricas;
    private EnumNivelDoProjeto nivel;

    /**
     * Inicia esta instância com o nível <code>EnumNivelDoProjeto.NENHUM</code>.
     */
    public Versao() {
        this.nivel = EnumNivelDoProjeto.NENHUM;
    }   

    /**
	 * @param data					A data da versão do projeto. 
	 * @param resultadoDaEquacao	O resultado da equação desta versão.
	 * @param metricas				As métricas desta versão do projeto.
	 * @param nivel					O nível desta versão do projeto.
	 * @see EnumNivelDoProjeto
	 */
	public Versao(Calendar data, float resultadoDaEquacao,
			Map<String, Float> metricas, EnumNivelDoProjeto nivel) {
		this.data = data;
		this.resultadoDaEquacao = resultadoDaEquacao;
		this.metricas = metricas;
		this.nivel = nivel;
	}

	public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Map<String, Float> getMetricas() {
        return metricas;
    }

    public void setMetricas(Map<String, Float> metricas) {
        this.metricas = metricas;
    }

    public EnumNivelDoProjeto getNivel() {
        return nivel;
    }

    public void setNivel(EnumNivelDoProjeto nivel) {
        this.nivel = nivel;
    }

    public float getResultadoDaEquacao() {
        return resultadoDaEquacao;
    }

    public void setResultadoDaEquacao(Float resultadoDaEquacao) {
        this.resultadoDaEquacao = resultadoDaEquacao;
    }


}
