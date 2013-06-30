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

package br.ufg.inf.visproj.util;

import br.ufg.inf.visproj.model.*;
import java.util.*;

/**
 * FabricaDeObjetos
 *
 * Esta classe tem o propósito de servir como fábrica
 * para objetos comuns necessários nos testes.
 *
 */ 
public final class FabricaDeObjetos {

	private static final Float RESULTADO_EQUACAO_ANTERIOR = 80f;
	private static final Float RESULTADO_EQUACAO_ATUAL = 90f;
	private static final Float INICIO_VALOR_SATISFATORIO = 10f;
	private static final Float FIM_VALOR_SATISFATORIO = 100f;
	private static final Float INICIO_VALOR_INSATISFATORIO = 0f;
	private static final Float FIM_VALOR_INSATISFATORIO = 3f;
	private static final Float INICIO_VALOR_POUCO_SATISFATORIO = 4f;
	private static final Float FIM_VALOR_POUCO_SATISFATORIO = 10f;
	private static final boolean MELHORA_QUANDO_MAIOR = true;
	private static final Float METRICA_COMPLEXIDADE = 20f;
	
	private FabricaDeObjetos(){		
	}
	
	/**
	 * criarProjeto  -	Cria um projeto padrão com o id informado.
	 * @param id		O id do projeto.
	 * @return			O projeto criado.
	 * @see Projeto
	 */
    public static Projeto criarProjeto(String id) {
        Projeto projeto = new Projeto();
        projeto.setId(id);
        projeto.setConfiguracao(criarConfiguracao(id));
        projeto.setVersaoAtual(criarVersao(RESULTADO_EQUACAO_ATUAL));
        projeto.setVersaoAnterior(criarVersao(RESULTADO_EQUACAO_ANTERIOR));
        projeto.setGerenteDeProjeto(criarGerenteDeProjeto());
        return projeto;
    }

    /**
     * criarConfiguracao	Cria uma configuracao conforme id do projeto informado.
     * @param id			O id do projeto e da configuracao.
     * @return				A configuracao criada.
     * @see Configuracao
     */
    public static Configuracao criarConfiguracao(String id) {
        Configuracao config = new Configuracao();
        config.setId(id);
        config.setEquacao("equacao");
        config.setMetricas(criarMetricasConfiguracao());
        config.setNivelInsatisfatorio(new Nivel(INICIO_VALOR_SATISFATORIO, FIM_VALOR_SATISFATORIO, MELHORA_QUANDO_MAIOR));
        config.setNivelPoucoSatisfatorio(new Nivel(INICIO_VALOR_POUCO_SATISFATORIO, FIM_VALOR_POUCO_SATISFATORIO, MELHORA_QUANDO_MAIOR));
        config.setNivelSatisfatorio(new Nivel(INICIO_VALOR_INSATISFATORIO, FIM_VALOR_INSATISFATORIO, MELHORA_QUANDO_MAIOR));

        return config;
    }

    /**
     * criarMapMetricas  - 	Cria um map de métricas do projeto padrão.
     * @return 				O map das métricas com o tipo <code>String</code> sendo a chave 
     * 						e <code>Float</code> sendo o valor.
     */
    public static Map<String, Float> criarMapMetricas() {
        Map<String, Float> metricas = new HashMap<>();
        metricas.put("complexidade", METRICA_COMPLEXIDADE);

        return metricas;
    }

    /**
     * criarMetricasConfiguracao -	Cria um <code>Set</code> de métricas da configuração padrão.
     * @return						As métricas da configuração.
     */
    public static Set<String> criarMetricasConfiguracao() {
        Set<String> metricas = new HashSet<>();
        metricas.add("complexidade");
        return metricas;
    }

    /**
     * criarVersao - 				Cria uma versão do projeto.
     * @param 	resultadoEquacao	O resultado da equação.
     * @return 	A versão do projeto.
     * @see Versao
     */
    public static Versao criarVersao(Float resultadoEquacao) {
        Versao versao = new Versao();
        versao.setData(Calendar.getInstance());
        versao.setMetricas(criarMapMetricas());
        versao.setNivel(EnumNivelDoProjeto.SATISFATORIO);
        versao.setResultadoDaEquacao(resultadoEquacao);
        return versao;
    }

    /**
     * criarGerenteDeProjeto - Cria um gerente de projeto padrão.
     * @return O gerente de projeto.
     * @see GerenteDeProjeto
     */
    public static GerenteDeProjeto criarGerenteDeProjeto() {
        GerenteDeProjeto gerente = new GerenteDeProjeto();
        gerente.setNome("José da silva");
        gerente.setEmail("josedasilva@gmail.com");
        return gerente;
    }


}
