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
 * Projeto
 *
 * Representa a entidade Projeto.
 *
 * A anotação @XmlRootElement significa que o classe é um elemento
 * raiz quando for convertida em um XML.
 *
 */ 
@XmlRootElement
public class Projeto {

    private GerenteDeProjeto gerenteDeProjeto;
    private EnumStatusDoProjeto statusDoProjeto;
    private Versao versaoAnterior;
    private Versao versaoAtual;
    private Configuracao configuracao;
    private String id;

    public Projeto() {
        this.statusDoProjeto = EnumStatusDoProjeto.SEM_ALTERACOES;
    }

    /**
     * @param gerenteDeProjeto 	O gerente de projeto.
     * @param statusDoProjeto	O status do projeto.
     * @param versaoAnterior	A versão anterior do projeto.
     * @param versaoAtual		A versão atual do projeto.
     * @param configuracao		A configuracao do projeto.
     * @param id				O id do projeto.
     * @see GerenteDeProjeto
     * @see EnumStatusDoProjeto
     * @see Versao
     * @see Configuracao
     */
    public Projeto(GerenteDeProjeto gerenteDeProjeto,
            EnumStatusDoProjeto statusDoProjeto, Versao versaoAnterior,
            Versao versaoAtual, Configuracao configuracao, String id) {
        this.gerenteDeProjeto = gerenteDeProjeto;
        this.statusDoProjeto = statusDoProjeto;
        this.versaoAnterior = versaoAnterior;
        this.versaoAtual = versaoAtual;
        this.configuracao = configuracao;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Configuracao configuracao) {
        this.configuracao = configuracao;
    }

    public GerenteDeProjeto getGerenteDeProjeto() {
        return gerenteDeProjeto;
    }

    public void setGerenteDeProjeto(GerenteDeProjeto gerenteDeProjeto) {
        this.gerenteDeProjeto = gerenteDeProjeto;
    }

    public EnumStatusDoProjeto getStatusDoProjeto() {
        return statusDoProjeto;
    }

    public void setStatusDoProjeto(EnumStatusDoProjeto statusDoProjeto) {
        this.statusDoProjeto = statusDoProjeto;
    }

    public Versao getVersaoAnterior() {
        return versaoAnterior;
    }

    public void setVersaoAnterior(Versao versaoAnterior) {
        this.versaoAnterior = versaoAnterior;
    }

    public Versao getVersaoAtual() {
        return versaoAtual;
    }

    public void setVersaoAtual(Versao versaoAtual) {
        this.versaoAtual = versaoAtual;
    }
}
