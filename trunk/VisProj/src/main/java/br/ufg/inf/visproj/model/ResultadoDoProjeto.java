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

/**
 * ResultadoDoProjeto
 *
 * Representa a entidade Resultado do projeto.
 *
 * A anotação @XmlRootElement significa que o classe é um elemento
 * raiz quando for convertida em um XML.
 *
 */ 
public class ResultadoDoProjeto {
    
    private EnumNivelDoProjeto nivelDoProjeto;
    private EnumStatusDoProjeto statusDoProjeto;
    private float resultadoDaEquacao;

    public EnumNivelDoProjeto getNivelDoProjeto() {
        return nivelDoProjeto;
    }

    public void setNivelDoProjeto(EnumNivelDoProjeto nivelDoProjeto) {
        this.nivelDoProjeto = nivelDoProjeto;
    }

    public float getResultadoDaEquacao() {
        return resultadoDaEquacao;
    }

    public void setResultadoDaEquacao(float resultadoDaEquacao) {
        this.resultadoDaEquacao = resultadoDaEquacao;
    }

    public EnumStatusDoProjeto getStatusDoProjeto() {
        return statusDoProjeto;
    }

    public void setStatusDoProjeto(EnumStatusDoProjeto statusDoProjeto) {
        this.statusDoProjeto = statusDoProjeto;
    }
    
    
    
}
